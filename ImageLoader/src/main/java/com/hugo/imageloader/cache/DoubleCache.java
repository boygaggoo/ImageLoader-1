package com.hugo.imageloader.cache;

import android.graphics.Bitmap;

/**
 * Created by HugoXie on 16/8/10.
 *
 * Email: Hugo3641@gmail.com
 * GitHub: https://github.com/xcc3641
 * Info: 双缓存. 获取图片时先从内存缓存中获取,如果内存中更没有缓存该图片,再从 SD 卡中获取
 * 缓存图片也是在内存和 SD 卡中都缓存一份
 */
public class DoubleCache {
    ImageCache mMemoryCache = new ImageCache();
    DiskCache mDiskCache = new DiskCache();

    // 先从内存缓存中获取图片,如果没有,再从 SD 卡中获取
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
