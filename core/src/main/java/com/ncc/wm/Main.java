package com.ncc.wm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 * */
public class Main extends ApplicationAdapter {

    // Texture: 纹理，代表图片素材
    Texture backgroundTexture;
    Texture bucketTexture;
    Texture dropTexture;

    // Sound: 短小，频繁播放的音效
    Sound dropSound;

    // Music: 长时间播放的音频
    Music music;

    // SpriteBatch: 一个专门用来批量画图的画笔
    SpriteBatch spriteBatch;

    // 窗口
    FitViewport viewport;

    // 方便类，封装了 Texture + 位置 + 尺寸 + 旋转 + 颜色等属性
    private Sprite bucketSprite;

    @Override
    public void create() {
        backgroundTexture = new Texture("background.png");
        bucketTexture = new Texture("bucket.png");
        dropTexture = new Texture("drop.png");

        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));

        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(10,5);

        bucketSprite = new Sprite(bucketTexture);
        bucketSprite.setSize(1,1);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);   // true = 居中相机
    }

    /**
     * 渲染
     */
    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void input() {

    }

    private void logic() {

    }

    private void draw() {
        // Gdx.app.log("draw", String.valueOf(count));

        ScreenUtils.clear(Color.BLACK);

        // 告诉 OpenGL：“接下来的渲染，请使用我定义的视口（Viewport）设置”
        viewport.apply();

        // 将 SpriteBatch 的坐标系统 从默认的屏幕像素坐标，切换为你定义的 虚拟世界坐标系（比如 10×5）
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        // 开始绘图
        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        spriteBatch.draw(backgroundTexture, 0,0, worldWidth, worldHeight);
        // spriteBatch.draw(bucketTexture, 0, 0, 1, 1);
        bucketSprite.draw(spriteBatch);

        // 结束绘图，此时真正提交到GPU
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
