package dev.webbe.queue;

import dev.webbe.task.Task;
import lombok.Data;

@Data public class DistributedQueue implements QueueInterface {

    public Task task;
    public String connectString;
    public String path;

    public DistributedQueue(String connectString, String path) {
        this.connectString = connectString;
        this.path = path;
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
