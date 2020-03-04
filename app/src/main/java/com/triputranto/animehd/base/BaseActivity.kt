package com.triputranto.animehd.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.triputranto.animehd.data.remote.ApiClient
import com.triputranto.animehd.data.repository.AnimeRepositoryImpl
import com.triputranto.animehd.utils.AppSchedulerProvider
import com.triputranto.animehd.utils.toast

abstract class BaseActivity : AppCompatActivity(), BaseView {
    val scheduler = AppSchedulerProvider()

    fun callApi(): AnimeRepositoryImpl {
        val service = ApiClient.getClient()
        return AnimeRepositoryImpl(service)
    }

    fun setupToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.title = ""
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun showLoadingProgress() {}

    override fun hideLoadingProgress() {}

    override fun showErrorMessage(message: String?) {
        toast(message.toString())
    }
}