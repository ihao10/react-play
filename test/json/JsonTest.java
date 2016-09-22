package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import play.api.libs.json.Json;

import java.io.IOException;

public class JsonTest {

  @Test
  public void test() {
    final String json = "{\"desc\":\"adfsdf42314dw1f\",\"state\":\"0\",\"data\":{\"op_id\":\"123\"}}";
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode jsonNode = mapper.readTree(json);
      JsonNode node1 = jsonNode.findValue("data");
      JsonNode node2 = jsonNode.findParent("data");
      JsonNode node3 = jsonNode.findPath("data");

      System.out.println(node1.asText());
      System.out.println(node2.asText());
      System.out.println(node3.asText());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
