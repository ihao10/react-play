'use strict';

import {combineReducers} from 'redux';
import {routerReducer as routing} from 'react-router-redux';
import {changeNav, fetchMenus} from './master';
import {receiveServers} from './server';
//import custom-reducers from 'XXX';

const rootReducer = combineReducers({
  // your middlewares
  changeNav,
  fetchMenus,
  receiveServers,

  routing
});
export default rootReducer;