package app.citybuds.backend.core.base

interface Mapper<I,O> {
    fun mapFrom(param: I): O
    fun mapTo(param: O): I
}