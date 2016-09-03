package modules.bindings;

import com.google.inject.AbstractModule;
import com.mongodb.MongoClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import play.Logger;
import services.UserService;
import services.UserServiceImpl;

public class Module extends AbstractModule {

  @Override
  protected void configure() {
    Logger.info("initializing...");

    final Morphia morphia = new Morphia();
    // 默认本地
    final MongoClient mongoClient = new MongoClient();
    morphia.mapPackage("models");
    final Datastore datastore = morphia.createDatastore(mongoClient, "test");
    datastore.ensureIndexes();
    Logger.info("connect db");

    bind(MongoClient.class).toInstance(mongoClient);
    bind(Datastore.class).toInstance(datastore);

    // 没找到官方扫描单实例的方法
    // 所有单实例暂时需要全部在这里注册
    bind(UserService.class).to(UserServiceImpl.class);
    bind(EagerBindings.class).to(GlobalBinding.class).asEagerSingleton();

//    bindZookeeper();

    Logger.info("initialized...");
  }


  void bindZookeeper() {
    Logger.info("connect zookeeper...");
    final CuratorFramework zookeeper = CuratorFrameworkFactory.builder()
        .connectString("192.168.180.106:2181")
        .sessionTimeoutMs(5000)
        .connectionTimeoutMs(5000)
        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
        .build();
    zookeeper.start();
    bind(CuratorFramework.class).toInstance(zookeeper);
    Logger.info("zookeeper connected");
  }


  void bindDatabase() {

  }


}
