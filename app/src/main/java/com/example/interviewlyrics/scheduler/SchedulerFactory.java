package com.example.interviewlyrics.scheduler;

public class SchedulerFactory {

    static public TaskScheduler createScheduler() {
        return new ExecutorTaskScheduler();
    }
}
