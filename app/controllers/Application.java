package controllers;

import play.cache.Cached;
import play.mvc.Result;
import play.mvc.Security;
import views.html.index;

@Security.Authenticated(Secured.class)
@Cached(key = "homePage")
public class Application extends AppController {

    public Result index() {
        return ok(index.render());
    }

}
