package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import message.server.ServerInfo;
import models.utils.AppException;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.ServerService;

import java.util.Optional;

@Security.Authenticated(Secured.class)
public class Server extends Controller {

  @Inject
  private ServerService serverService;

  public Result test() {
    return ok();
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result list() {
    final JsonNode json = request().body().asJson();
    final int page = json.findParent("page").asInt(1);
    final int num = json.findParent("num").asInt();
    if (num == 0) {
      return badRequest("param wrong");
    }
    final ServerInfo result;
    try {
      result = serverService.list(num, page);
    } catch (AppException e) {
      return internalServerError(e.getMessage());
    }
    return ok(Json.toJson(result));
  }

  @BodyParser.Of(BodyParser.Json.class)
  public Result save() {
    final JsonNode json = request().body().asJson();
    ServerInfo.ServerItem item = Json.fromJson(json, ServerInfo.ServerItem.class);
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

}
