'use strict';
import {RECEIVE_MENUS, CHANGE_NAV, CLOSE_NAV} from '../actions/master';

export function changeNav(state = false, action) {
  switch (action.type) {
    case CHANGE_NAV:
      return !state;
    case CLOSE_NAV:
      return false;
    default:
      return state
  }
}

export function fetchMenus(state = {
  subheader: "subheader",
  list: []
}, action) {
  switch (action.type) {
    case RECEIVE_MENUS:
      return action.menus;

    default:
      return state;
  }
}
