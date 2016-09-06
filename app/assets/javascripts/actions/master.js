'use strict';
import * as appFetch from '../utils/appFetch';

export const CHANGE_NAV = 'CHANGE_NAV';
export const CLOSE_NAV = 'CLOSE_NAV';
export const RECEIVE_MENUS = 'RECEIVE_MENUS';
export const REQUEST_MENUS = 'REQUEST_MENUS';

// 显示或关闭菜单
export function changeNav() {
  return {
    type: CHANGE_NAV
  }
}

export function closeNav() {
  return {
    type: CLOSE_NAV
  }
}

function requestMenus() {
  return {
    type: REQUEST_MENUS
  }
}

export function fetchMenus() {
  return dispatch => {
    dispatch(requestMenus());
    return dispatch(receiveMenus(jsonMenu));
    // return appFetch.read('/menu')
    //   .then(response => response.json())
    //   .then(json=>dispatch(receiveMenus(json)))

  }
}

function receiveMenus(menus) {
  return {
    type: RECEIVE_MENUS,
    menus: menus
  }
}

const jsonMenu = {
  "subheader": "Love You",
  "list": [
    {
      "menu": "Manage",
      "list": [
        {"menu": "Server List", "value": "/server-list"},
        {"menu": "Server Open", "value": "/server-open"}
      ]
    },
    {
      "menu": "Player",
      "list": [
        {"menu": "Player List", "value": "/player-list"},
        {"menu": "Resource List", "value": "/resource-list"}
      ]
    },
    {
      "menu": "Data",
      "list": []
    }
  ]
};