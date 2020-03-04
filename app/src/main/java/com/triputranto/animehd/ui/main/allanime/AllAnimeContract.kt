package com.triputranto.animehd.ui.main.allanime

import com.triputranto.animehd.base.BaseView
import com.triputranto.animehd.data.entity.Top

interface AllAnimeContract {
    interface Presenter {
        fun setAllAnime()
        fun onDestroy()
    }

    interface View : BaseView {
        fun getAllAnime(animes: ArrayList<Top>)
    }
}