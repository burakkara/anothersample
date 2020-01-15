package com.example.myapplication.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class SchedulersProvider @Inject
internal constructor() {
    private val ioScheduler = Schedulers.from(Executors.newFixedThreadPool(IO_THREAD_POOL_SIZE))

    open fun ui(): Scheduler = AndroidSchedulers.mainThread()

    open fun computation(): Scheduler = Schedulers.computation()

    open fun io(): Scheduler = ioScheduler

    fun newThread(): Scheduler = Schedulers.newThread()

    companion object {
        private const val IO_THREAD_POOL_SIZE = 20
    }
}