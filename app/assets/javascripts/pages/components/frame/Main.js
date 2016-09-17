'use strict';
import React, {PropTypes} from "react";
import Paper from 'material-ui/Paper';
import {Toolbar, ToolbarGroup, ToolbarTitle} from "material-ui/Toolbar";
import IconButton from 'material-ui/IconButton';
import CodeIcon from 'material-ui/svg-icons/action/code';
import {
  Table,
  TableBody,
  TableHeader,
  TableFooter,
  TableHeaderColumn,
  TableRow,
  TableRowColumn
} from "material-ui/Table";

const Main = (props) => (

  <Paper>
    <Toolbar>
      <ToolbarGroup>
        <ToolbarTitle text={props.title || 'Example'}/>
      </ToolbarGroup>
      <ToolbarGroup>
        <IconButton touch={true} tooltip={props.tooltip}>
          <CodeIcon />
        </IconButton>
      </ToolbarGroup>
    </Toolbar>
    <Table
      fixedHeader={true}
    >
      <TableHeader>
        <TableRow>
          <TableHeaderColumn>ID</TableHeaderColumn>
          <TableHeaderColumn>Name</TableHeaderColumn>
          <TableHeaderColumn>Status</TableHeaderColumn>
        </TableRow>
      </TableHeader>
      <TableBody>
        <TableRow>
          <TableRowColumn>123</TableRowColumn>
          <TableRowColumn>qwe</TableRowColumn>
          <TableRowColumn>asd</TableRowColumn>
        </TableRow>
      </TableBody>
    </Table>


  </Paper>
);


export default Main;
