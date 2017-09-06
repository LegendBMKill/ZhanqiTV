package com.jason.zhanqitv.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jason on 2017/8/31 0031.
 */

public class GameListInfo implements Serializable {

    /**
     * cnt : 797
     * rooms : []
     */

    private int cnt;
    private List<GameListInfo> rooms;
    /**
     * id : 36596
     * uid : 104677512
     * nickname : lyingman
     * gender : 2
     * avatar : https://img2.zhanqi.tv/avatar/da/760/104677512_1476260143.jpg
     * code : 1142071
     * url : /topic/lyingman
     * title : Lanstory现场Lyingman舞台 第三日
     * gameId : 132
     * spic : https://img3.zhanqi.tv/live/20170830/36596_2017-08-30-17-39-59.jpg
     * bpic : https://img3.zhanqi.tv/live/20170830/36596_2017-08-30-17-39-59_big.jpg
     * online : 20241
     * status : 4
     * hotsLevel : 26
     * videoId : 36596_HD3eX
     * verscr : 0
     * anchorCoverImg :
     * classId : 2
     * className : 移动游戏
     * newGameName : 狼人杀
     * fatherGameId : 104
     * fatherGameName : 狼人杀
     * childGameId : 132
     * childGameName : Lyingman
     * gameName : Lyingman
     * line : eyJjZG5zIjoyMDIsIm91dGNkbnMiOjQyLCJyYXRlIjoiMjAyfDIwMiJ9
     * location : 杭州
     */

    private String id;
    private String uid;
    private String nickname;
    private String gender;
    private String avatar;
    private String code;
    private String url;
    private String title;
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
    private String childGameId;
    private String childGameName;
    private String gameName;
    private String line;
    private String location;


    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<GameListInfo> getRooms() {
        return rooms;
    }

    public void setRooms(List<GameListInfo> rooms) {
        this.rooms = rooms;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getChildGameId() {
        return childGameId;
    }

    public void setChildGameId(String childGameId) {
        this.childGameId = childGameId;
    }

    public String getChildGameName() {
        return childGameName;
    }

    public void setChildGameName(String childGameName) {
        this.childGameName = childGameName;
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
}
