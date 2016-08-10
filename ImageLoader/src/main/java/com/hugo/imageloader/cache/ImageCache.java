package com.hugo.imageloader.cache;

import android.graphics.Bitmap;

/**
 * Created by HugoXie on 16/8/10.
 *
 * Email: Hugo3641@gmail.com
 * GitHub: https://github.com/xcc3641
 * Info:
 */
public interface ImageCache {

    void put(String url, Bitmap bitmap);

    Bitmap get(String url);
}
