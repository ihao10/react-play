package db;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 异步驱动
 */
public class AsyncDbTest {

    private MongoClient asyncClient;

    @Before
    public void open() {
        asyncClient = MongoClients.create(new ConnectionString("mongodb://localhost:27017/?replicaSet=rs0&maxPoolSize=200"));
        System.out.println("open client");
    }

    @After
    public void close() {
        asyncClient.close();
        System.out.println("close client");
    }

    @Test
    public void test() {
        final CountDownLatch latch = new CountDownLatch(1);
        MongoDatabase db = asyncClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("runoob");
        Document doc = new Document("name", "player")
                .append("type", "database")
                .append("account", "123@321.com")
                .append("password", "pass")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc, (result, t) -> {
            System.out.println("insert json:" + doc.toJson());
            latch.countDown();
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
