package modules.bindings;

import com.google.inject.AbstractModule;
import play.Logger;


/**
 * 特殊单实例绑定
 */
public class InstantModule extends AbstractModule {
  @Override
  protected void configure() {
    Logger.info("InstantModule initializing...");

    bind(EagerBindings.class).to(GlobalBinding.class).asEagerSingleton();

    Logger.info("InstantModule initialized...");
  }
}
