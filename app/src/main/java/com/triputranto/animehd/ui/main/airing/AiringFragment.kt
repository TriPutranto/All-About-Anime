package com.triputranto.animehd.ui.main.airing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.triputranto.animehd.R
import com.triputranto.animehd.adapter.AnimeAdapter
import com.triputranto.animehd.base.BaseFragment
import com.triputranto.animehd.data.entity.Top
import com.triputranto.animehd.ui.detail.DetailsActivity
import com.triputranto.animehd.utils.Const.ID
import com.triputranto.animehd.utils.hide
import com.triputranto.animehd.utils.show
import kotlinx.android.synthetic.main.fragment_airing.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class AiringFragment : BaseFragment(R.layout.fragment_airing), AiringContract.View {
    private lateinit var presenter: AiringPresenter
    private lateinit var adapter: AnimeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
    }

    private fun setupPresenter() {
        presenter = AiringPresenter(this, callApi(), scheduler)
        presenter.setAiringAnime()
    }

    override fun getAiringAnime(animes: ArrayList<Top>) {
        adapter = AnimeAdapter(animes) { id ->
            startActivity<DetailsActivity>(ID to id)
        }
        rv_airing_anime.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun showLoadingProgress() {
        super.showLoadingProgress()
        pb_airing_anime.show()
    }

    override fun hideLoadingProgress() {
        super.hideLoadingProgress()
        pb_airing_anime.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
