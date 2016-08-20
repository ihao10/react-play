import play.Application;
import play.GlobalSettings;
import play.Logger;

@Deprecated
public class Global extends GlobalSettings {
    @Override
    public void beforeStart(Application app) {
        Logger.info("before start");
    }

    @Override
    public void onStart(Application app) {
        Logger.info("app starting...");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("app stop");
    }
}
