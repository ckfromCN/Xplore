package com.example.user.xplore.fragment;

/**
 * Created by user on 2016/5/19.
 */
public class Posts {

    /*
        ͷ����Դid
         */
    private int iconResourceId;

    /*
    �û���
     */
    private String userName;

    /*
    ����ʱ��
     */
    private String postTime;

    /*
    Χ������
     */
    private int readNumber;

    /*
    ��Ƶ��ͼ��Դid
     */
    private int vedioResourceId;

    /*
    ��������
     */
    private int likeNumber;

    /*
    ��������
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
