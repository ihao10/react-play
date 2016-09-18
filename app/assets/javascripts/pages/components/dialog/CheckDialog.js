'use strict';

import React from 'react';
import Dialog from 'material-ui/Dialog';
import FlatButton from 'material-ui/FlatButton';

export default class CheckDialog extends React.Component {

  handleFunc = ()=> {
    const {onClose, onOpen} = this.props;
    onOpen();
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
      />,
    ];

    return (
      <div>
        <Dialog
          title={title || 'TIPS'}
          actions={actions}
          modal={false}
          open={open}
          onRequestClose={onClose}
        >
          {memo || 'UNKNOWN TIPS'}
        </Dialog>
      </div>
    );
  }


}