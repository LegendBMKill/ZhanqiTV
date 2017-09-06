package com.jason.zhanqitv.mvp.fragment;

import com.jason.zhanqitv.R;
import com.jason.zhanqitv.base.BaseFragment;
import com.jason.zhanqitv.mvp.presenter.HomePresenter;
import com.jason.zhanqitv.mvp.view.IHomeView;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jason on 2017/8/25 0025.
 */

public class VideoFragment extends BaseFragment<IHomeView, HomePresenter> implements IHomeView {


//    @BindView(R.id.home_tab)
//    TabLayout mHomeTab;
//    @BindView(R.id.home_vp)
//    ViewPager mHomeVp;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
//        String[] tabs = presenter.getTabs();
//        List<Fragment> fragments = new ArrayList<>();
//
//        for (int i = 0; i < tabs.length; i++) {
//            fragments.add(i==0?new HomeRecommendFragment():new HomeGameFragment(tabs[i]));
//        }
//
//        mHomeTab.setupWithViewPager(mHomeVp);
//        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter(getActivity().getSupportFragmentManager(),fragments,tabs);
//        mHomeVp.setAdapter(pagerAdapter);
//        mHomeTab.setupWithViewPager(mHomeVp);
//        mHomeTab.setTabsFromPagerAdapter(pagerAdapter);

        String centerUrl2 = "http://wshdl.load.cdn.zhanqi.tv/zqlive/50035_ZLdbp.flv?get_url=1";
        //737_CGq78
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                String centerUrl2 = "http://wshdl.load.cdn.zhanqi.tv/zqlive/50035_ZLdbp.flv?get_url=1";
                //737_CGq78
                String liveUrl = getContentByUrl(centerUrl2);
                e.onNext(liveUrl);
            }
        }).subscribeOn(Schedulers.io())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Logger.d(s);

            }
        });


    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }


    /* 根据战旗的roomid获得战旗高清播放地址
       * @param roomId
       * @return
       */
    public String getZhanQiLiveAddress(String roomId) {
        String centerUrl = "http://www.zhanqi.tv/api/static/live.roomid/" + roomId + ".json?sid=";
        //737
        String content = getContentByUrl(centerUrl);

        /**  房间直播信息访问后返回的信息如下
         *
         *
         * {
         *   "code":0,"
         *   message":"",
         *   "data":{
         *     "id":"737",
         *     "uid":"566711",
         *     "nickname":"DD ",
         *     "gender":"2",
         *     "avatar":"http:\/\/pic.cdn.zhanqi.tv\/avatar\/6e\/a9a\/566711_1407847801.jpg",
         *     "code":"11808","domain":"naigege","url":"\/naigege","title":"奶哥哥直播间","gameId":"10",
         *     "spic":"http:\/\/dlpic.cdn.zhanqi.tv\/\/live\/20150224\/737_CGq78_2015-02-24-17-17-40.jpg",
         *     "bpic":"http:\/\/dlpic.cdn.zhanqi.tv\/\/live\/20150224\/737_CGq78_2015-02-24-17-17-40_big.jpg",
         *     "template":"dd","online":"103798","status":"4","level":"2","type":"1","liveTime":"0","userGroup":"1",
         *     "allowRecord":"0","allowVideo":"0","publishUrl":"dlrtmp",
         *     "videoId":"737_CGq78",
         *     "chatStatus":"1",
         *     "roomNotice":null,
         *     "roomCover":"http:\/\/pic.cdn.zhanqi.tv\/room_cover\/576705958ffd5dd523068ff7491b9f9c.jpg",
         *     "roomCoverType":"1","addTime":"2014-07-25 05:27:12","gameName":"Dota2","gameUrl":"\/games\/dota2",
         *     "gameIcon":"http:\/\/dlpic.cdn.zhanqi.tv\/uploads\/2014\/08\/gameicon-2014080620013913475.png",
         *     "gameBpic":"http:\/\/dlpic.cdn.zhanqi.tv\/uploads\/2015\/02\/gamebpic-2015020823344296805.jpeg",
         *     "videoIdKey":"737_CGq78","permission":{"fans":true,"guess":false,"replay":false,"multi":false,"shift":false},
         *     "fansTitle":"奶粉",
         *     "flashvars":{"Servers":"eyJsb2ciOnsiaXAiOiIxMTMuMzEuODcuODYiLCJwb3J0IjoxNTAwMX0sImxpc3QiOlt7ImlwIjoiMTEzLjMxLjg3Ljg2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyLCJpZCI6Mn0seyJpcCI6IjExNS4yOS4xNjcuMTc5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyMSwiaWQiOjIxfSx7ImlwIjoiMTE0LjIxNS4xNzkuMjE4IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyMiwiaWQiOjIyfSx7ImlwIjoiMTE1LjI5LjE3Mi42IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyMywiaWQiOjIzfSx7ImlwIjoiMTE1LjI5LjE2OS4yMjgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjI0LCJpZCI6MjR9LHsiaXAiOiIxMTUuMjkuMTQ0LjI0MSIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MjYsImlkIjoyNn0seyJpcCI6IjExNS4yOC4zMi43IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyNywiaWQiOjI3fSx7ImlwIjoiMTE0LjIxNS4xMzkuMzgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjI4LCJpZCI6Mjh9LHsiaXAiOiIxMjEuNDIuMTAuMjIzIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyOSwiaWQiOjI5fSx7ImlwIjoiMTgyLjkyLjE0OS4yNSIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MzEsImlkIjozMX0seyJpcCI6IjE4Mi45Mi4yMzEuMTY2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozMiwiaWQiOjMyfSx7ImlwIjoiMTgyLjkyLjIyMC4xMzkiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjMzLCJpZCI6MzN9LHsiaXAiOiIxMjMuNTYuODYuMjU0IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozNCwiaWQiOjM0fV19",
         *     "ServerIp":[],"ServerPort":[],"ChatRoomId":[],"UseDlReview":1,
         *     "VideoLevels":"eyJtdWxyYXRlIjpbWyJkbF9saXZlIiwicnRtcCIsIjczN19DR3E3OCIsIkxJVkUiLCI0IiwxLCIiXSxbImRsX2xpdmUiLCJobHMiLCI3MzdfQ0dxNzhfMTAyNFwvaW5kZXgubTN1OCIsIkxJVkUiLCI0IiwxLCIiXSxbImRsX2xpdmUiLCJobHMiLCI3MzdfQ0dxNzhfNDAwXC9pbmRleC5tM3U4IiwiTElWRSIsIjQiLDEsIiJdXSwicmV2aWV3IjpbWyJkbF9yZXZpZXciLCJobHMiLCI3MzdfQ0dxNzgubTN1OCIsIkxJVkUiLCI0IiwxLCIiXV0sIm11bHJhdGVIbHMiOltbImRsX2xpdmUiLCJobHMiLCI3MzdfQ0dxNzgubTN1OCIsIkxJVkUiLCI0IiwxLCIiXSxbImRsX2xpdmUiLCJobHMiLCI3MzdfQ0dxNzhfMTAyNFwvaW5kZXgubTN1OCIsIkxJVkUiLCI0IiwxLCIiXSxbImRsX2xpdmUiLCJobHMiLCI3MzdfQ0dxNzhfNDAwXC9pbmRleC5tM3U4IiwiTElWRSIsIjQiLDEsIiJdXX0=","cdns":"eyJ2aWQiOiI3MzdfQ0dxNzgiLCJicm9jYXN0IjoiNCIsImNkbnMiOiI0Mnw2MXwxMSIsInJhdGUiOiIxMnwxMiIsInJldmlldyI6IjEzIn0=",
         *     "Status":1,"RoomId":737,"ComLayer":true,"VideoTitle":"奶哥哥直播间","WebHost":"http:\/\/www.zhanqi.tv","VideoType":"LIVE","GameId":10,"logoPos":1},"anchorAttr":{"hots":{"name":"T8002","level":"20","fight":"1112409","nowLevelStart":"920000","nextLevelFight":"1121000"}},"follows":34717}}
         *
         *
         */
        try {
            JSONObject json = null;
            json = new JSONObject(content);
            //总页数
            JSONObject jsonObject = json.getJSONObject("data");
            //重点是这一步骤，通过这个步骤获得房间的视频播放ID，视频播放ID 是为了下一步获得真正的流媒体播放地址准备的
            String videoId = jsonObject.getString("videoId");
            //通过视频播放ID获得真正的视频播放地址,好多直播比方平台都是这么搞的，都会搞一个中转地址获得实际的播放地址
            //上面的这些东西什么时候用到了在获取，都是会实时发生变化的.
            String centerUrl2 = "http://wshdl.load.cdn.zhanqi.tv/zqlive/50035_ZLdbp.flv?get_url=1";
            //737_CGq78
            String liveUrl = getContentByUrl(centerUrl2);
            return liveUrl;
            //最后一条记录记录分页信息
            //blogList.add(pageInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getContentByUrl(String url) {

        StringBuffer strBuffer = new StringBuffer();
        try {
            URL baseURL;
            baseURL = new URL(url);
            HttpURLConnection uc = (HttpURLConnection) baseURL.openConnection();
            uc.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 (X11; U; Linux i686; zh-CN; rv:1.9.1.2) Gecko/20090803 Fedora/3.5.2-2.fc11 Firefox/3.5.2");
            uc.setRequestProperty("Accept-Encoding", "gzip,deflate");
            InputStream input = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new GZIPInputStream(input), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                strBuffer.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuffer.toString();

    }


}
