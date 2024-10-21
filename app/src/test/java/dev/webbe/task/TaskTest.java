package dev.webbe.task;

import org.junit.jupiter.api.Test;

import dev.webbe.task.Task;
import dev.webbe.task.TaskStatus;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("1", "print", Map.of("message", "Hello World!"));

        assertNotNull(task);
        assertEquals(task.id, "1");
        assertEquals(task.type, "print");
        assertEquals("Hello, World!", task.getParameters().get("message"));
        assertEquals(TaskStatus.PENDING, task.getStatus());
    }

    @Test
    void testTaskExecution() {
        Task task = new Task("2", "add", Map.of("a", 5, "b", 3));
        task.execute();
        assertEquals(TaskStatus.COMPLETED, task.getStatus());
        assertEquals(8, task.getResult());
    }

    @Test
    void testTaskSerialization() {
        Task task = new Task("3", "multiply", Map.of("x", 4, "y", 7));
        String json = task.toJson();
        Task deserializedTask = Task.fromJson(json);
        assertEquals(task.getId(), deserializedTask.getId());
        assertEquals(task.getType(), deserializedTask.getType());
        assertEquals(task.getParameters(), deserializedTask.getParameters());
        assertEquals(task.getStatus(), deserializedTask.getStatus());
    }
}