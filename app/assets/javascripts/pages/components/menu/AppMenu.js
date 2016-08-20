'use strict';
import React, {PropTypes, Component} from 'react'
import {Link} from 'react-router'
import AppBar from 'material-ui/AppBar';
import AppMenuItem from './AppMenuItem';
import {List, ListItem} from 'material-ui/List';
import ContentSend from 'material-ui/svg-icons/content/send';
import ActionGrade from 'material-ui/svg-icons/action/grade';
import Divider from 'material-ui/Divider';

/** 菜单栏，有几个娱乐菜单是写死的，模块相关菜单将从服务器获取 */
class AppMenu extends Component {
  static propTypes = {
    menus: PropTypes.object.isRequired
  };
  static defaultProps = {
    menus: {}
  };


  render() {
    const {menus} = this.props;
    return (
      <List>
        <AppBar title="Nav"/>
        {menus.list.map((item, i)=> <AppMenuItem param={item} key={i}/>)}

        <Divider/>
        <ListItem
          key={10000}
          primaryText="Surprise"
          leftIcon={<ContentSend />}
          initiallyOpen={true}
          primaryTogglesNestedList={true}
          nestedItems={[
            <ListItem
              key={1}
              primaryText="Game News"
              leftIcon={<ActionGrade />}
              containerElement={<Link to="/gameNews"/>}
            />,
            <ListItem
              key={2}
              primaryText="Game Subscribe"
              leftIcon={<ActionGrade />}
              containerElement={<Link to="/gameSubscribe"/>}
            />,
            <ListItem
              key={3}
              primaryText="Many Cats"
              leftIcon={<ActionGrade />}
              containerElement={<Link to="/manyCats"/>}
            />,
            <ListItem
              key={4}
              primaryText="Test"
              leftIcon={<ActionGrade />}
              containerElement={<Link to="/test"/>}
            />
          ]}
        />

        <ListItem
          primaryText="Description"
          leftIcon={<ContentSend />}
          containerElement={<Link to="/description"/>}
        />
      </List>
    )

  }
}
export default AppMenu;