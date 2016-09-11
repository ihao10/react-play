package services.helper;

import message.server.ServerInfo;
import message.server.ZkGameWorldConfig;

public class ServerHelper {

  public static ZkGameWorldConfig itemToZK(ServerInfo.ServerItem item) {


    return new ZkGameWorldConfig();
  }


  public static ServerInfo.ServerItem zkToItem(ZkGameWorldConfig config) {


    return new ServerInfo.ServerItem();
  }

}
