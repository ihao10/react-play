package modules.bindings;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MongoDB {

    public static MongoClient mongoClient;

    public static Morphia morphia;

    public static Datastore datastore;

    public static void connect() {
        morphia = new Morphia();
        mongoClient = new MongoClient();
        morphia.mapPackage("models");
        datastore = morphia.createDatastore(mongoClient, "test");
        datastore.ensureIndexes();
    }

    public static void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
        datastore = null;
        morphia = null;
    }
}
