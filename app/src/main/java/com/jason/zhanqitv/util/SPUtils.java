package com.jason.zhanqitv.util;

import android.content.SharedPreferences;

import com.jason.zhanqitv.App;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Hank on 2016/5/7.
 *
 * @Description:  SharedPreferences manager
 */
public class SPUtils {

    public static SharedPreferences getSharedPreferences() {
        return App
                .AppContext()
                .getSharedPreferences("config", App
                        .MODE_PRIVATE);
    }

    /**
     * clear all sp info
     */
    public static void clear() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        editor.commit();
    }

    /**
     * Save a string
     *
     * @param key
     * @param value
     */
    public static void save(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void save(String key, int value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Read a string
     *
     * @param key
     * @return
     */
    public static String read(String key) {
        return getSharedPreferences().getString(key, "");
    }
    public static String read(String key, String def) {
        return getSharedPreferences().getString(key, def);
    }
    public static int read(String key, int def) {
        return getSharedPreferences().getInt(key, def);
    }
    /**
     * Save a string
     *
     * @param key
     * @param value
     */
    public static void saveBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Read a string
     *
     * @param key
     * @return
     */
    public static boolean readBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    public static boolean readBoolean(String key, boolean def) {
        return getSharedPreferences().getBoolean(key, def);
    }


    /**
     * Save a serializable object
     * @param obj
     * @param filename
     */
    public static void saveObject(Serializable obj, String filename) {
        FileOutputStream fs;
        try {
            fs = App.AppContext().openFileOutput(filename, App.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(obj);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read a object from saved serializable
     * @param filename
     * @return
     */
    public static Object readObject(String filename) {
        FileInputStream fs;
        Object obj = null;
        try {
            File f = new File(filename);
            if (f.exists()) {
                fs = App.AppContext().openFileInput(filename);
                ObjectInputStream is = new ObjectInputStream(fs);
                obj = is.readObject();
                is.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
