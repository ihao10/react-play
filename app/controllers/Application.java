package controllers;

import play.cache.Cached;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

@Security.Authenticated(Secured.class)
@Cached(key = "homePage")
public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }

}
