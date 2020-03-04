package com.triputranto.animehd.ui.main.upcoming

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
import kotlinx.android.synthetic.main.fragment_upcoming.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class UpcomingFragment : BaseFragment(R.layout.fragment_upcoming), UpcomingContract.View {
    private lateinit var presenter: UpcomingPresenter
    private lateinit var adapter: AnimeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
    }

    private fun setupPresenter() {
        presenter = UpcomingPresenter(this, callApi(), scheduler)
        presenter.setUpcomingAnime()
    }

    override fun getUpcomingAnime(animes: ArrayList<Top>) {
        adapter = AnimeAdapter(animes) { id ->
            startActivity<DetailsActivity>(ID to id)
        }
        rv_upcoming_anime.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun showLoadingProgress() {
        super.showLoadingProgress()
        pb_upcoming_anime.show()
    }

    override fun hideLoadingProgress() {
        super.hideLoadingProgress()
        pb_upcoming_anime.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
