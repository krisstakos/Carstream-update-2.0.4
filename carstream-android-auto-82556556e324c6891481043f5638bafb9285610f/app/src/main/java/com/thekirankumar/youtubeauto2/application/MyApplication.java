package com.thekirankumar.youtubeauto2.application;

import android.app.Application;

import com.thekirankumar.youtubeauto2.utils.AdBlocker;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by kiran.kumar on 24/01/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AdBlocker.init(this);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("db.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}
