import com.google.common.collect.Lists;
import models.Menu;
import modules.bindings.MongoDB;
import org.junit.Test;
import play.Logger;

import java.util.List;


/** 和关系型数据库不同，这边没有sql */
public class MenuCreate extends DBTest {

    /**
     * version 0.0.0
     */
    @Test
    public void createMenu() {
        Logger.info("creating menus...");

        List<Menu> menus = Lists.newArrayList();

        menus.add(new Menu(1, "User Management", "", 0));
        menus.add(new Menu(2, "User Management", "", 0));

        MongoDB.datastore.save(menus);
        MongoDB.datastore.save(new Menu(3, "User Management", "", 0));
        Logger.info("menus saved...");
    }


    /**
     * version 0.0.1
     */
    @Test
    public void addMenu1() {
        Logger.info("adding menus...");

        Logger.info("menus saved...");
    }


    /**
     * version 0.0.2
     */
    @Test
    public void addMenu2() {
        Logger.info("adding menus...");

        Logger.info("menus saved...");
    }


}
