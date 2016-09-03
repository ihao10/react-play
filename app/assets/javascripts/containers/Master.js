'use strict';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import Master from '../pages/common/Master';
import * as masterActions from '../actions/master';

//将state.navOpen绑定到props的navOpen
function mapStateToProps(state) {
  return {
    master: state.master
  };
}

//将action的所有方法绑定到props上
function mapDispatchToProps(dispatch) {
  return bindActionCreators(masterActions, dispatch)
}

//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
export default connect(mapStateToProps, mapDispatchToProps)(Master)
