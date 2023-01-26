package com.example.moviesbookingapp.activities.viewholders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesbookingapp.activities.adapters.ShowTimeAdapter
import kotlinx.android.synthetic.main.viewholder_cinema_details.view.*

class CinemaDetailsViewHolder(itemView: View, var isExpanded: Boolean, val context: Context) : RecyclerView.ViewHolder(itemView) {
    init {
        isExpanded = false
        itemView.rlHideView.visibility = View.GONE
          setUpRecyclerViewTime()
        itemView.tvSeeDetals.setOnClickListener {
            setUpVisibilityOfLayout()
        }
    }

    private fun setUpRecyclerViewTime() {
        itemView.rvCinemaShowdate.adapter = ShowTimeAdapter()
        itemView.rvCinemaShowdate.layoutManager = GridLayoutManager(this.context,3,GridLayoutManager.VERTICAL,false)
    }

    private fun setUpVisibilityOfLayout() {
         isExpanded = !isExpanded
        itemView.apply {
            rlHideView.visibility = if (isExpanded) View.VISIBLE else View.GONE

        }

    }


}