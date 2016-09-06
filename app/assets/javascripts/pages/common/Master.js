'use strict';
import React, {Component, PropTypes} from 'react';
import Title from 'react-title-component';
import darkBaseTheme from 'material-ui/styles/baseThemes/darkBaseTheme';
import lightBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import AppBar from 'material-ui/AppBar';
import Drawer from "material-ui/Drawer";
import {Link} from 'react-router'
import {List, ListItem} from 'material-ui/List';
import {darkWhite, lightWhite, grey900} from 'material-ui/styles/colors';
import FullWidthSection from './FullWidthSection';
import AppMenu from '../components/menu/AppMenu';
import withWidth, {MEDIUM, LARGE} from 'material-ui/utils/withWidth';


class Master extends Component {
  getStyles() {
    return {};
  }

  handleChangeMuiTheme = (muiTheme) => {
    this.setState({
      muiTheme: muiTheme,
    });
  };

  getChildContext() {
    return {
      muiTheme: this.state.muiTheme
    };
  }

  componentWillMount() {
    this.setState({
      muiTheme: getMuiTheme(),
    });
  }

  componentWillReceiveProps(nextProps, nextContext) {
    const newMuiTheme = nextContext.muiTheme ? nextContext.muiTheme : this.state.muiTheme;
    this.setState({
      muiTheme: newMuiTheme,
    });
  }

  componentDidMount() {
    const {fetchMenus} = this.props;
    fetchMenus()
  }

  render() {
    const {changeNav, closeNav, navOpen, menus} = this.props;
    const {title} = this.state;
    console.log(this.props);
    return (
      <div>
        <Title render="Test"/>
        <AppBar
          onLeftIconButtonTouchTap={changeNav}
          title={title}
          zDepth={0}
          iconClassNameRight="muidocs-icon-navigation-expand-more"
        />
        <Drawer
          docked={false}
          open={navOpen}
          onRequestChange={closeNav}
        >
          <List>
            <AppBar
              title={menus.subheader}
              onLeftIconButtonTouchTap={changeNav}
              onTitleTouchTap={changeNav}
            />
            <ListItem
              primaryText="Welcome"
              containerElement={<Link to="/"/>}
            />
            <AppMenu menus={menus}/>
          </List>
        </Drawer>

        {this.props.children}

      </div>
    )
  }
}

Master.childContextTypes = {
  muiTheme: React.PropTypes.object,
  navOpen: React.PropTypes.bool,
  showNav: React.PropTypes.func
};

export default withWidth()(Master);


