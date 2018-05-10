package com.example.clock5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by 16221 on 2018/2/3.
 */

public class AlarmService extends Service {
    // MediaPlayer实例
    private MediaPlayer player;
    // IBinder实例

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        playMusic();
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playMusic();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
        }

    }

    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                if(bundle.getBoolean("music"))
                    playMusic();
                else
                    stopMusic();
            }
        }
    }

    public void stopMusic() {
        if (player != null) {
            player.stop();
            try {
                // 在调用stop后如果需要再次通过start进行播放,需要之前调用prepare函数
                player.prepare();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    public void playMusic() {
        if(player == null) {
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            try {
                player = new MediaPlayer();
                player.setDataSource(this, uri);
                final AudioManager audioManager = (AudioManager)this
                        .getSystemService(Context.AUDIO_SERVICE);
                if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
                    player.setAudioStreamType(AudioManager.STREAM_ALARM);
                    player.setLooping(true);
                    player.prepare();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!player.isPlaying()) {
            player.start();
        }
    }


}
