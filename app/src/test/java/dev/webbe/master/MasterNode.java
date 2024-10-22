package dev.webbe.master;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MasterNode {
    
}

class MasterNodeTest {

    private TestingServer zkTestServer;
    private MasterNode masterNode;

    @BeforeEach
    void setUp() throws Exception {
        zkTestServer = new TestingServer();
        masterNode = new MasterNode(zkTestServer.getConnectString());
    }

    @Test
    void testAddWorker() throws Exception {
        WorkerNode worker = new WorkerNode("worker1", zkTestServer.getConnectString());
        masterNode.addWorker(worker);
        assertEquals(1, masterNode.getWorkers().size());
        assertTrue(masterNode.getWorkers().contains(worker));
    }

    @Test
    void testRemoveWorker() throws Exception {
        WorkerNode worker = new WorkerNode("worker1", zkTestServer.getConnectString());
        masterNode.addWorker(worker);
        masterNode.removeWorker(worker);
        assertEquals(0, masterNode.getWorkers().size());
    }

    @Test
    void testMonitorWorkers() throws Exception {
        WorkerNode worker1 = new WorkerNode("worker1", zkTestServer.getConnectString());
        WorkerNode worker2 = new WorkerNode("worker2", zkTestServer.getConnectString());
        masterNode.addWorker(worker1);
        masterNode.addWorker(worker2);

        worker1.register();
        worker2.register();

        Thread.sleep(100); // Give some time for ZooKeeper to process

        assertEquals(2, masterNode.getWorkers().size());

        worker1.unregister();

        Thread.sleep(100); // Give some time for ZooKeeper to process

        assertEquals(1, masterNode.getWorkers().size());
        assertFalse(masterNode.getWorkers().contains(worker1));
        assertTrue(masterNode.getWorkers().contains(worker2));
    }
}