'use strict';
import 'babel-polyfill';
import React, {Component} from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import configureStore from './store/configureStore';
import {hashHistory, IndexRoute} from 'react-router';
import {syncHistoryWithStore} from 'react-router-redux';
import {Router, Route} from 'react-router';
import DevTools from './containers/DevTools.js';
import injectTapEventPlugin from "react-tap-event-plugin";

// 页面组件
// import Master from './pages/common/Master';
// import Header from './pages/common/Header';
// import Users from './pages/Users';
// import welcome from './pages/welcome';
// import GameServers from './pages/GameServers';
import Test from './pages/test/Test';
import Todo from './pages/test/Todo';
import Description from './pages/help/Description';
import Master from './containers/Master';

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
            <Route path="/" component={ Master }>
              <IndexRoute component={Todo}/>
              {/*<Route path="gameServers" component={ GameServers }/>*/}
              {/*<Route path="users" component={ Users }/>*/}
              <Route path="test" component={ Test }/>

              <Route path="gameNews" component={ Todo }/>
              <Route path="gameSubscribe" component={ Todo }/>
              <Route path="manyCats" component={ Todo }/>
              <Route path="description" component={ Description }/>
            </Route>
          </Router>
        </Provider>
        <DevTools store={store}/>
      </div>
    )
  }
}

render(<Index/>, document.getElementById("content"));