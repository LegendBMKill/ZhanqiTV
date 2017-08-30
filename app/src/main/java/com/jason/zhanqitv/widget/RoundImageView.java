package com.jason.zhanqitv.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class RoundImageView extends AppCompatImageView {
    float width,height;

    float mradius = 16f;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (width > mradius && height > mradius) {
            Path path = new Path();
            path.moveTo(mradius, 0);
            path.lineTo(width - mradius, 0);
            path.quadTo(width, 0, width, mradius);
            path.lineTo(width, height - mradius);
            path.quadTo(width, height, width - mradius, height);
            path.lineTo(mradius, height);
            path.quadTo(0, height, 0, height - mradius);
            path.lineTo(0, mradius);
            path.quadTo(0, 0, mradius, 0);
            canvas.clipPath(path);
        }

        super.onDraw(canvas);
    }

}
