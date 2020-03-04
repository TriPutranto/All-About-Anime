package com.triputranto.animehd.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.triputranto.animehd.R
import com.triputranto.animehd.data.entity.Characters
import com.triputranto.animehd.utils.inflate
import com.triputranto.animehd.utils.load
import kotlinx.android.synthetic.main.character_list_item.view.*

class CharactersAdapter(private val characters: ArrayList<Characters>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.character_list_item))

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(characters[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(characters: Characters) {
            with(itemView) {
                iv_characters.load(characters.image_url)
                tv_name.text = characters.name
            }
        }
    }
}
