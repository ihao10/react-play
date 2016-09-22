package message.server;

import com.youzu.topsango.shared.WorldOpenLevel;
import message.AppMessage;

import java.util.Date;
import java.util.List;

public class ServerInfo implements AppMessage {

  private int page;
  private int totalPage;
  private int totalNum;
  private List<ServerItem> items;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(int totalNum) {
    this.totalNum = totalNum;
  }

  public List<ServerItem> getItems() {
    return items;
  }

  public void setItems(List<ServerItem> items) {
    this.items = items;
  }

  public static class ServerItem implements AppMessage {
    private long id;
    private WorldOpenLevel openLevel = WorldOpenLevel.TEST;
    private String name;
    private String passportKey;
    private String flashUrl;
    private Date worldOpenTime;
    private String userDataCenterUrl;

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public WorldOpenLevel getOpenLevel() {
      return openLevel;
    }

    public void setOpenLevel(WorldOpenLevel openLevel) {
      this.openLevel = openLevel;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPassportKey() {
      return passportKey;
    }

    public void setPassportKey(String passportKey) {
      this.passportKey = passportKey;
    }

    public String getFlashUrl() {
      return flashUrl;
    }

    public void setFlashUrl(String flashUrl) {
      this.flashUrl = flashUrl;
    }

    public Date getWorldOpenTime() {
      return worldOpenTime;
    }

    public void setWorldOpenTime(Date worldOpenTime) {
      this.worldOpenTime = worldOpenTime;
    }

    public String getUserDataCenterUrl() {
      return userDataCenterUrl;
    }

    public void setUserDataCenterUrl(String userDataCenterUrl) {
      this.userDataCenterUrl = userDataCenterUrl;
    }
  }


  // TODO 字段可能还需要增加
  public static class ServerDetail implements AppMessage {
    private long id;
    private WorldOpenLevel openLevel = WorldOpenLevel.TEST;
    private String name;
    private String passportKey;
    private String flashUrl;
    private Date worldOpenTime;
    private String userDataCenterUrl;

    // 下面是从OperationPlatform来的数据

    /**
     * 挺重要的一个ID
     */
    private String opgameId;
    /**
     * 运营商ID
     */
    private List<String> opId;
    /**
     * 充值地址
     */
    private String rechargeUrl;
    /**
     * 服务器key
     */
    private String serverKey;

    /**
     * 服务区域名
     */
    private String serverUrl;

    /**
     * 区组对应服务器IP
     */
    private String serverIp;

    /**
     * 内网IP
     */
    private String serverNip;

    /**
     * 防沉迷时间
     */
    private String fcmTime;

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public WorldOpenLevel getOpenLevel() {
      return openLevel;
    }

    public void setOpenLevel(WorldOpenLevel openLevel) {
      this.openLevel = openLevel;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPassportKey() {
      return passportKey;
    }

    public void setPassportKey(String passportKey) {
      this.passportKey = passportKey;
    }

    public String getFlashUrl() {
      return flashUrl;
    }

    public void setFlashUrl(String flashUrl) {
      this.flashUrl = flashUrl;
    }

    public Date getWorldOpenTime() {
      return worldOpenTime;
    }

    public void setWorldOpenTime(Date worldOpenTime) {
      this.worldOpenTime = worldOpenTime;
    }

    public String getUserDataCenterUrl() {
      return userDataCenterUrl;
    }

    public void setUserDataCenterUrl(String userDataCenterUrl) {
      this.userDataCenterUrl = userDataCenterUrl;
    }

    public String getOpgameId() {
      return opgameId;
    }

    public void setOpgameId(String opgameId) {
      this.opgameId = opgameId;
    }

    public List<String> getOpId() {
      return opId;
    }

    public void setOpId(List<String> opId) {
      this.opId = opId;
    }

    public String getRechargeUrl() {
      return rechargeUrl;
    }

    public void setRechargeUrl(String rechargeUrl) {
      this.rechargeUrl = rechargeUrl;
    }

    public String getServerKey() {
      return serverKey;
    }

    public void setServerKey(String serverKey) {
      this.serverKey = serverKey;
    }

    public String getServerUrl() {
      return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
      this.serverUrl = serverUrl;
    }

    public String getServerIp() {
      return serverIp;
    }

    public void setServerIp(String serverIp) {
      this.serverIp = serverIp;
    }

    public String getServerNip() {
      return serverNip;
    }

    public void setServerNip(String serverNip) {
      this.serverNip = serverNip;
    }

    public String getFcmTime() {
      return fcmTime;
    }

    public void setFcmTime(String fcmTime) {
      this.fcmTime = fcmTime;
    }
  }


}


