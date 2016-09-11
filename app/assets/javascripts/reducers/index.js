'use strict';

import {combineReducers} from 'redux';
import {routerReducer as routing} from 'react-router-redux';
import {changeNav, fetchMenus} from './master';
//import custom-reducers from 'XXX';

const rootReducer = combineReducers({
  // your middlewares
  changeNav,
  fetchMenus,

  routing
});
export default rootReducer;