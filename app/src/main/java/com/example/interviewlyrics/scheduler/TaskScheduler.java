package com.example.interviewlyrics.scheduler;

import androidx.annotation.NonNull;

public interface TaskScheduler {

    /**
     * Schedule the given task to be executed in the specified number of milliseconds
     *
     * @param task   {@link Runnable} to be scheduled for execution in the future
     * @param millis number of milliseconds to wait before executing the given task
     */
    void schedule(@NonNull Runnable task, @NonNull Long millis);

    /**
     * Cancel all scheduled tasks
     */
    void cancel();
}
