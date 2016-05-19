package com.example.user.xplore.fragment;

/**
 * Created by user on 2016/5/19.
 */
public class Posts {

    /*
        头像资源id
         */
    private int iconResourceId;

    /*
    用户名
     */
    private String userName;

    /*
    发布时间
     */
    private String postTime;

    /*
    围观人数
     */
    private int readNumber;

    /*
    视频截图资源id
     */
    private int vedioResourceId;

    /*
    点赞人数
     */
    private int likeNumber;

    /*
    评论人数
     */
    private int commentNumber;
    
    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public int getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(int readNumber) {
        this.readNumber = readNumber;
    }

    public int getVedioResourceId() {
        return vedioResourceId;
    }

    public void setVedioResourceId(int vedioResourceId) {
        this.vedioResourceId = vedioResourceId;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

}
