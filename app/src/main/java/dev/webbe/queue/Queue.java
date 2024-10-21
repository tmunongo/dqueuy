package dev.webbe.queue;

import dev.webbe.task.Task;

public class Queue implements QueueInterface {

    public Task task;

    public Queue(Task task) {
        this.task = task;
    }

    @Override
    public void enqueue(Task task) {
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

    @Override
    public Task dequeue() {
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
    
}
