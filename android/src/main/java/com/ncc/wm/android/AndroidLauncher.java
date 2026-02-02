package com.ncc.wm.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ncc.wm.Main;

/**
 * Launches the Android application.
 * AndroidApplication，这是 LibGDX 提供的一个封装了 Android 底层细节的基类，用于在 Android 上运行 LibGDX 应用
 * */
public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 用于配置 LibGDX 在 Android 平台上的运行参数
        AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
        configuration.useImmersiveMode = true;  // 启用 沉浸式模式（Immersive Mode）,这会隐藏状态栏和导航栏，让游戏全屏显示，提供更好的沉浸体验
        initialize(new Main(), configuration);  // 将Main作为游戏入口传入
    }
}
