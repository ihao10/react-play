package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import modules.bindings.GlobalBinding;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class Test extends AppController {

  @Inject
  private GlobalBinding globalCache;


  public Result index() {
    String message = Messages.get(globalCache.test);
    return ok(message);
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result sendJson() {
    JsonNode json = request().body().asJson();
    Json.fromJson(json, List.class);
    return ok();
  }

  public Result getJson() {
    Map<String, String> map = Maps.newHashMap();
    map.put("1", "a");
    map.put("b", globalCache.test);
    return ok(langGet("user.info"));
  }


  public CompletionStage<Result> test() {
    return CompletableFuture.supplyAsync(() -> {
      return "1";
    })
        .thenApply(i -> ok("Got result: " + i));
  }
}
