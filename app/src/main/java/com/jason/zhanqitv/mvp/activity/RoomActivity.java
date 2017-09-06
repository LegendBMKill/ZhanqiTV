package com.jason.zhanqitv.mvp.activity;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.view.View;

import com.jason.zhanqitv.R;
import com.jason.zhanqitv.base.BaseActivity;
import com.jason.zhanqitv.bean.GameListInfo;
import com.jason.zhanqitv.constants.C;
import com.jason.zhanqitv.listener.SampleListener;
import com.jason.zhanqitv.mvp.presenter.RoomPresenter;
import com.jason.zhanqitv.mvp.view.IRoomView;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import butterknife.BindView;

public class RoomActivity extends BaseActivity<IRoomView, RoomPresenter> implements IRoomView {

    @BindView(R.id.player)
    StandardGSYVideoPlayer mPlayer;
    private GameListInfo mInfo;
    private boolean isPlay;
    private OrientationUtils mOrientationUtils;
    private boolean isPause;


    @NonNull
    @Override
    public RoomPresenter createPresenter() {
        return new RoomPresenter();
    }

    @Override
    protected void initView() {
        mInfo = (GameListInfo) getIntent().getSerializableExtra(C.GAME_INFO);
        String url = "http://dlhls.cdn.zhanqi.tv/zqlive/"+mInfo.getVideoId()+".m3u8";

        resolveNormalVideoUI();
        //外部辅助的旋转，帮助全屏
        mOrientationUtils = new OrientationUtils(this, mPlayer);
        //初始化不打开外部的旋转
        mOrientationUtils.setEnable(false);
        GSYVideoOptionBuilder gsyVideoOption = new GSYVideoOptionBuilder();
        gsyVideoOption
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setSeekRatio(1)
                .setUrl(url)
                .setCacheWithPlay(false)
                .setVideoTitle(mInfo.getTitle())
                .setStandardVideoAllCallBack(new SampleListener() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        Debuger.printfError("***** onPrepared **** " + objects[0]);
                        Debuger.printfError("***** onPrepared **** " + objects[1]);
                        super.onPrepared(url, objects);
                        //开始播放了才能旋转和全屏
                        mOrientationUtils.setEnable(true);
                        isPlay = true;
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                        Debuger.printfError("***** onEnterFullscreen **** " + objects[0]);//title
                        Debuger.printfError("***** onEnterFullscreen **** " + objects[1]);//当前全屏player
                    }

                    @Override
                    public void onAutoComplete(String url, Object... objects) {
                        super.onAutoComplete(url, objects);
                    }

                    @Override
                    public void onClickStartError(String url, Object... objects) {
                        super.onClickStartError(url, objects);
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        Debuger.printfError("***** onQuitFullscreen **** " + objects[0]);//title
                        Debuger.printfError("***** onQuitFullscreen **** " + objects[1]);//当前非全屏player
                        if (mOrientationUtils != null) {
                            mOrientationUtils.backToProtVideo();
                        }
                    }
                })
                .setLockClickListener(new LockClickListener() {
                    @Override
                    public void onClick(View view, boolean lock) {
                        if (mOrientationUtils != null) {
                            //配合下方的onConfigurationChanged
                            mOrientationUtils.setEnable(!lock);
                        }
                    }
                })
                .build(mPlayer);

        mPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                mOrientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                mPlayer.startWindowFullscreen(mContext, true, true);
            }
        });


    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_room;
    }
    @Override
    public void onBackPressed() {

        if (mOrientationUtils != null) {
            mOrientationUtils.backToProtVideo();
        }

        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        //GSYPreViewManager.instance().releaseMediaPlayer();
        if (mOrientationUtils != null)
            mOrientationUtils.releaseListener();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            mPlayer.onConfigurationChanged(this, newConfig, mOrientationUtils);
        }
    }


    private void resolveNormalVideoUI() {
        //增加title
        mPlayer.getTitleTextView().setVisibility(View.GONE);
        mPlayer.getBackButton().setVisibility(View.GONE);
    }
}
