package com.triputranto.animehd.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.triputranto.animehd.R
import com.triputranto.animehd.data.entity.Top
import com.triputranto.animehd.utils.inflate
import com.triputranto.animehd.utils.load
import kotlinx.android.synthetic.main.anime_list_item.view.*

class AnimeAdapter(private val top: ArrayList<Top>, private val listener: (String) -> Unit) :
    RecyclerView.Adapter<AnimeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.anime_list_item))

    override fun getItemCount(): Int = top.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(top[position], listener)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(top: Top, listener: (String) -> Unit) = with(itemView) {
            iv_anime.load(top.image_url)
            tv_name.text = top.title
            val rating = top.score?.div(2)
            if (rating != null) {
                rb_anime.rating = rating.toFloat()
            }
            setOnClickListener { listener(top.id ?: "id") }

        }
    }
}