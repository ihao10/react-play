import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Before;
import org.junit.Test;

public class ZookeeperTest {

  private CuratorFramework zookeeper;

  @Before
  public void init() {
    final CuratorFramework zookeeper = CuratorFrameworkFactory.builder()
        .connectString("192.168.180.106:2181")
        .sessionTimeoutMs(5000)
        .connectionTimeoutMs(5000)
        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
        .build();
    zookeeper.start();
  }

  @Test
  public void test() {

  }
}
