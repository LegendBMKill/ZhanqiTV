package com.jason.zhanqitv.bean;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class BannerBean {

    /**
     * id : 16179
     * roomId : 0
     * chnId : 0
     * spic : https://img1.zhanqi.tv/uploads/2017/08/20310-2017081611164113813.jpeg
     * title : 卧虎藏龙贰今日首发
     * gameId : 0
     * url : #game#
     * type : 2
     */

    private String id;
    private String roomId;
    private String chnId;
    private String spic;
    private String title;
    private String gameId;
    private String url;
    private String type;
    private BannerBean room;
    /**
     * uid : 104252094
     * code : 152566573
     * videoId : 152416_B2SpV
     * flashvars : null
     */

    private String uid;
    private String code;
    private String videoId;
    private Object flashvars;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getChnId() {
        return chnId;
    }

    public void setChnId(String chnId) {
        this.chnId = chnId;
    }

    public String getSpic() {
        return spic;
    }

    public void setSpic(String spic) {
        this.spic = spic;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BannerBean getRoom() {
        return room;
    }

    public void setRoom(BannerBean room) {
        this.room = room;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Object getFlashvars() {
        return flashvars;
    }

    public void setFlashvars(Object flashvars) {
        this.flashvars = flashvars;
    }
}
