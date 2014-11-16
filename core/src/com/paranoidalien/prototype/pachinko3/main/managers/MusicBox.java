package com.paranoidalien.prototype.pachinko3.main.managers;

/**
 * Project: Pachinko_3
 * Created by Vin on 16 11 2014 at 2:15 PM.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MusicBox {

    private final Music bgAmbient1 = Gdx.audio.newMusic(Gdx.files.internal("audio/Cronk-02.wav"));
    private final Music bgAmbient2 = Gdx.audio.newMusic(Gdx.files.internal("audio/Looshious-01.wav"));

    private final Sound mouseClick = Gdx.audio.newSound(Gdx.files.internal("audio/mouseClick.wav"));
    private final Sound mouseClickAlt = Gdx.audio.newSound(Gdx.files.internal("audio/Blip-93.ogg"));

    public void playBGAmbient1() {
        bgAmbient1.play();
    }

    public void stopBGAmbient1() {
        bgAmbient1.stop();
    }

    public void playBGAmbient2() {
        bgAmbient2.play();
    }

    public void stopBGAmbient2() {
        bgAmbient2.stop();
    }

    public void playMouseClick() {
        mouseClick.play();
    }

    public void playMouseClickAlt() {
        mouseClickAlt.play();
    }

    public void dispose() {
        bgAmbient1.dispose();
        bgAmbient2.dispose();
        mouseClick.dispose();
    }

}
