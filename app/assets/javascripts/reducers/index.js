'use strict';

import {combineReducers} from 'redux';
import {routerReducer as routing} from 'react-router-redux';
import {changeNav, fetchMenus} from './master';
import {receiveServers, createServer} from './server';
import { reducer as form } from 'redux-form'
//import custom-reducers from 'XXX';

const rootReducer = combineReducers({
  routing,
  form,
  // your middlewares
  changeNav,
  fetchMenus,
  receiveServers,
  createServer,


});
export default rootReducer;