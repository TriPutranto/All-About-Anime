package com.triputranto.animehd.base

interface BaseView {
    fun showLoadingProgress()
    fun hideLoadingProgress()
    fun showErrorMessage(message: String?)
}