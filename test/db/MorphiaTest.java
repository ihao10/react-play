package db;

import models.User;
import modules.bindings.MongoDB;
import org.junit.Test;

public class MorphiaTest extends DBTest {

  @Test
  public void test() {
    User user = new User();
    user.setAccount("admin");
    user.setPassword("1");
    MongoDB.datastore.save(user);
  }
}
