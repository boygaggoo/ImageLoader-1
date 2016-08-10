package com.hugo.imageloaderdemo;

import android.app.Application;
import com.facebook.stetho.Stetho;

/**
 * Created by HugoXie on 16/8/10.
 *
 * Email: Hugo3641@gmail.com
 * GitHub: https://github.com/xcc3641
 * Info:
 */
public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
