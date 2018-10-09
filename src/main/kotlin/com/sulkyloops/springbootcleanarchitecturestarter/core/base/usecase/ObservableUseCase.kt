package core.usecase

import app.citybuds.backend.core.base.usecase.UseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<I, O>(
        open val observeOn: Scheduler?,
        open val subscribeOn: Scheduler?
) : UseCase<I, Observable<O>>() {
    constructor(): this(null, null)

    override fun start(param: I): Observable<O> {
        return execute(param)
                .subscribeOn(this.subscribeOn?: Schedulers.io())
                .observeOn(this.observeOn?: Schedulers.io())
    }
    abstract override fun execute(param: I): Observable<O>
}