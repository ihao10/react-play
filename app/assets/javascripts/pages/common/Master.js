'use strict';
import React, {Component, PropTypes} from 'react';
import Title from 'react-title-component';
import darkBaseTheme from 'material-ui/styles/baseThemes/darkBaseTheme';
import lightBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import AppBar from 'material-ui/AppBar';
import Drawer from "material-ui/Drawer";
import Divider from "material-ui/Divider";
import {darkWhite, lightWhite, grey900} from 'material-ui/styles/colors';
import FullWidthSection from './FullWidthSection';
// import AppNavDrawer from './AppNavDrawer';
import AppMenu from '../components/menu/AppMenu';
import withWidth, {MEDIUM, LARGE} from 'material-ui/utils/withWidth';

const item = {
  menu: "menu11",
  icon: "icon11",
  value: "/test",
  list: []
}
const demoMenus = {
  subheader: "subheader",
  list: [{
    menu: "menu",
    icon: "icon",
    list: [item]
  }]
}

class Master extends Component {
  getStyles() {
    return {
      appBar: {
        position: 'fixed',
        top: 0
      },
    };
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

  render() {
    const {showNav, master, fetchMenu} = this.props;
    const {title} = this.state;
    console.log("==================");
    console.log(this.props);
    console.log(this.state);
    console.log("==================");
    const styles = this.getStyles();
    return (
      <div>
        <Title render="Test"/>
        <AppBar
          onLeftIconButtonTouchTap={showNav}
          title={title}
          zDepth={0}
          iconClassNameRight="muidocs-icon-navigation-expand-more"
        />
        <Drawer
          docked={false}
          open={master.navOpen}
          //onRequestChange={(open) => this.setState({open})}
          onRequestChange={showNav}
        >
          <AppMenu menus={item}/>
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


