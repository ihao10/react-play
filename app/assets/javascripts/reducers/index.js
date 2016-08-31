import {combineReducers} from 'redux';
import {routerReducer as routing} from 'react-router-redux';
import master from './master';
//import custom-reducers from 'XXX';

const rootReducer = combineReducers({
  // your middlewares
  master,

  routing,
});
export default rootReducer;