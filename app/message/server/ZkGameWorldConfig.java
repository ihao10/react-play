package message.server;

import java.util.Date;

public class ZkGameWorldConfig {
  private long id;
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
