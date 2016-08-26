import {combineReducers} from 'redux';
import {routerReducer as routing} from 'react-router-redux';
import master from './master';
import test from './test';
//import custom-reducers from 'XXX';

const rootReducer = combineReducers({
  routing,
  // your middlewares
  master,
  test
});
export default rootReducer;