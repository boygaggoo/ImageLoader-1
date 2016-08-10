package com.hugo.imageloader.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.hugo.imageloader.Utils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by HugoXie on 16/8/10.
 *
 * Email: Hugo3641@gmail.com
 * GitHub: https://github.com/xcc3641
 * Info:
 */
public class DiskCache implements ImageCache {
    static String cacheDir = "sdcard/cache/";

    // 从缓存中获取图片
    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    // 讲图片缓存到内存中
    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            Utils.closeQuietly(fileOutputStream);
        }
    }
}
