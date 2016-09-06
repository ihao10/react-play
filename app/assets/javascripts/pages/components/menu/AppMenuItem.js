'use strict';
import React, {PropTypes, Component} from 'react'
import {Link} from 'react-router'
import ListItem from 'material-ui/List/ListItem';
import ContentSend from 'material-ui/svg-icons/content/send';
import ActionGrade from 'material-ui/svg-icons/action/grade';

export class AppMenuItem extends Component {
  static propTypes = {
    param: PropTypes.object.isRequired
  };

  static defaultProps = {
    item: {}
  };

  render() {

    const {param} = this.props;
    const itemLists = combineMenu(param.list);
    return (
      <ListItem
        primaryText={param.menu}
        initiallyOpen={true}
        primaryTogglesNestedList={true}
        nestedItems={
          itemLists
        }
      />
    )
  }
}

function combineMenu(list = []) {
  const itemLists = [];
  if (list == null) {
    return itemLists;
  }
  list.map((subItem, i) => itemLists.push(<ListItem
    primaryText={subItem.menu}
    key={i}
    containerElement={<Link to={subItem.value}/>}
    nestedItems={
      combineMenu(subItem.list)
    }
  />));
  return itemLists;
}

export default AppMenuItem;