package com.triputranto.animehd.ui.detail

import com.triputranto.animehd.base.BaseView
import com.triputranto.animehd.data.entity.Characters
import com.triputranto.animehd.data.entity.Top

interface DetailsContract {
    interface Presenter {
        fun setDetailAnime(id: String)
        fun setCharacterAnime(id: String)
        fun onDestroy()
    }

    interface View : BaseView {
        fun getDetailAnime(top: Top)
        fun getCharacterAnime(characters: ArrayList<Characters>)
    }
}