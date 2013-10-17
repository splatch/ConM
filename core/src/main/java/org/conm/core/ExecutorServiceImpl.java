package org.conm.core;

import java.util.concurrent.ExecutorService;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

import org.conm.api.ExecutorServiceMXBean;

public class ExecutorServiceImpl extends StandardMBean implements ExecutorServiceMXBean {

    private final ExecutorService service;

    public ExecutorServiceImpl(ExecutorService service) throws NotCompliantMBeanException {
        super(ExecutorServiceMXBean.class);
        this.service = service;
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }

    @Override
    public void shutdownNow() {
        service.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return service.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return service.isTerminated();
    }

}
