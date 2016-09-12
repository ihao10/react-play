'use strict';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import Server from '../pages/server/Server';
import * as serverActions from '../actions/server';

function mapStateToProps(state) {
  return {
    servers: state.receiveServers
  };
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators(serverActions, dispatch)
}

export default connect(mapStateToProps, mapDispatchToProps)(Server)