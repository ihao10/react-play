package modules.bindings;

import com.google.inject.AbstractModule;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import play.Configuration;
import play.Environment;
import play.Logger;

@SuppressWarnings("FieldCanBeLocal")
public class DbModule extends AbstractModule {

  private final Environment environment;
  private final Configuration configuration;

  public DbModule(Environment environment, Configuration configuration) {
    this.environment = environment;
    this.configuration = configuration;
  }

  @Override
  protected void configure() {
    Logger.info("DbModule initializing...");

    final Morphia morphia = new Morphia();
    // 默认本地
    final MongoClient mongoClient = new MongoClient();
    morphia.mapPackage("models");
    final Datastore datastore = morphia.createDatastore(mongoClient, "test");
    datastore.ensureIndexes();
    datastore.ensureCaps();
    Logger.info("connect db");

    bind(MongoClient.class).toInstance(mongoClient);
    bind(Datastore.class).toInstance(datastore);

    Logger.info("DbModule initialized...");
  }
}
