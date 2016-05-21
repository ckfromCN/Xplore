package com.example.user.xplore.util;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.user.xplore.fragment.Posts;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.List;

/**
 * Created by user on 2016/5/20.
 */
public class HttpUtli {
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<Posts> handPostsResponse(JSONObject response, List<Posts> postsList) {
        try {

            XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();

            JSONArray jsonArray = response.getJSONArray("posts");
            for (int i = 0; i < jsonArray.length(); i++) {
                Posts post = new Posts();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject userJsonObj = jsonObject.getJSONObject("user");
                post.setIconImgUrl(userJsonObj.getString("url"));
                post.setUserName(userJsonObj.getString("nickname"));
                post.setPostTime(jsonObject.getString("date"));
                post.setReadNumber(jsonObject.getString("visit_count"));
                post.setLocation(jsonObject.getString("location"));
                post.setTitle(jsonObject.getString("title"));
                post.setContent(jsonObject.getString("content"), xppf);
                post.setLikeNumber(jsonObject.getString("post_likes_count"));
                post.setCommentNumber(jsonObject.getString("comment_count"));
                postsList.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return postsList;
    }
}
