package modules.bindings;

import play.Logger;

import javax.inject.Singleton;

@Singleton
public class GlobalBinding implements EagerBindings {
    static {
        Logger.info("creating GlobalContainer");
    }

    public volatile String test = "hello";

}
