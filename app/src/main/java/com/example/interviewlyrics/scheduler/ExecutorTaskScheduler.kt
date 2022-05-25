package com.example.interviewlyrics.scheduler

import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

class ExecutorTaskScheduler : ScheduledThreadPoolExecutor(1), TaskScheduler {

    private val mFutureTasks = mutableListOf<ScheduledFuture<*>>()


    override fun schedule(task: Runnable, millis: Long) {
        mFutureTasks.add(schedule(task, millis, TimeUnit.MILLISECONDS))
    }

    override fun cancel() {
        mFutureTasks.forEach { future ->
            future.cancel(true)
        }

        mFutureTasks.clear()
        purge()
    }
}