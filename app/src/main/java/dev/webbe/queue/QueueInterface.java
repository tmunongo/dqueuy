package dev.webbe.queue;

import dev.webbe.task.Task;

public interface QueueInterface {
    void enqueue(Task task);
    Task dequeue();
    int size();
}
