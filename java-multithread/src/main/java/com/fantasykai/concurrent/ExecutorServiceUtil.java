package com.fantasykai.concurrent;

import java.util.concurrent.*;

/**
 * The type Executor service util.
 */
public class ExecutorServiceUtil {

    private static final int corePoolSize = 15;
    private static final int maximumPoolSize = 20;
    private static final int queueSize = 50;
    private static final long keepLiveTime = 5L;
    private static final BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>(queueSize);
    private static final RejectedExecutionHandler callerRunsHandler = new ThreadPoolExecutor.CallerRunsPolicy();
    private ExecutorService boundedThreadPool;

    private ExecutorServiceUtil() {
        boundedThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepLiveTime, TimeUnit.SECONDS, queue,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {

                        Thread thread = new Thread(r);
                        thread.setName("TEST_POOL");
                        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

                            // 打出未捕获的异常
                            @Override
                            public void uncaughtException(Thread t, Throwable e) {
                                // 打印异常信息
                                System.out.println("error thread is " + e);
                            }
                        });
                        return thread;
                    }
                }, callerRunsHandler);
    }

    private static class SingletonContainer {
        private static ExecutorServiceUtil instance = new ExecutorServiceUtil();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ExecutorServiceUtil getInstance() {
        return SingletonContainer.instance;
    }

    /**
     * Gets bounded thread pool.
     *
     * @return the bounded thread pool
     */
    public ExecutorService getBoundedThreadPool() {
        return boundedThreadPool;
    }
}
