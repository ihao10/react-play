import {createStore, applyMiddleware, compose} from 'redux'
import rootReducer from '../reducers'
import DevTools from '../containers/DevTools';
import thunkMiddleware from 'redux-thunk';
import createLogger from 'redux-logger';

export default function configureStore(initial) {
  const enhancer = compose(
    //要使用的中间件，放在前面
    applyMiddleware(thunkMiddleware, createLogger()),
    // 启用chrome redux插件
    // window.devToolsExtension ? window.devToolsExtension() : f => f
    //启用带有monitors（监视显示）的DevTools
    DevTools.instrument()
  );

  const store = createStore(rootReducer, initial, enhancer);

  if (module.hot) {
    // Enable Webpack hot module replacement for reducers
    module.hot.accept('../reducers', () => {
      const nextRootReducer = require('../reducers').default;
      store.replaceReducer(nextRootReducer)
    })
  }
  return store
}