package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(Secured.class)
public class MenuCtrl extends Controller {

    public Result Menu() {

        return ok();

    }
}
