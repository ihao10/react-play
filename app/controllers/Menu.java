package controllers;

import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(Secured.class)
public class Menu extends AppController {

    public Result Menu() {

        return ok();

    }
}
