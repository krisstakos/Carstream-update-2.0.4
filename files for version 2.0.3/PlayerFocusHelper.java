package com.thekirankumar.youtubeauto2.mediaplayer;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by kiran.kumar on 07/02/18.
 */

public class PlayerFocusHelper extends PlayerAdapter {
    public PlayerFocusHelper(@NonNull Context context) {
        super(context);
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    protected void onPlay() {

    }

    @Override
    protected void onPause() {

    }

    @Override
    protected void onStop() {

    }

    @Override
    public void seekTo(long position) {

    }

    @Override
    public void setVolume(float volume) {

    }
}
