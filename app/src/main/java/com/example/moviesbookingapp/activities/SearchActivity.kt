package com.example.moviesbookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesbookingapp.R
import com.example.moviesbookingapp.activities.adapters.NowShowingAdapter
import com.example.moviesbookingapp.activities.delegates.MoviesDelegate
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_search.*
import kotlin.coroutines.coroutineContext

class SearchActivity : AppCompatActivity(), MoviesDelegate {
    companion object {
        fun newIntent(context: Context,isNow:Boolean): Intent {
            return Intent(context, SearchActivity::class.java).putExtra("Flag",isNow)
        }

    }

    lateinit var mNowShowingAdapter: NowShowingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchMovies()
        setupSearchRecyclerView()


    }

    private fun setupSearchRecyclerView() {
        val flag = intent.getBooleanExtra("Flag",true)
        mNowShowingAdapter = NowShowingAdapter(flag, this)
        rvSearch.adapter = mNowShowingAdapter
        rvSearch.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    }

    private fun searchMovies() {
        searchViewMovies.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return when {
                    query?.isEmpty()!! -> {
                        Toast.makeText(this@SearchActivity,"Hello",Toast.LENGTH_SHORT).show()
                        false
                    }

                    else -> {
                        rvSearch.visibility = View.VISIBLE
                        true
                    }
                }

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return when {
                    newText?.isEmpty()!! -> {
                        rvSearch.visibility = View.GONE
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        })
    }

    override fun onTapMovies(name: String, rating: String, type: String) {

    }

}