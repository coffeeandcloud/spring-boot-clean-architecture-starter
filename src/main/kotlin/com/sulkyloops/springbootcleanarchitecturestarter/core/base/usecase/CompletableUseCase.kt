package core.usecase

import app.citybuds.backend.core.base.usecase.UseCase
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<I>(
        open val observeOn: Scheduler?,
        open val subscribeOn: Scheduler?
) : UseCase<I, Completable>() {
    constructor(): this(null, null)

    override fun start(param: I): Completable {
        return execute(param)
                .subscribeOn(this.subscribeOn?: Schedulers.io())
                .observeOn(this.observeOn?: Schedulers.io())
    }
    abstract override fun execute(param: I): Completable
}