'use strict';

import React, {Component, PropTypes} from 'react';
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';
import withWidth, {MEDIUM, LARGE} from 'material-ui/utils/withWidth';

class Server extends Component {
  getStyles() {
    return {};
  }


  componentWillMount() {
  }

  componentWillReceiveProps(nextProps, nextContext) {
  }

  componentDidMount() {
    const {fetchServers} = this.props;
    fetchServers({num: 10, page: 1})
  }

  render() {

    const {servers} = this.props;

    return (
      <Table>
        <TableHeader>
          <TableRow>
            <TableHeaderColumn>ID</TableHeaderColumn>
            <TableHeaderColumn>Name</TableHeaderColumn>
            <TableHeaderColumn>Status</TableHeaderColumn>
          </TableRow>
        </TableHeader>
        <TableBody>
          {servers.map((item, i)=>
            <TableRow>
              <TableRowColumn>{item.id}</TableRowColumn>
              <TableRowColumn>{item.name}</TableRowColumn>
              <TableRowColumn>{item.openlevel}</TableRowColumn>
            </TableRow>
          )}
        </TableBody>
      </Table>
    )
  }
}

export default withWidth()(Server);