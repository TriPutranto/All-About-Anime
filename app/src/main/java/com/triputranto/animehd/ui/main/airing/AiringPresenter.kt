package com.triputranto.animehd.ui.main.airing

import com.triputranto.animehd.base.BaseObserver
import com.triputranto.animehd.data.entity.TopResponse
import com.triputranto.animehd.data.repository.AnimeRepository
import com.triputranto.animehd.utils.Const.AIRING
import com.triputranto.animehd.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class AiringPresenter(
    private val view: AiringContract.View,
    private val repository: AnimeRepository,
    private val schedulerProvider: SchedulerProvider
) : AiringContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    override fun setAiringAnime() {
        view.showLoadingProgress()
        compositeDisposable.add(
            repository.setAnimeBySubtype(1, AIRING)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(object : BaseObserver<TopResponse>() {
                    override fun onSuccess(entity: TopResponse) {
                        super.onSuccess(entity)
                        view.hideLoadingProgress()
                        view.getAiringAnime(entity.top)
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