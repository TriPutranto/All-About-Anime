package com.triputranto.animehd.ui.main.airing

import com.triputranto.animehd.base.BaseView
import com.triputranto.animehd.data.entity.Top

interface AiringContract {
    interface Presenter {
        fun setAiringAnime()
        fun onDestroy()
    }

    interface View : BaseView {
        fun getAiringAnime(animes: ArrayList<Top>)
    }
}
