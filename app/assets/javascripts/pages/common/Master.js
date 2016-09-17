'use strict';
import React, {Component, PropTypes} from "react";
import getMuiTheme from "material-ui/styles/getMuiTheme";
import AppBar from "material-ui/AppBar";
import Drawer from "material-ui/Drawer";
import {Link} from "react-router";
import {List, ListItem} from "material-ui/List";
import AppMenu from "../components/menu/AppMenu";
import withWidth from "material-ui/utils/withWidth";
import IconButton from "material-ui/IconButton";
import IconMenu from "material-ui/IconMenu";
import MenuItem from "material-ui/MenuItem";
import MoreVertIcon from "material-ui/svg-icons/navigation/more-vert";
import spacing from "material-ui/styles/spacing";
import Paper from "material-ui/Paper";
import Title from 'react-title-component';


class Master extends Component {
  getStyles() {
    return {
      appBar: {
        position: 'fixed',
        // Needed to overlap the examples
        zIndex: this.state.muiTheme.zIndex.appBar + 1,
        top: 0
      },
      root: {
        paddingTop: spacing.desktopGutterLess
      },
      content: {
        margin: spacing.desktopGutter
      }
    };
  }

  handleChangeMuiTheme = (muiTheme) => {
    this.setState({
      muiTheme: muiTheme
    });
  };

  getChildContext() {
    return {
      muiTheme: this.state.muiTheme
    };
  }

  componentWillMount() {
    this.setState({
      muiTheme: getMuiTheme()
    });
  }

  componentWillReceiveProps(nextProps, nextContext) {
    const newMuiTheme = nextContext.muiTheme ? nextContext.muiTheme : this.state.muiTheme;
    this.setState({
      muiTheme: newMuiTheme
    });
  }

  componentDidMount() {
    const {fetchMenus} = this.props;
    fetchMenus()
  }

  render() {
    const styles = this.getStyles();
    const {children, changeNav, closeNav, navOpen, menus} = this.props;
    const {title} = this.state;
    console.log(this.props);
    return (
      <div>
        <AppBar
          onLeftIconButtonTouchTap={changeNav}
          title="Thirty-Six Stratagems"
          zDepth={0}
          iconElementRight={
            <IconMenu
              iconButtonElement={
                <IconButton><MoreVertIcon /></IconButton>
              }
              targetOrigin={{horizontal: 'right', vertical: 'top'}}
              anchorOrigin={{horizontal: 'right', vertical: 'top'}}
            >
              <MenuItem primaryText="Refresh"/>
              <MenuItem primaryText="Sign out"/>
            </IconMenu>
          }
        />

        <Paper zDepth={0}>
          {React.cloneElement(children)}
        </Paper>

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
              zDepth={1}
            />
            <ListItem
              primaryText="Welcome"
              containerElement={<Link to="/"/>}
            />
            <AppMenu menus={menus}/>
          </List>
        </Drawer>
      </div>
    )
  }
}

Master.childContextTypes = {
  muiTheme: React.PropTypes.object,
  navOpen: React.PropTypes.bool,
  showNav: React.PropTypes.func,
  changeNav: React.PropTypes.func,
  menus: React.PropTypes.object
};

export default withWidth()(Master);


