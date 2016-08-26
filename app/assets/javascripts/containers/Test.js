'use strict';

import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import Test from '../pages/test/Test';
import * as masterActions from '../actions/master';

function mapStateToProps(state) {
  return {
    trueOrFalse: state.trueOrFalse
  };
}

//将action的所有方法绑定到props上
function mapDispatchToProps(dispatch) {
  return bindActionCreators(masterActions, dispatch)
}
export default connect(mapStateToProps, mapDispatchToProps)(Test)