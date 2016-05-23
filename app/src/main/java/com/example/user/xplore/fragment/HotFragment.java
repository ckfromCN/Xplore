package com.example.user.xplore.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.xplore.R;
import com.example.user.xplore.util.HttpUtli;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends Fragment {
    private List<Posts> postsList = new ArrayList<Posts>();

    private ListView xpListView;

    private PostsAdapter postsAdapter;

    private RequestQueue mQueue;


    private ProgressDialog progressDialog;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        postsAdapter = new PostsAdapter(activity, R.layout.xp_list_view, postsList);
        mQueue = Volley.newRequestQueue(activity);

        //new一个JsonObjectRequest对象,并添加到队列中

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://124.161.103.254/sns/api/" +
                "get_posts_by_limit/?start=0&number=20", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //处理返回数据并返回对象
                        postsList = HttpUtli.handPostsResponse(response, postsList);
                       // xpListView.onRefreshComplete();
                        postsAdapter.notifyDataSetChanged();
                        xpListView.setVisibility(View.VISIBLE);
                        //关闭进度对话框
                        closeProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "网络请求错误", Toast.LENGTH_SHORT).show();
                Log.e("TAG", error.getMessage(), error);
            }
        });

        mQueue.add(jsonObjectRequest);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View hotLayout = inflater.inflate(R.layout.xp_tab1_fragment, container, false);
       // xpListView = (PullToRefreshListView) hotLayout.findViewById(R.id.xp_listview);
        xpListView= (ListView) hotLayout.findViewById(R.id.xp_listview);
        //xpListView.setEmptyView(hotLayout.findViewById(R.id.empty));
//        xpListView.setOnPullEventListener(new PullToRefreshBase.OnPullEventListener<ListView>() {
//            @Override
//            public void onPullEvent(PullToRefreshBase<ListView> refreshView, PullToRefreshBase.
//                    State state, PullToRefreshBase.Mode direction) {
//                LogUtil.d("HotFragment", "onPullEvent() : " + state.name());
//
//                if (state.equals(PullToRefreshBase.State.PULL_TO_REFRESH)) {
//                    refreshView.getLoadingLayoutProxy().setPullLabel("pull_to_refresh");
//                    refreshView.getLoadingLayoutProxy().setReleaseLabel("release_to_refresh");
//                    refreshView.getLoadingLayoutProxy().setRefreshingLabel("loading");
//
//                    String label = DateUtils.formatDateTime(getApplicationContext(),
//                            System.currentTimeMillis(),
//                          DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
//                    // Update the LastUpdatedLabel  
//                   refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
//                            getString(R.string.updated) + " : " + label);
//                }
//
//            }
//        });
       /* xpListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                Log.d("HotFragment", "onRefresh()");

                String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel  
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                // Do work to refresh the list here.  
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://124.161.103.254/sns/api/" +
                        "get_posts_by_limit/?start=0&number=20", null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //处理返回数据并返回对象
                                postsList = HttpUtli.handPostsResponse(response, postsList);
                                postsAdapter.notifyDataSetChanged();
                                xpListView.onRefreshComplete();
                                // xpListView.setVisibility(View.VISIBLE);
                                //关闭进度对话框
                                closeProgressDialog();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "网络请求错误", Toast.LENGTH_SHORT).show();
                        Log.e("TAG", error.getMessage(), error);
                    }
                });

                mQueue.add(jsonObjectRequest);
            }
        });*/
        showProgressDialog();
        return hotLayout;
    }


    /**
     * 显示进度对话框
     */
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


}
