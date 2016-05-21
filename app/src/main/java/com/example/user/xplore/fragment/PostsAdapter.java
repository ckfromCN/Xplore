package com.example.user.xplore.fragment;


import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.user.xplore.R;

import java.util.List;

public class PostsAdapter extends ArrayAdapter<Posts> {

    private ImageLoader mImageLoader;
    private int resourceId;

    public PostsAdapter(Context context, int resource, List<Posts> objects) {
        super(context, resource, objects);
        RequestQueue queue = Volley.newRequestQueue(context);
        mImageLoader = new ImageLoader(queue, new BitmapCache());
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Posts post = getItem(position);
        viewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new viewHolder();
            viewHolder.videoImg = (NetworkImageView) convertView.findViewById(R.id.video_picture);
            viewHolder.iconImg = (NetworkImageView) convertView.findViewById(R.id.icon);
            viewHolder.location_img = (ImageView) convertView.findViewById(R.id.location_img);
            viewHolder.userName = (TextView) convertView.findViewById(R.id.user_name);
            viewHolder.postTime = (TextView) convertView.findViewById(R.id.post_time);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.readNum = (TextView) convertView.findViewById(R.id.read_number);
            viewHolder.likeNum = (TextView) convertView.findViewById(R.id.like_number);
            viewHolder.commentNum = (TextView) convertView.findViewById(R.id.comment_number);
            viewHolder.location = (TextView) convertView.findViewById(R.id.location_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
        }
        viewHolder.videoImg.setDefaultImageResId(R.drawable.image_unload);
        viewHolder.videoImg.setErrorImageResId(R.drawable.image_unload);
        viewHolder.videoImg.setImageUrl(post.getVideoImgUrl(), mImageLoader);
        viewHolder.userName.setText(post.getUserName());
        viewHolder.postTime.setText(post.getPostTime());
        viewHolder.readNum.setText(post.getReadNumber());
        viewHolder.likeNum.setText(post.getLikeNumber());
        viewHolder.commentNum.setText(post.getCommentNumber());
        viewHolder.iconImg.setErrorImageResId(R.drawable.icon_user_head);
        viewHolder.iconImg.setDefaultImageResId(R.drawable.icon_user_head);
        viewHolder.iconImg.setImageUrl(post.getIconImgUrl(), mImageLoader);
        if (!TextUtils.isEmpty(post.getTitle())){
            viewHolder.title.setVisibility(View.VISIBLE);
            viewHolder.title.setText(post.getTitle());
        }
        if (!TextUtils.isEmpty(post.getLocation())) {
            viewHolder.location_img.setVisibility(View.VISIBLE);
            viewHolder.location.setText(post.getLocation());
        }
        return convertView;
    }

    class viewHolder {
        NetworkImageView videoImg, iconImg;
        TextView userName, postTime, readNum, likeNum, commentNum, title, location;
        ImageView location_img;
    }

    public class BitmapCache implements ImageLoader.ImageCache {


        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            // 获取应用程序最大可用内存  
            int maxMemory = (int) Runtime.getRuntime().maxMemory();
            int cacheSize = maxMemory / 5;
            mCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String s) {
            return null;
        }

        @Override
        public void putBitmap(String s, Bitmap bitmap) {

        }
    }

}
