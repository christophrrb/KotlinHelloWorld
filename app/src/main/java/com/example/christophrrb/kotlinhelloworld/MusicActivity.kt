package com.example.christophrrb.kotlinhelloworld

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        var mp = MediaPlayer.create(this, R.raw.music);

        fun playMusic() {
            mp.start();
        };

        fun stopMusic() {
            mp.stop();
            mp.reset();
            mp = MediaPlayer.create(this, R.raw.music);
        }

        playMusic.setOnClickListener {
            playMusic();
        }

        stopMusic.setOnClickListener {
            stopMusic();
        }

        toggle.setOnClickListener {
            if (mp.isPlaying) {
                stopMusic();
            } else {
                playMusic();
            }
        }
    }
}
