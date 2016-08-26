package db;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 同步驱动
 */
public class SyncDbTest {

  private MongoClient client;

  @Before
  public void open() {
    client = new MongoClient(new ServerAddress("localhost"));
  }

  @After
  public void close() {
    client.close();
  }


  @Test
  public void access() {

  }

  @Test
  public void find() {
    MongoDatabase db = client.getDatabase("test");
    db.getCollection("runoob").find().forEach((Block<Document>) document ->

        System.out.println(document.toJson()));

  }

  @Test
  public void insert() {
    MongoDatabase db = client.getDatabase("test");
    MongoCollection<Document> collection = db.getCollection("runoob");
    Document doc = new Document("account", "player1")
        .append("password", "password")
        .append("count", 1)
        .append("info", new Document("x", 203).append("y", 102));

    collection.insertOne(doc);

  }
}