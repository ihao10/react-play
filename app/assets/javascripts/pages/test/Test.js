'use strict';
import React, {Component, PropTypes} from 'react';

export default class Test extends Component {

  render() {

    const {trueOrFalse, showNav2} = this.props;

    return (
      <div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <button onClick={showNav2}>
          +
        </button>
        test: {trueOrFalse}
      </div>
    )
  }
}

