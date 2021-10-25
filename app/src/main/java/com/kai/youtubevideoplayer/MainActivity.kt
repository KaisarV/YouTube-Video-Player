package com.kai.youtubevideoplayer

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import androidx.annotation.NonNull
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)
        
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                var videoId = "D4B0IirVxL0"
//                youTubePlayer.loadVideo(videoId, 0f)
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })

        youTubePlayerView.addFullScreenListener(object :YouTubePlayerFullScreenListener{
            override fun onYouTubePlayerEnterFullScreen() {
                showMessage("Enter FullScreen")
                enterFullScreen()
            }

            override fun onYouTubePlayerExitFullScreen() {
                showMessage("Exit FullScreen")
                exitFullScreen()
            }

        })


    }

    private fun enterFullScreen(){
        supportActionBar!!.hide()
//        submit.isInvisible = true
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    private fun exitFullScreen(){
        supportActionBar!!.show()
//        submit.isVisible = true
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }

    //Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()

    private fun showMessage(msg : String){
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}