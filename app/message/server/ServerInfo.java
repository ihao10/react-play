package message.server;

import message.AppMessage;

import java.util.Date;
import java.util.List;

public class ServerInfo implements AppMessage {

  private int page;
  private int totalPage;
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

  public List<ServerItem> getItems() {
    return items;
  }

  public void setItems(List<ServerItem> items) {
    this.items = items;
  }


  /** 所有字段都传过去吧，省得搞2个类了 */
  public static class ServerItem {
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
}


