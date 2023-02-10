package com.example.moviesbookingapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesbookingapp.R
import com.example.moviesbookingapp.activities.adapters.FoodAdapter
import com.example.moviesbookingapp.activities.dummy.dummyFoodList
import kotlinx.android.synthetic.main.activity_grab_bite.*

class GrabBiteActivity : AppCompatActivity() {
    lateinit var mFoodAdapter: FoodAdapter
    companion object{
        fun newIntent(context:Context):Intent{
            return Intent(context,GrabBiteActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grab_bite)
        btnSkip()
        setUpFoodTab()
        setUpGrabFoodRecyclerView()

    }

    private fun setUpFoodTab() {
        dummyFoodList.forEach {
            tabLayoutGrabBite.newTab().apply {
                text = it
                tabLayoutGrabBite.addTab(this)
            }
        }
    }
    private fun setUpGrabFoodRecyclerView(){
        mFoodAdapter = FoodAdapter()
        rvGrabFood.adapter = mFoodAdapter
        rvGrabFood.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)


    }
    private fun btnSkip(){
        tvSkip.setOnClickListener {
            startActivity(CheckOutActivity.newIntent(this))
            finish()
        }
    }
}