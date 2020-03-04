package com.triputranto.animehd.ui.main.upcoming

import com.triputranto.animehd.base.BaseObserver
import com.triputranto.animehd.data.entity.TopResponse
import com.triputranto.animehd.data.repository.AnimeRepository
import com.triputranto.animehd.utils.Const.UPCOMING
import com.triputranto.animehd.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class UpcomingPresenter(
    private val view: UpcomingContract.View,
    private val repository: AnimeRepository,
    private val schedulerProvider: SchedulerProvider
) : UpcomingContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    override fun setUpcomingAnime() {
        view.showLoadingProgress()
        compositeDisposable.add(
            repository.setAnimeBySubtype(1, UPCOMING)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribeWith(object : BaseObserver<TopResponse>() {
                    override fun onSuccess(entity: TopResponse) {
                        super.onSuccess(entity)
                        view.hideLoadingProgress()
                        view.getUpcomingAnime(entity.top)
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