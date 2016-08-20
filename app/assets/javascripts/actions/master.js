'use strict';
import * as appFetch from '../utils/appFetch';

export const SHOW_NAV = 'SHOW_NAV';
export const RECEIVE_MENUS = 'RECEIVE_MENUS';
export const REQUEST_MENUS = 'REQUEST_MENUS';

// 显示或关闭菜单
export function showNav() {
  return {
    type: SHOW_NAV
  }
}

function requestMenus() {
  return {
    type: REQUEST_MENUS
  }
}

function fetchMenus() {
  return dispatch => {
    dispatch(requestMenus());
    return appFetch.read('/menu')
      .then(response => response.json())
      .then(json=>dispatch(receiveMenus(json)))

  }
}

function receiveMenus(menus) {
  return {
    type: RECEIVE_MENUS,
    menus: menus,
    receivedAt: Date.now()
  }
}