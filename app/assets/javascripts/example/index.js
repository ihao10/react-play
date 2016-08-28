'use strict';
import 'babel-polyfill';
import React, {Component} from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import configureStore from './store/configureStore';
import {hashHistory, IndexRoute} from 'react-router';
import {syncHistoryWithStore} from 'react-router-redux';
import {Router, Route} from 'react-router';
// import DevTools from './containers/DevTools.js';
import injectTapEventPlugin from "react-tap-event-plugin";

// 页面组件
import App from './containers/App';
import DevTools from '../containers/DevTools.js';

injectTapEventPlugin();

const store = configureStore()
const history = syncHistoryWithStore(hashHistory, store)

class Index extends Component {

  render() {
    return (
      <div>
        <Provider store={store}>
          <Router history={history}
                  onUpdate={() => window.scrollTo(0, 0)}>
            <Route path="/" component={ App }>
            </Route>
          </Router>
        </Provider>
        <DevTools store={store}/>
      </div>
    )
  }
}

render(<Index/>, document.getElementById("content"));