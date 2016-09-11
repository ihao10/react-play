package modules.bindings;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import play.Logger;
import services.ServerService;
import services.UserService;
import services.UserServiceImpl;

/**
 * 单实例服务类绑定
 */
public class ServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    Logger.info("ServiceModule initializing...");

    // 没找到官方扫描单实例的方法
    // 所有单实例暂时需要全部在这里注册
    bind(UserService.class).to(UserServiceImpl.class);
    bind(ServerService.class).in(Singleton.class);

    Logger.info("ServiceModule initialized...");
  }
}
