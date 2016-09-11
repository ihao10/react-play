package modules.filters;

import com.google.inject.Inject;
import play.filters.gzip.GzipFilter;
import play.http.DefaultHttpFilters;

public class Filters extends DefaultHttpFilters {
  @Inject
  public Filters(GzipFilter gzipFilter, LoggingFilter loggingFilter) {
    super(gzipFilter, loggingFilter);
  }

}
