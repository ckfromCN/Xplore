package com.example.user.xplore.fragment;


import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class Posts {


    /* 
     头像网络地址
    */
    private String iconImgUrl;

    public String getIconImgUrl() {
        return iconImgUrl;
    }

    public void setIconImgUrl(String iconImgUrl) {
        this.iconImgUrl = iconImgUrl;
    }

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
    private String readNumber;


    /*
     视频截图资源id
     */
    private String videoImgUrl;

    /*
    点赞人数
     */
    private String likeNumber;

    /*
    标题
     */
    private String title;


    /*
    评论人数
    */
    private String commentNumber;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*
        地址
         */
    private String location;

    public String getVideoImgUrl() {


        return videoImgUrl;
    }

    public void setVideoImgUrl(String videoImgUrl) {
        this.videoImgUrl = videoImgUrl;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*
    返回月份
     */
    public String getPostTime() {
        // 2015-11-25 16:53:37
        String date = postTime.substring(5, 10);
        return date;
    }

    public String getContent() {
        return content;
    }

    /*
    设置content的时候解析数据保存
     */
    public void setContent(String content,XmlPullParserFactory xppf) {
        this.content = content;
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            //得到DocumentBuilder对象
//            DocumentBuilder builder = null;
//
//            builder = factory.newDocumentBuilder();
//
//            //得到代表整个xml的Document对象
//            Document document = builder.parse(new ByteArrayInputStream(content.getBytes()));
//            //得到 "根节点" 
//            Element root = document.getDocumentElement();
//            String width=root.getAttribute("width");
//            //获取根节点的所有items的节点
//            videoUrl = root.getAttribute("src");
//            videoImgUrl = root.getAttribute("poster");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            XmlPullParser xpp= xppf.newInstance().newPullParser();
            xpp.setInput(new StringReader(content));
            // 直到文档的结尾处
            while (xpp.getEventType() != XmlResourceParser.END_DOCUMENT) {
                // 如果遇到了开始标签
                if (xpp.getEventType() == XmlResourceParser.START_TAG) {
                    String tagName = xpp.getName();// 获取标签的名字
                    if (tagName.equals("video")) {
                        videoImgUrl= xpp.getAttributeValue(null, "poster") ;// 通过属性名来获取属性值
                     }
                }
                xpp.next();// 获取解析下一个事件
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String videoUrl;
    /*
    内容,包含返回视频截图Url和设置参数和视频Url
     */
    private String content;

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getReadNumber() {

        return readNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReadNumber(String readNumber) {
        this.readNumber = readNumber;
    }


    public String getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

}
