package services.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.youzu.topsango.shared.configuration.ZkGameWorldConfig;
import message.server.ServerInfo;

import java.util.List;

// TODO 有没更好的办法
public class ServerHelper {

  public static TypeReference STRING_LIST = new TypeReference<List<String>>() {
  };

  public static ZkGameWorldConfig itemToZK(ServerInfo.ServerItem item) {
    ZkGameWorldConfig zkGameWorldConfig = new ZkGameWorldConfig();
    zkGameWorldConfig.setId(item.getId());
    zkGameWorldConfig.setFlashUrl(item.getFlashUrl());
    zkGameWorldConfig.setName(item.getName());
    zkGameWorldConfig.setOpenLevel(item.getOpenLevel());
    zkGameWorldConfig.setPassportKey(item.getPassportKey());
    zkGameWorldConfig.setUserDataCenterUrl(item.getUserDataCenterUrl());
    zkGameWorldConfig.setWorldOpenTime(item.getWorldOpenTime());
    return zkGameWorldConfig;
  }

  public static ServerInfo.ServerItem zkToItem(ZkGameWorldConfig config) {
    ServerInfo.ServerItem display = new ServerInfo.ServerItem();
    display.setId(config.getId());
    display.setWorldOpenTime(config.getWorldOpenTime());
    display.setUserDataCenterUrl(config.getUserDataCenterUrl());
    display.setPassportKey(config.getPassportKey());
    display.setFlashUrl(config.getFlashUrl());
    display.setName(config.getName());
    display.setOpenLevel(config.getOpenLevel());
    return display;
  }

  public static ServerInfo.ServerDetail zkToDetail(ZkGameWorldConfig config) {
    ServerInfo.ServerDetail display = new ServerInfo.ServerDetail();
    display.setId(config.getId());
    display.setWorldOpenTime(config.getWorldOpenTime());
    display.setUserDataCenterUrl(config.getUserDataCenterUrl());
    display.setPassportKey(config.getPassportKey());
    display.setFlashUrl(config.getFlashUrl());
    display.setName(config.getName());
    display.setOpenLevel(config.getOpenLevel());
    return display;
  }

}
