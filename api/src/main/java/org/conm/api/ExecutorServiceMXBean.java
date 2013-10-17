package org.conm.api;

public interface ExecutorServiceMXBean {

    void shutdown();

    void shutdownNow();

    boolean isShutdown();

    boolean isTerminated();


}
