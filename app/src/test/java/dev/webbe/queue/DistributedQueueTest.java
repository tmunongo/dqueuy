package dev.webbe.queue;


import dev.webbe.task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.apache.curator.test.TestingServer;


class DistributedQueueTest {
    private TestingServer zkTestServer;
    private DistributedQueue queue;

    @BeforeEach
    void setUp() throws Exception {
        zkTestServer = new TestingServer();
        queue = new DistributedQueue(zkTestServer.getConnectString(), "/tasks");
    }

    @Test
    void testEnqueueAndDequeue() throws Exception {
        Task task = new Task("1", "print", Map.of("message", "Hello"));
        queue.enqueue(task);
        assertEquals(1, queue.size());
        Task dequeuedTask = queue.dequeue();
        assertNotNull(dequeuedTask);
        assertEquals(task.getId(), dequeuedTask.getId());
        assertEquals(0, queue.size());
    }

    @Test
    void testSize() throws Exception {
        assertEquals(0, queue.size());
        queue.enqueue(new Task("1", "task1", Map.of()));
        queue.enqueue(new Task("2", "task2", Map.of()));
        assertEquals(2, queue.size());
    }

    @Test
    void testEmptyDequeue() throws Exception {
        assertNull(queue.dequeue());
    }
}
