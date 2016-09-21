package services.utils;

import constants.AppConstants;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;

public class RequestUtils {

  public static WSRequest createWSRequest(WSClient client, String url) {
    WSRequest request = client.url(url);
    request.setRequestTimeout(AppConstants.REQUEST_TIMEOUT);
    return request;
  }

}
