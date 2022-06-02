package com.example.interviewlyrics.scheduler;

import androidx.annotation.Nullable;

public class SchedulerFactory {

    @Nullable
    static public TaskScheduler createScheduler() {
        return new ExecutorTaskScheduler();
    }
}
