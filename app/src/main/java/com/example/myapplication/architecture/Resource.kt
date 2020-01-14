package com.example.myapplication.architecture

sealed class Resource<T> {
    class LoadingResource<T> : Resource<T>() {
        override fun equals(other: Any?): Boolean {
            return other is LoadingResource<*>
        }

        override fun hashCode(): Int {
            return 1
        }
    }

    data class LoadedResource<T>(val data: T) : Resource<T>()

    data class ErrorResource<T>(
            val title: String,
            val message: String
    ) : Resource<T>()
}