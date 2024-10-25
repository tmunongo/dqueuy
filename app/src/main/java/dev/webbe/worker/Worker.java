package dev.webbe.worker;

import dev.webbe.queue.DistributedQueue;

public class Worker implements Runnable {

    private DistributedQueue queue;

    public Worker(DistributedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

    }

    public void stop() {

    }
}
