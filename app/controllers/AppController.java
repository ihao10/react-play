package controllers;

import play.i18n.MessagesApi;
import play.mvc.Controller;

import javax.inject.Inject;

/**
 * 一些通用的东西可以放在这里
 */
abstract class AppController extends Controller {

  @Inject
  private MessagesApi messagesApi;

  /**
   * 多语言
   * @param i18nId key in conf/messages
   */
  String langGet(String i18nId) {
    return messagesApi.preferred(request()).at(i18nId);
  }



}
