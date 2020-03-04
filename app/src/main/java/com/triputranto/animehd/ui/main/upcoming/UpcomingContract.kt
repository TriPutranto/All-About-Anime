package com.triputranto.animehd.ui.main.upcoming

import com.triputranto.animehd.base.BaseView
import com.triputranto.animehd.data.entity.Top

interface UpcomingContract {
    interface Presenter {
        fun setUpcomingAnime()
        fun onDestroy()
    }

    interface View : BaseView {
        fun getUpcomingAnime(animes: ArrayList<Top>)
    }
}