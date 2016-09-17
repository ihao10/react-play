'use strict';
import React, {PropTypes} from 'react';
import IconButton from 'material-ui/IconButton';
import CodeIcon from 'material-ui/svg-icons/action/code';
import {Toolbar, ToolbarGroup, ToolbarTitle} from 'material-ui/Toolbar';

const styles = {
  headline: {
    fontSize: 24,
    fontWeight: 800
  }
};

const MainBlockTitle = (props) => (
  <Toolbar>
    <ToolbarGroup>
      <ToolbarTitle text={props.title || 'Module'} />
    </ToolbarGroup>
    <ToolbarGroup>
      <IconButton touch={true} tooltip={props.tooltip}>
        <CodeIcon />
      </IconButton>
    </ToolbarGroup>
  </Toolbar>
);

MainBlockTitle.propTypes = {
  title: PropTypes.string,
  tooltip: PropTypes.string
};

export default MainBlockTitle;
