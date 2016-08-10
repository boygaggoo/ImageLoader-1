package com.hugo.imageloaderdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.hugo.imageloader.ImageLoader;
import com.hugo.imageloader.cache.DiskCache;
import com.hugo.imageloader.cache.DoubleCache;
import com.hugo.imageloader.cache.ImageCache;
import com.hugo.imageloader.cache.MemoryCache;

public class MainActivity extends AppCompatActivity {
    ImageView ivContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivContent = (ImageView) findViewById(R.id.iv_content);
        String url = "http://7lrzxl.com1.z0.glb.clouddn.com//Instagram/hyominnn-20151128-0001.jpg";
        ImageLoader loader = new ImageLoader();
        // 用户可以通过该方法使用已提供的缓存方法或者自定义实现缓存
        loader.setImageCache(new MemoryCache());
        loader.setImageCache(new DiskCache());
        loader.setImageCache(new DoubleCache());
        loader.setImageCache(new ImageCache() {
            @Override
            public void put(String url, Bitmap bitmap) {

            }

            @Override
            public Bitmap get(String url) {
                return null;
            }
        });
        loader.displayImage(url, ivContent);
    }
}
