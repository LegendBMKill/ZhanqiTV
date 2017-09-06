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
    private List<GameListInfo> lists;

    public List<GameListInfo> getLists() {
        return lists;
    }

    public void setLists(List<GameListInfo> lists) {
        this.lists = lists;
    }

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
}
