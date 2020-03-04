package com.triputranto.animehd.ui.main.allanime

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
import kotlinx.android.synthetic.main.fragment_all_anime.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class AllAnimeFragment : BaseFragment(R.layout.fragment_all_anime), AllAnimeContract.View {
    private lateinit var presenter: AllAnimePresenter
    private lateinit var adapter: AnimeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
    }

    private fun setupPresenter() {
        presenter = AllAnimePresenter(this, callApi(), scheduler)
        presenter.setAllAnime()
    }

    override fun getAllAnime(animes: ArrayList<Top>) {
        adapter = AnimeAdapter(animes) { id ->
            startActivity<DetailsActivity>(ID to id)
        }
        rv_all_anime.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun showLoadingProgress() {
        super.showLoadingProgress()
        pb_all_anime.show()
    }

    override fun hideLoadingProgress() {
        super.hideLoadingProgress()
        pb_all_anime.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
