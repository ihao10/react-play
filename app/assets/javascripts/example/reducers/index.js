import { combineReducers } from 'redux'
import counter from './counter'
import {routerReducer as routing} from 'react-router-redux';

//使用redux的combineReducers方法将所有reducer打包起来
const rootReducer = combineReducers({
  counter,
  routing
})

export default rootReducer
