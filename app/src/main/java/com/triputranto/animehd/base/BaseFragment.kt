package com.triputranto.animehd.base

import androidx.fragment.app.Fragment
import com.triputranto.animehd.data.remote.ApiClient
import com.triputranto.animehd.data.repository.AnimeRepositoryImpl
import com.triputranto.animehd.utils.AppSchedulerProvider
import com.triputranto.animehd.utils.toast

open class BaseFragment(layoutRes: Int) : Fragment(layoutRes), BaseView {
    val scheduler = AppSchedulerProvider()

    fun callApi(): AnimeRepositoryImpl {
        val service = ApiClient.getClient()
        return AnimeRepositoryImpl(service)
    }

    override fun showLoadingProgress() {}

    override fun hideLoadingProgress() {}

    override fun showErrorMessage(message: String?) {
        toast(message.toString())
    }
}