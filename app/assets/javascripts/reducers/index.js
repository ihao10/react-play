'use strict';

import {combineReducers} from 'redux';
import {routerReducer as routing} from 'react-router-redux';
import {changeNav, fetchMenus} from './master';
import {receiveServers} from './server';
import { reducer as formReducer } from 'redux-form'
//import custom-reducers from 'XXX';

const rootReducer = combineReducers({
  // your middlewares
  changeNav,
  fetchMenus,
  receiveServers,

  form: formReducer,
  routing
});
export default rootReducer;