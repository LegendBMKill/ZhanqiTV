package com.jason.zhanqitv.util;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;

import com.jason.zhanqitv.App;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Jason on 2017/8/11.
 */

public class S {

    public static String getString(int resId) {
        return App.AppContext().getString(resId);
    }

    public static String getString(int resId, String s) {
        return App.AppContext().getString(resId, s);
    }
    public static String getString(int resId, String s1, String s2) {
        return App.AppContext().getString(resId, s1,s2);
    }

    public static CharSequence formatTxt(int strId, String formatStr, int s, int e, int colorId) {
        SpannableString spName = new SpannableString(App.AppContext().getString(strId, formatStr));
        ForegroundColorSpan span = new ForegroundColorSpan(App.AppContext().getResources().getColor(colorId));
        spName.setSpan(span, s, e, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spName;
    }

    public static CharSequence formatTxt(int strId, String formatStr, int s, int colorId) {
        SpannableString spName = new SpannableString(App.AppContext().getString(strId, formatStr));
        ForegroundColorSpan span = new ForegroundColorSpan(App.AppContext().getResources().getColor(colorId));
        spName.setSpan(span, s, spName.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spName;
    }

    public static CharSequence formatTxt(int strId, String formatStr1, String formatStr2, int s, int colorId) {
        SpannableString spName = new SpannableString(App.AppContext().getString(strId, formatStr1,formatStr2));
        ForegroundColorSpan span = new ForegroundColorSpan(App.AppContext().getResources().getColor(colorId));
        spName.setSpan(span, s, spName.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spName;
    }

    public static CharSequence formatTxt(int strId, int size, String formatStr, int s, int e, int colorId) {
        SpannableString spName = new SpannableString(App.AppContext().getString(strId, formatStr));
        ForegroundColorSpan span = new ForegroundColorSpan(App.AppContext().getResources().getColor(colorId));
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(size, true);
        spName.setSpan(span, s, e, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spName.setSpan(sizeSpan, s, e, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spName;
    }
    public static CharSequence formatTxt(int strId, int size, String str1, String str2, int s, int e, int colorId) {
        SpannableString spName = new SpannableString(App.AppContext().getString(strId, str1,str2));
        ForegroundColorSpan span = new ForegroundColorSpan(App.AppContext().getResources().getColor(colorId));
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(size, true);
        spName.setSpan(span, s, e, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spName.setSpan(sizeSpan, s, e, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spName;
    }

    public static CharSequence formatTxt(int strId, int size, String str1, String str2, int s, int colorId) {
        SpannableString spName = new SpannableString(App.AppContext().getString(strId, str1,str2));
        ForegroundColorSpan span = new ForegroundColorSpan(App.AppContext().getResources().getColor(colorId));
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(size, true);
        spName.setSpan(span, s, spName.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spName.setSpan(sizeSpan, s, spName.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spName;
    }
    public static CharSequence formatTxt(int strId, int size, String str1, int s, int colorId) {
        SpannableString spName = new SpannableString(App.AppContext().getString(strId, str1));
        ForegroundColorSpan span = new ForegroundColorSpan(App.AppContext().getResources().getColor(colorId));
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(size, true);
        spName.setSpan(span, s, spName.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spName.setSpan(sizeSpan, s, spName.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spName;
    }

    /**
     * 获取当前日期
     */
    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String date = formatter.format(curDate);
        return date;
    }

    /**
     * 获取未来某天日期
     *
     * @param days 未来的天数
     * @return 日期
     */
    public static String getNextDaysDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, days);//往上推一天  30推三十天  365推一年
        Date mBefore = calendar.getTime();
        String date = sdf.format(mBefore);
        return date;
    }


    // //////////////////////////////////////////////////////////////
    /*
	 * dp是与密度无关，sp除了与密度无关外，还与scale无关。如果屏幕密度为160，这时dp和sp和px是一样的。1dp=1sp=1px，
	 * 但如果使用px作单位，如果屏幕大小不变（假设还是3.2寸），而屏幕密度变成了320。
	 * 那么原来TextView的宽度设成160px，在密度为320的3.2寸屏幕里看要比在密度为160的3.2寸屏幕上看短了一半。
	 * 但如果设置成160dp或160sp的话。系统会自动将width属性值设置成320px的。也就是160 * 320 / 160。 其中320 /
	 * 160可称为密度比例因子。也就是说，如果使用dp和sp，系统会根据屏幕密度的变化自动进行转换。 dp值 =（dpi值/160）* pixel值
	 */

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
//		final float scale = appCtx.getResources().getDisplayMetrics().density;
//		return (int) (dpValue * scale + 0.5f);
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, App.AppContext().getResources().getDisplayMetrics());
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
//		final float scale = appCtx.getResources().getDisplayMetrics().density;
//		return (int) (pxValue / scale + 0.5f);
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pxValue, App.AppContext().getResources().getDisplayMetrics());
    }

    public static int dip2px(float dpValue, Context ctx) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, ctx.getResources().getDisplayMetrics());
    }

    public static int getGameId(String tab){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("王者荣耀",115);
        map.put("英雄联盟",6);
        map.put("三国杀",13);
        map.put("守望先锋",82);
        map.put("手机游戏",28);
        map.put("主机游戏",49);
        map.put("炉石传说",9);
        map.put("DOTA2",10);
        map.put("DNF",22);
        map.put("射击游戏",67);
        return map.get(tab);
    }

}
