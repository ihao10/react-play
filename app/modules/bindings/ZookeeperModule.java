package modules.bindings;

import com.google.inject.AbstractModule;
import com.youzu.topsango.shared.ZkGameWorldConfigCache;
import com.youzu.topsango.shared.ZkGlobalWorldMappingCache;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import play.Configuration;
import play.Environment;
import play.Logger;

public class ZookeeperModule extends AbstractModule {
  @SuppressWarnings("FieldCanBeLocal")
  private final Environment environment;
  private final Configuration configuration;

  public ZookeeperModule(Environment environment, Configuration configuration) {
    this.environment = environment;
    this.configuration = configuration;
  }

  @Override
  protected void configure() {
    Logger.info("ZookeeperModule initializing...");

    final String zkRoot = configuration.getString("zookeeper.uri");

    Logger.info("connect zookeeper...");
    final CuratorFramework zookeeper = CuratorFrameworkFactory.builder()
        .connectString(zkRoot)
        .sessionTimeoutMs(5000)
        .connectionTimeoutMs(5000)
        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
        .build();
    zookeeper.start();
    Logger.info("zookeeper connected");

    // server list cache
//    PathChildrenCache gameWorldsCache = new PathChildrenCache(zookeeper, zkRoot + "/game_worlds", false);
//    try {
//      gameWorldsCache.start(PathChildrenCache.StartMode.NORMAL);
//    } catch (Exception e) {
//      throw ExceptionFactory.newRuntimeException("init zookeeper error", e);
//    }

    ZkGlobalWorldMappingCache worldMappingCache = new ZkGlobalWorldMappingCache(zookeeper);
    ZookeeperCache serverCache = new ZookeeperCache(zookeeper, null, worldMappingCache, new ZkGameWorldConfigCache(worldMappingCache, zookeeper));
    bind(ZookeeperCache.class).toInstance(serverCache);

    Logger.info("ZookeeperModule initialized...");
  }

}
