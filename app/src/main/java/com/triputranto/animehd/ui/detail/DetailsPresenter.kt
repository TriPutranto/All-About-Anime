package com.triputranto.animehd.ui.detail

import com.triputranto.animehd.base.BaseObserver
import com.triputranto.animehd.data.entity.CharacterResponse
import com.triputranto.animehd.data.entity.Top
import com.triputranto.animehd.data.repository.AnimeRepository
import com.triputranto.animehd.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class DetailsPresenter(
    private val view: DetailsContract.View,
    private val repository: AnimeRepository,
    private val schedulerProvider: SchedulerProvider
) : DetailsContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    override fun setDetailAnime(id: String) {
        view.showLoadingProgress()
        compositeDisposable.add(
            repository.setAnimeById(id)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(object : BaseObserver<Top>() {
                    override fun onSuccess(entity: Top) {
                        super.onSuccess(entity)
                        view.hideLoadingProgress()
                        view.getDetailAnime(entity)
                    }

                    override fun onError(e: Throwable) {
                        super.onError(e)
                        view.showErrorMessage(e.message)
                    }
                })
        )
    }

    override fun setCharacterAnime(id: String) {
        compositeDisposable.add(
            repository.setCharactersAnime(id)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(object : BaseObserver<CharacterResponse>() {
                    override fun onSuccess(entity: CharacterResponse) {
                        super.onSuccess(entity)
                        view.getCharacterAnime(entity.characters)
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