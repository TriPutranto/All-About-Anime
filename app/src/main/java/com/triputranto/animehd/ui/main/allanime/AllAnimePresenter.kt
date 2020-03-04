package com.triputranto.animehd.ui.main.allanime

import com.triputranto.animehd.base.BaseObserver
import com.triputranto.animehd.data.entity.TopResponse
import com.triputranto.animehd.data.repository.AnimeRepository
import com.triputranto.animehd.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class AllAnimePresenter(
    private val view: AllAnimeContract.View,
    private val repository: AnimeRepository,
    private val schedulerProvider: SchedulerProvider
) : AllAnimeContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    override fun setAllAnime() {
        view.showLoadingProgress()
        compositeDisposable.add(
            repository.setAllAnime(1)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribeWith(object : BaseObserver<TopResponse>() {
                    override fun onSuccess(entity: TopResponse) {
                        super.onSuccess(entity)
                        view.hideLoadingProgress()
                        view.getAllAnime(entity.top)
                    }

                    override fun onError(e: Throwable) {
                        super.onError(e)
                        view.showErrorMessage(e.message)
                    }
                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}