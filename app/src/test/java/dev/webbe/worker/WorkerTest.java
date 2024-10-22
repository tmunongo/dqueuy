package dev.webbe.worker;

import dev.webbe.queue.DistributedQueue;
import dev.webbe.queue.QueueInterface;
import dev.webbe.task.Task;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void testWorkerProcessTask() throws InterruptedException {
        DistributedQueue mockQueue = Mockito.mock(DistributedQueue.class);
        Task mockTask = new Task("1", "print", Map.of("message", "Test"));
        when(mockQueue.dequeue()).thenReturn(mockTask, (Task)null);

        Worker worker = new Worker(mockQueue);
        Thread workerThread = new Thread(worker);
        workerThread.start();

        Thread.sleep(100); // Give some time for the worker to process the task
        worker.stop();
        workerThread.join();

        verify(mockQueue, times(2)).dequeue();
        assertEquals(Task.TaskStatus.COMPLETED, mockTask.getStatus());
    }

    @Test
    void testWorkerWithEmptyQueue() throws InterruptedException {
        DistributedQueue mockQueue = Mockito.mock(DistributedQueue.class);
        when(mockQueue.dequeue()).thenReturn(null);

        Worker worker = new Worker(mockQueue);
        Thread workerThread = new Thread(worker);
        workerThread.start();

        Thread.sleep(100); // Give some time for the worker to attempt dequeue
        worker.stop();
        workerThread.join();

        verify(mockQueue, atLeast(1)).dequeue();
    }
}