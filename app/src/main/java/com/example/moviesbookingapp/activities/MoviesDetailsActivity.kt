package com.example.moviesbookingapp.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesbookingapp.R
import com.example.moviesbookingapp.activities.adapters.CastListAdapter
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.android.synthetic.main.activity_movies_details.*
import java.net.URI
import java.net.URL

class MoviesDetailsActivity : AppCompatActivity() {
    lateinit var mCastListAdapter: CastListAdapter
    lateinit var player:ExoPlayer


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MoviesDetailsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details)

        setVisibilityOfNotify()
        setUpMoviesInfo()
        setUpBackBtn()
        setUpCastRecyclerView()
        navigateToDateSelect()
        setUpVideo()


    }

    private fun setUpVideo() {
        player = ExoPlayer.Builder(this).build()
        vdMovieTrailer.player = player

        val uri =
            Uri.parse("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
        val media = MediaItem.fromUri(uri)
        (vdMovieTrailer.player as ExoPlayer).apply {
            setMediaItem(media)
            prepare()
            play()
        }
    }

    override fun onRestart() {


        super.onRestart()
    }

    private fun navigateToDateSelect() {
        btnBooking.setOnClickListener {
            startActivity(DateSelectActivity.newIntent(this))
            vdMovieTrailer.player?.stop()
            vdMovieTrailer.player?.release()
        }
    }

    private fun setUpMoviesInfo() {
        val title = intent.getStringExtra("Movies_Name").toString()
        val rating = intent.getStringExtra("Rating_Status").toString()
        tvMoviesTitleFromDetails.text = title
        tvRatingFromDetails.text = rating
    }

    private fun setUpBackBtn() {
        btnBack.setOnClickListener {
            vdMovieTrailer.player?.stop()
            vdMovieTrailer.player?.release()
            super.onBackPressed()
        }
    }

    private fun setUpCastRecyclerView() {
        mCastListAdapter = CastListAdapter()
        rvCast.adapter = mCastListAdapter
        rvCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setVisibilityOfNotify() {
        val isNowShowing = intent.getBooleanExtra("IS_NOW_SHOWING", false)
        when (isNowShowing) {
            true -> {
                flNotification.visibility = View.GONE


            }
            else -> {
                flNotification.visibility = View.VISIBLE
                viewGradient.visibility = View.GONE
                btnBooking.visibility = View.GONE
            }
        }
    }
}