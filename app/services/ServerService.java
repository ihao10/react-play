package services;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.math.IntMath;
import com.google.inject.Inject;
import message.server.ServerInfo;
import message.server.ZkGameWorldConfig;
import models.utils.AppException;
import models.utils.ExceptionFactory;
import modules.bindings.ZookeeperCache;
import org.apache.curator.framework.recipes.cache.ChildData;
import play.Configuration;
import services.helper.ServerHelper;

import javax.inject.Singleton;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Singleton
public class ServerService {
  @Inject
  private Configuration config;

  @Inject
  private ZookeeperCache zookeeperCache;

  public ServerInfo list(int page, int num) throws AppException {
    ServerInfo serverInfo = new ServerInfo();
    serverInfo.setPage(page);
    try {
      List<ChildData> datas = zookeeperCache.serverCache.getCurrentData();
      int total = datas.size();
      int beginIndex = IntMath.checkedMultiply(num, page - 1);
      if (total < beginIndex) {
        return serverInfo;
      }
      int endIndex = IntMath.checkedMultiply(num, page);
      List<ChildData> need = datas.subList(beginIndex, Math.min(endIndex, total - 1));
      List<ServerInfo.ServerItem> list = Lists.newArrayListWithCapacity(need.size());
      need.forEach(data ->{
        String json = new String(data.getData(), StandardCharsets.UTF_8);
        ZkGameWorldConfig config = JSON.parseObject(json, ZkGameWorldConfig.class);
        list.add(ServerHelper.zkToItem(config));
      });
      serverInfo.setItems(list);
    } catch (Exception e) {
      throw ExceptionFactory.newAppException("zookeeper server list", e);
    }
    return serverInfo;
  }

  public ServerInfo.ServerItem detail() {


    return new ServerInfo.ServerItem();
  }

  public Optional<String> save(ServerInfo.ServerItem item) throws AppException {
    String root = config.getString("game.root");
    try {
      zookeeperCache.zookeeper.create().forPath(root + "/" + item.getId(), JSON.toJSONBytes(item));
    } catch (Exception e) {
      throw ExceptionFactory.newAppException("zookeeper server save", e);
    }
    return Optional.empty();
  }

}
