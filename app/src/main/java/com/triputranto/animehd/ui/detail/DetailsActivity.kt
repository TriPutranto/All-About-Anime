package com.triputranto.animehd.ui.detail

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.triputranto.animehd.R
import com.triputranto.animehd.adapter.CharactersAdapter
import com.triputranto.animehd.base.BaseActivity
import com.triputranto.animehd.data.entity.Characters
import com.triputranto.animehd.data.entity.Top
import com.triputranto.animehd.utils.Const.ID
import com.triputranto.animehd.utils.hide
import com.triputranto.animehd.utils.load
import com.triputranto.animehd.utils.show
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*

class DetailsActivity : BaseActivity(), DetailsContract.View {
    private lateinit var presenter: DetailsPresenter
    private lateinit var idAnime: String
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setupToolbar(toolbar)
        setupPresenter()
    }

    private fun setupPresenter() {
        idAnime = intent?.getStringExtra(ID).toString()
        presenter = DetailsPresenter(this, callApi(), scheduler)
        presenter.setDetailAnime(idAnime)
        presenter.setCharacterAnime(idAnime)
    }

    override fun getDetailAnime(top: Top) {
        iv_anime.load(top.image_url)
        val rating = top.score?.div(2)
        if (rating != null) {
            rb_rating.rating = rating.toFloat()
        }
        tv_type.text = top.type
        tv_title.text = top.title
        tv_duration.text = top.duration
        tv_description.text = top.synopsis
    }

    override fun getCharacterAnime(characters: ArrayList<Characters>) {
        if (characters.isNotEmpty()) {
            character.show()
            adapter = CharactersAdapter(characters)
            rv_characters_anime.let {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }
        } else {
            character.hide()
        }
    }

    override fun showLoadingProgress() {
        super.showLoadingProgress()
        pb_detail_anime.show()
    }

    override fun hideLoadingProgress() {
        super.hideLoadingProgress()
        pb_detail_anime.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
