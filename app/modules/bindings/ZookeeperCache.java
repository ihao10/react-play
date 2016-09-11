package modules.bindings;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;

public class ZookeeperCache {

  // TODO 先这样，说是线程安全的，之后还是放到actor里比较好
  public final CuratorFramework zookeeper;

  /** server list under root */
  public final PathChildrenCache serverCache;


  public ZookeeperCache(CuratorFramework zookeeper, PathChildrenCache serverCache) {
    this.zookeeper = zookeeper;
    this.serverCache = serverCache;
  }
}
