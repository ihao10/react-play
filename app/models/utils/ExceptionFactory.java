package models.utils;

import play.Logger;

public class ExceptionFactory {

  public static AppException newAppException(Exception exception) {
    Logger.error(exception.getMessage());
    return new AppException(exception);
  }

  public static AppException newAppException(String message, Exception exception) {
    Logger.error(exception.getMessage());
    return new AppException(message, exception);
  }

  public static RuntimeException newRuntimeException(Exception exception) {
    Logger.error(exception.getMessage());
    return new RuntimeException(exception);
  }

  public static RuntimeException newRuntimeException(String message, Exception exception) {
    Logger.error(exception.getMessage());
    return new RuntimeException(message, exception);
  }

}
