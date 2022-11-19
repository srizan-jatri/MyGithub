package com.srizan.domain.model


sealed class ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    object  Loading: ApiResult<Nothing>()
    data class Error(val message: String,val code:Int) : ApiResult<Nothing>()
}





