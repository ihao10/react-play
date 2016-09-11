import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ZookeeperTest {

  private CuratorFramework zookeeper;

  @Before
  public void init() {
    zookeeper = CuratorFrameworkFactory.builder()
        .connectString("192.168.240.166:2181")
        .sessionTimeoutMs(5000)
        .connectionTimeoutMs(5000)
        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
        .build();
    zookeeper.start();
  }

  @Test
  public void test() throws Exception {


    List<String> a = zookeeper.getChildren().forPath("/topsango_shih/game_worlds");
    a.forEach(System.out::println);
  }
}
