package db;

import modules.bindings.MongoDB;
import org.junit.After;
import org.junit.Before;
import play.Logger;

public abstract class DBTest {

  @Before
  public void connect() {
    Logger.info("connect to mongoDB...");
    MongoDB.connect();
  }

  @After
  public void close() {
    Logger.info("close the connection...");
    MongoDB.disconnect();
  }


}
