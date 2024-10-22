package dev.webbe.worker;

import dev.webbe.queue.DistributedQueue;

public class Worker {

    private DistributedQueue queue;

    public Worker(DistributedQueue queue) {
        this.queue = queue;
    }
}
