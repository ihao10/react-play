package modules.bindings;

import com.youzu.topsango.shared.configuration.ZkGameWorldConfigCache;
import com.youzu.topsango.shared.configuration.ZkGlobalWorldMappingCache;
import org.apache.curator.framework.CuratorFramework;

// TODO 先这样，会有线程安全问题，之后还是放到actor里比较好
public class ZookeeperCache {

  /**
   * CuratorFramework是线程安全的
   */
  public final CuratorFramework zookeeper;

  public final ZkGlobalWorldMappingCache worldMappingCache;
  public final ZkGameWorldConfigCache worldConfigCache;

  public ZookeeperCache(CuratorFramework zookeeper, ZkGlobalWorldMappingCache worldMappingCache, ZkGameWorldConfigCache worldConfigCache) {
    this.zookeeper = zookeeper;
    this.worldMappingCache = worldMappingCache;
    this.worldConfigCache = worldConfigCache;
  }
}
