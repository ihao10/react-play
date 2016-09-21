package services.utils;

import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ResultUtils {

  public static CompletionStage<Result> asyncOk = CompletableFuture.supplyAsync(Results::ok);

  public static CompletionStage<Result> asyncBadRequest(String errorMemo) {
    return CompletableFuture.supplyAsync(() -> Results.badRequest(errorMemo));
  }


}
