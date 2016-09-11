package modules.filters;

import akka.stream.Materializer;
import com.google.inject.Inject;
import play.Logger;
import play.mvc.Filter;
import play.mvc.Http;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class LoggingFilter extends Filter {

  @Inject
  public LoggingFilter(Materializer mat) {
    super(mat);
  }

  @Override
  public CompletionStage<Result> apply(Function<Http.RequestHeader, CompletionStage<Result>> next, Http.RequestHeader rh) {
    long startTime = System.currentTimeMillis();
    return next.apply(rh).thenApply(result -> {
      long endTime = System.currentTimeMillis();
      long costTime = endTime - startTime;
      Logger.info("{} took {}ms status {} uri {}",
          rh.method(),
          costTime,
          result.status(),
          rh.uri()
      );
      return result.withHeader("Request-Time", "" + costTime);
    });
  }
}
