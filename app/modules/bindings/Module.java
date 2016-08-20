package modules.bindings;

import com.google.inject.AbstractModule;
import com.mongodb.MongoClient;
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

        Logger.info("initialized...");
    }
}
