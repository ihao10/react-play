package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import constants.ConfigKeyConstants;
import constants.LangKeyConstants;
import message.server.ServerInfo;
import services.utils.RequestUtils;
import services.utils.ResultUtils;
import play.Configuration;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.mvc.Security;
import services.ServerService;

import java.util.Optional;
import java.util.concurrent.CompletionStage;

@Security.Authenticated(Secured.class)
public class Server extends AppController {

  @Inject
  private ServerService serverService;

  @Inject
  private WSClient wsClient;

  @Inject
  private Configuration configuration;

  public Result list(int page, int num) {
    if (num == 0) {
      return badRequest(langGet(LangKeyConstants.PARAM_WRONG));
    }
    final ServerInfo result;
    result = serverService.list(page, num);
    return ok(Json.toJson(result));
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result save() {
    final JsonNode json = request().body().asJson();
    ServerInfo.ServerItem item = Json.fromJson(json, ServerInfo.ServerItem.class);

    if (!checkServerItem(item)) {
      return badRequest(langGet(LangKeyConstants.PARAM_WRONG));
    }

    Optional<String> resultOp = serverService.save(item);
    if (resultOp.isPresent()) {
      return badRequest(resultOp.get());
    }
    return ok();
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result update() {
    final JsonNode json = request().body().asJson();
    ServerInfo.ServerItem item = Json.fromJson(json, ServerInfo.ServerItem.class);

    if (!checkServerItem(item)) {
      return badRequest(langGet(LangKeyConstants.PARAM_WRONG));
    }
    Optional<String> resultOp = serverService.update(item);
    if (resultOp.isPresent()) {
      return badRequest(langGet(resultOp.get()));
    }
    return ok();
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result delete() {
    final JsonNode json = request().body().asJson();
    final String idStr = json.findParent("id").asText();
    final long worldId = Long.parseLong(idStr);
    if (worldId == 0) {
      return badRequest(langGet(LangKeyConstants.PARAM_WRONG));
    }
    serverService.delete(worldId);
    return ok();
  }

  public Result detail(String idStr) {
    final long worldId = Long.parseLong(idStr);
    Optional<ServerInfo.ServerItem> itemOp = serverService.detail(worldId);
    if (itemOp.isPresent()) {
      return ok(Json.toJson(itemOp.get()));
    }
    return badRequest(langGet(LangKeyConstants.NOT_FOUND));
  }


  private boolean checkServerItem(ServerInfo.ServerItem item) {
    if (item.getId() == 0) {
      return false;
    }
    if (item.getOpenLevel() == null) {
      return false;
    }

    return true;
  }

  public CompletionStage<Result> syncFromOperation(String idStr) {
    final long worldId = Long.parseLong(idStr);
    if (worldId == 0) {
      return ResultUtils.asyncBadRequest(langGet(LangKeyConstants.PARAM_WRONG));
    }
    String orgUrl = configuration.getString(ConfigKeyConstants.UUZU_OPGAME_API_URL);
    String url = orgUrl.replace("{serverid}", idStr);
    return RequestUtils.createWSRequest(wsClient, url).get().thenApply(response -> {
      final JsonNode jsonNode = response.asJson();

      // TODO 这边要看下数据结构

      final ServerInfo.ServerItem item = new ServerInfo.ServerItem();


      return ok(Json.toJson(item));
    });
  }


}
