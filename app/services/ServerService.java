package services;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.math.IntMath;
import com.google.inject.Inject;
import com.youzu.topsango.shared.SystemConstantsKt;
import com.youzu.topsango.shared.configuration.ZkGameWorldConfig;
import message.server.ServerInfo;
import services.utils.ExceptionFactory;
import modules.bindings.ZookeeperCache;
import play.Configuration;
import services.helper.ServerHelper;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class ServerService {
  @Inject
  private Configuration config;

  @Inject
  private ZookeeperCache zookeeperCache;

  public ServerInfo list(int page, int num) {
    ServerInfo serverInfo = new ServerInfo();
    serverInfo.setPage(page);
    try {
      int endIndex = IntMath.checkedMultiply(num, page);
      // TODO 这边数据源应该做下排序
//      List<Long> worldIds = Lists.newArrayList(zookeeperCache.worldMappingCache.getWorldIdMapping().values());
      List<Long> worldIds = Lists.newArrayList(1L, 3001010001L);
      worldIds.sort((o1, o2) -> (int) (o2 - o1));
      int total = worldIds.size();
      int beginIndex = IntMath.checkedMultiply(num, page - 1);
      if (total <= beginIndex) {
        return serverInfo;
      }
      List<Long> need = worldIds.subList(beginIndex, Math.min(endIndex, total));
      List<ServerInfo.ServerItem> list = Lists.newArrayListWithCapacity(need.size());
      need.forEach(worldId -> {
        ZkGameWorldConfig config = zookeeperCache.worldConfigCache.getConfig(worldId);
        list.add(ServerHelper.zkToItem(config));
      });
      serverInfo.setItems(list);
      serverInfo.setTotalNum(total);
      serverInfo.setTotalPage(total / num + (total % num > 0 ? 1 : 0));
    } catch (Exception e) {
      throw ExceptionFactory.newAppException("zookeeper server list", e);
    }
    return serverInfo;
  }

  public Optional<String> save(ServerInfo.ServerItem item) {
    final long newWorldId = item.getId();
    if (zookeeperCache.worldMappingCache.getWorldIdMapping().containsKey(newWorldId)) {
      return Optional.of("server.exist");
    }
    try {
      ZkGameWorldConfig config = ServerHelper.itemToZK(item);
      zookeeperCache.zookeeper.create().forPath(SystemConstantsKt.zkGameWorldPath(newWorldId), JSON.toJSONBytes(config));
    } catch (Exception e) {
      throw ExceptionFactory.newAppException("zookeeper server save", e);
    }
    return Optional.empty();
  }

  public Optional<String> update(ServerInfo.ServerItem item) {
    final long newWorldId = item.getId();
    if (!zookeeperCache.worldMappingCache.getWorldIdMapping().containsKey(newWorldId)) {
      return Optional.of("server.not.exist");
    }
    try {
      ZkGameWorldConfig config = ServerHelper.itemToZK(item);
      zookeeperCache.zookeeper.setData().forPath(SystemConstantsKt.zkGameWorldPath(newWorldId), JSON.toJSONBytes(config));
    } catch (Exception e) {
      throw ExceptionFactory.newAppException("zookeeper server update", e);
    }
    return Optional.empty();
  }

  public Optional<ServerInfo.ServerItem> detail(long worldId) {
    if (!zookeeperCache.worldMappingCache.getWorldIdMapping().containsKey(worldId)) {
      return Optional.empty();
    }
    ZkGameWorldConfig config = zookeeperCache.worldConfigCache.getConfig(worldId);
    return Optional.of(ServerHelper.zkToItem(config));
  }

  public void delete(long worldId) {
    if (!zookeeperCache.worldMappingCache.getWorldIdMapping().containsKey(worldId)) {
      return;
    }
    try {
      zookeeperCache.zookeeper.delete().forPath(SystemConstantsKt.zkGameWorldPath(worldId));
    } catch (Exception e) {
      throw ExceptionFactory.newAppException("zookeeper server delete", e);
    }

  }


}
