package com.guanjian.jigsaw.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author guanjian
 * @description
 * @date 2019/7/26 9:04
 */
public class ThreadPoolUtil {

    private final static int CORE_POOL_SIZE = 100;//核心线程数
    private final static int MAX_POOL_SIZE = 100;//最大线程数
    private final static int KEEP_ALIVE_TIME = 2;//线程执行时长
    private final static int QUEUE_CAPACITY = 100;//队列长度
    private final static ThreadPoolExecutor threadPool;//线程池

    // 溢出策略
    // AbortPolicy:直接抛出java.prop.concurrent.RejectedExecutionException异常
    // CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度
    // DiscardOldestPolicy:抛弃旧的任务、暂不支持；会导致被丢弃的任务无法再次被执行
    // DiscardPolicy:抛弃当前任务、暂不支持；会导致被丢弃的任务无法再次被执行

    //构造线程池
    static {
        threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static void execute(Runnable r) {
        threadPool.execute(r);
    }
}
