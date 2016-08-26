package controllers;

import models.User;
import org.mongodb.morphia.Datastore;
import play.cache.CacheApi;
import play.cache.NamedCache;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import views.html.*;

import javax.inject.Inject;

public class LoginCtrl extends Controller {
    @Inject
    FormFactory formFactory;
    @Inject
    Datastore datastore;
    @Inject
    UserService userService;

    /**
     * 没有session的概念，权限控制将在缓存中判断
     */
    @Inject
    @NamedCache("session-cache")
    CacheApi cache;

    public Result login() {
        return ok(login.render(formFactory.form(Login.class)));
    }

    public Result authenticate() {

        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            final String account = loginForm.data().get("account");
            final String password = loginForm.data().get("password");
            User user = datastore.createQuery(User.class).field("account").equalIgnoreCase(account).get();
            if (user == null || !password.equals(user.getPassword())) {
                return unauthorized(login.render(loginForm));
            }
            session().clear();
            session("account", account);
            return redirect(routes.Application.index());
        }
    }

    public Result logout() {
        session().clear();
        return redirect(routes.LoginCtrl.login());
    }

    public static class Login {
        public String account;
        public String password;
    }

}
