package modules.bindings;

import com.youzu.topsango.shared.ZkGameWorldConfigCache;
import com.youzu.topsango.shared.ZkGlobalWorldMappingCache;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;

// TODO 先这样，会有线程安全问题，之后还是放到actor里比较好
public class ZookeeperCache {

  /**
   * CuratorFramework是线程安全的
   */
  public final CuratorFramework zookeeper;

  public final PathChildrenCache serverCache;
  public final ZkGlobalWorldMappingCache worldMappingCache;
  public final ZkGameWorldConfigCache worldConfigCache;

  public ZookeeperCache(CuratorFramework zookeeper, PathChildrenCache serverCache, ZkGlobalWorldMappingCache worldMappingCache, ZkGameWorldConfigCache worldConfigCache) {
    this.zookeeper = zookeeper;
    this.serverCache = serverCache;
    this.worldMappingCache = worldMappingCache;
    this.worldConfigCache = worldConfigCache;
  }
}
