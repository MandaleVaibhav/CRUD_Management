package com.techm.crud_management.callback

/**
 * This interface for creating a callbacks of API response
 * */
interface ResponseCallback<T>
{
    /**
     * @param T is a generic parameter
     * */
    fun onSuccess(data: T)
    fun onError(error:String?)
}