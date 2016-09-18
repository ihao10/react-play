'use strict';

import React from 'react';
import Dialog from 'material-ui/Dialog';
import FlatButton from 'material-ui/FlatButton';
// import RaisedButton from 'material-ui/RaisedButton';

export default class ErrorDialog extends React.Component {

  handleFunc = ()=> {
    const {onFunc, onClose} = this.props;
    if (onFunc != null) {
      onFunc();
    }
    onClose();
  };

  render() {

    const {title, memo, open, onClose} = this.props;

    const actions = [
      <FlatButton
        label="Cancel"
        primary={true}
        onTouchTap={onClose}
      />,
      <FlatButton
        label="Ok"
        primary={true}
        keyboardFocused={true}
        onTouchTap={this.handleFunc}
      />
    ];

    return (
      <div>
        <Dialog
          title={title || 'ERROR'}
          actions={actions}
          modal={false}
          open={open}
          onRequestClose={onClose}
        >
          {memo || 'UNKNOWN ERROR'}
        </Dialog>
      </div>
    );
  }

}