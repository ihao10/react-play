package services;

import play.Logger;

import javax.inject.Singleton;

@Singleton
public class UserServiceImpl implements UserService {

    @Override
    public void test() {
        Logger.info("service test.....");
    }
}
