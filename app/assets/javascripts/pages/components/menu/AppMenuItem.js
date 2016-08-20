'use strict';
import React, { PropTypes, Component } from 'react'
import { Link } from 'react-router'
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

    const { param } = this.props;
    const itemLists = []
    if (param.list != null) {
      param.list.map((subItem, i) => itemLists.push(<ListItem
        primaryText={param.menu}
        key={i}
        leftIcon={<ActionGrade />}
        containerElement={<Link to={subItem.value} />}
      />))
    }
    return (
      <ListItem
        primaryText={param.menu}
        leftIcon={<ContentSend />}
        initiallyOpen={true}
        primaryTogglesNestedList={true}
        nestedItems={
          itemLists
        }
      />
    )
  }
}

export default AppMenuItem;