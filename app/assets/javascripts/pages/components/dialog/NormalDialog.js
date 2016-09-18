'use strict';

import React from 'react';
import Dialog from 'material-ui/Dialog';
import FlatButton from 'material-ui/FlatButton';
import RaisedButton from 'material-ui/RaisedButton';

export default class NormalDialog extends React.Component {

  state = {
    open: false
  };

  handleOpen = ()=> {
    this.setState({open: true});
  };
  handleClose = ()=> {
    this.setState({open: false})
  };

  handleFunc = func=> {
    func();
    this.setState({open: false})
  };

  render() {

    const {title, memo,} = this.props;

    const actions = [
      <FlatButton
        label="Cancel"
        primary={true}
        onTouchTap={this.handleClose}
      />,
      <FlatButton
        label="Ok"
        primary={true}
        keyboardFocused={true}
        onTouchTap={this.handleClose}
      />,
    ];


    return (
      <div>
        <Dialog
          title={title || 'TIPS'}
          actions={actions}
          modal={false}
          open={this.state.open}
          onRequestClose={this.handleClose}
        >
          {memo || 'UNKNOWN TIPS'}
        </Dialog>
      </div>
    );
  }


}