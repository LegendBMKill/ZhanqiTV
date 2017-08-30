package com.jason.zhanqitv.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jason on 2017/8/17 0017.
 */

public class StackUtils {

    private static Stack<Activity> activityStack;
    private static StackUtils appManager;

    private StackUtils() {
    }

    /**
     * 单利模式
     *
     * @return
     */
    public static StackUtils getInstanse() {
        if (appManager == null) {
            synchronized (StackUtils.class) {
                if (appManager == null) {
                    appManager = new StackUtils();
                }
            }
        }
        return appManager;
    }

    /**
     * 添加Activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        if (activity != null) {
            activityStack.add(activity);
        }

    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 获取指定的Activity
     *
     * @param cls
     * @return
     */
    public Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    /**
     * 结束当前Activity
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     *
     * @param class1
     */
    public void finishActivity(Class<?> class1) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(class1)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用
     */
    public void AppExit() {
        try {
            finishAllActivity();
            // 杀死应用进程
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束所有Activity除了参数的那些
     */
    public void finishAllActivity(Class<?> cls1, Class<?> cls2){
        ArrayList<Activity> as = new ArrayList<>();
        final Stack<Activity> temp = new Stack<>();
        temp.addAll(activityStack);
        final int size = temp.size();
        for (int i = 0;  i < size; i++){
            Activity activity = temp.get(i);
            if (null != activity){
                if(!activity.getClass().equals(cls1)&&!activity.getClass().equals(cls2) ){
                    activity.finish();
                }else{
                    as.add(activity);
                }
            }
        }
        activityStack.clear();
        activityStack.addAll(as);
        /*ArrayList<Activity> as = new ArrayList<>();
        for (int i = 0, size = activityStack.size(); i < size; i++){
            Activity activity = activityStack.get(i);
            if (null != activity){
                if(!activity.getClass().equals(cls1)&&!activity.getClass().equals(cls2) ){
                    activity.finish();
                }else{
                    as.add(activity);
                }
            }
        }
        activityStack.clear();
        activityStack.addAll(as);*/
    }

    public int activityStackSize() {
        for (Activity a :
                activityStack) {
        }
        return activityStack.size();
    }
}
