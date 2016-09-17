package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import message.server.ServerInfo;
import models.utils.AppException;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.mvc.Security;
import services.ServerService;

import java.util.Optional;

@Security.Authenticated(Secured.class)
public class Server extends AppController {

  @Inject
  private ServerService serverService;

  public Result list(int page, int num) {
    if (num == 0) {
      return badRequest(langGet("param.wrong"));
    }
    final ServerInfo result;
    try {
      result = serverService.list(page, num);
    } catch (AppException e) {
      return internalServerError(e.getMessage());
    }
    return ok(Json.toJson(result));
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result save() {
    final JsonNode json = request().body().asJson();
    ServerInfo.ServerItem item = Json.fromJson(json, ServerInfo.ServerItem.class);

    if (!checkServerItem(item)) {
      return badRequest(langGet("param.wrong"));
    }

    try {
      Optional<String> resultOp = serverService.save(item);
      if (resultOp.isPresent()) {
        return badRequest(resultOp.get());
      }
      return ok();
    } catch (AppException e) {
      return internalServerError(e.getMessage());
    }
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result update() {
    final JsonNode json = request().body().asJson();
    ServerInfo.ServerItem item = Json.fromJson(json, ServerInfo.ServerItem.class);

    if (!checkServerItem(item)) {
      return badRequest(langGet("param.wrong"));
    }
    try {
      Optional<String> resultOp = serverService.update(item);
      if (resultOp.isPresent()) {
        return badRequest(langGet(resultOp.get()));
      }
      return ok();
    } catch (AppException e) {
      return internalServerError(e.getMessage());
    }
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result delete() {
    final JsonNode json = request().body().asJson();
    final String idStr = json.findParent("id").asText();
    final long worldId = Long.parseLong(idStr);
    if (worldId == 0) {
      return badRequest(langGet("param.wrong"));
    }
    try {
      serverService.delete(worldId);
    } catch (AppException e) {
      return internalServerError(e.getMessage());
    }
    return ok();
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result detail(String idStr) {
    final long worldId = Long.parseLong(idStr);
    Optional<ServerInfo.ServerItem> itemOp = serverService.detail(worldId);
    if (itemOp.isPresent()) {
      return ok(Json.toJson(itemOp.get()));
    }
    return badRequest(langGet("not.found"));
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
}
