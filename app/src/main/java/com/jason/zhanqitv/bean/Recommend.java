package com.jason.zhanqitv.bean;

import java.util.List;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class Recommend {

    /**
     * keyword : v2app.livenow
     * title : 热门直播
     * icon : https://img1.zhanqi.tv/uploads/2017/04/positionicon-2017040111140883689.png
     * channelIds : null
     * gameIds : ["65"]
     * lists : []
     */

    private String keyword;
    private String title;
    private String icon;
    private String channelIds;
    private String gameIds;
    private List<Recommend> lists;

    /**
     * id : 237252
     * uid : 38619754
     * nickname : 战旗夜涩
     * gender : 2
     * avatar : https://img2.zhanqi.tv/avatar/b2/24b/38619754_1503128129.jpg
     * code : 152649651
     * url : /152649651
     * gameId : 6
     * spic : https://img3.zhanqi.tv/live/20170830/237252_2017-08-30-14-48-06.jpg
     * bpic : https://img3.zhanqi.tv/live/20170830/237252_2017-08-30-14-48-06_big.jpg
     * online : 1159
     * status : 4
     * hotsLevel : 7
     * videoId : 237252_EL241
     * verscr : 0
     * anchorCoverImg :
     * classId : 1
     * className : 热门竞技
     * newGameName : 英雄联盟
     * fatherGameId : 6
     * fatherGameName : 英雄联盟
     * gameName : 英雄联盟
     * line : eyJjZG5zIjoxNzIsIm91dGNkbnMiOjQyLCJyYXRlIjoiIn0=
     * location : 香港
     */

    private String id;
    private String uid;
    private String nickname;
    private String gender;
    private String avatar;
    private String code;
    private String url;
    private String gameId;
    private String spic;
    private String bpic;
    private String online;
    private String status;
    private String hotsLevel;
    private String videoId;
    private String verscr;
    private String anchorCoverImg;
    private String classId;
    private String className;
    private String newGameName;
    private String fatherGameId;
    private String fatherGameName;
    private String gameName;
    private String line;
    private String location;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(String channelIds) {
        this.channelIds = channelIds;
    }

    public String getGameIds() {
        return gameIds;
    }

    public void setGameIds(String gameIds) {
        this.gameIds = gameIds;
    }

    public List<Recommend> getLists() {
        return lists;
    }

    public void setLists(List<Recommend> lists) {
        this.lists = lists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getSpic() {
        return spic;
    }

    public void setSpic(String spic) {
        this.spic = spic;
    }

    public String getBpic() {
        return bpic;
    }

    public void setBpic(String bpic) {
        this.bpic = bpic;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHotsLevel() {
        return hotsLevel;
    }

    public void setHotsLevel(String hotsLevel) {
        this.hotsLevel = hotsLevel;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVerscr() {
        return verscr;
    }

    public void setVerscr(String verscr) {
        this.verscr = verscr;
    }

    public String getAnchorCoverImg() {
        return anchorCoverImg;
    }

    public void setAnchorCoverImg(String anchorCoverImg) {
        this.anchorCoverImg = anchorCoverImg;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNewGameName() {
        return newGameName;
    }

    public void setNewGameName(String newGameName) {
        this.newGameName = newGameName;
    }

    public String getFatherGameId() {
        return fatherGameId;
    }

    public void setFatherGameId(String fatherGameId) {
        this.fatherGameId = fatherGameId;
    }

    public String getFatherGameName() {
        return fatherGameName;
    }

    public void setFatherGameName(String fatherGameName) {
        this.fatherGameName = fatherGameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "keyword='" + keyword + '\'' +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", channelIds='" + channelIds + '\'' +
                ", gameIds='" + gameIds + '\'' +
                ", lists=" + lists +
                ", id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", avatar='" + avatar + '\'' +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", gameId='" + gameId + '\'' +
                ", spic='" + spic + '\'' +
                ", bpic='" + bpic + '\'' +
                ", online='" + online + '\'' +
                ", status='" + status + '\'' +
                ", hotsLevel='" + hotsLevel + '\'' +
                ", videoId='" + videoId + '\'' +
                ", verscr='" + verscr + '\'' +
                ", anchorCoverImg='" + anchorCoverImg + '\'' +
                ", classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", newGameName='" + newGameName + '\'' +
                ", fatherGameId='" + fatherGameId + '\'' +
                ", fatherGameName='" + fatherGameName + '\'' +
                ", gameName='" + gameName + '\'' +
                ", line='" + line + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
