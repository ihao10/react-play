'use strict';

import React, {Component, PropTypes} from "react";
import {
  Table,
  TableBody,
  TableHeader,
  TableFooter,
  TableHeaderColumn,
  TableRow,
  TableRowColumn
} from "material-ui/Table";
import withWidth from "material-ui/utils/withWidth";
import MainBlock from "../components/frame/MainBlock";
import {Tabs, Tab} from "material-ui/Tabs";
import SwipeableViews from "react-swipeable-views";
import Paper from "material-ui/Paper";
import TextField from "material-ui/TextField";

class Server extends Component {


  constructor(props) {
    super(props);
    this.state = {
      slideIndex: 0
    };
  }

  handleSwitch = (value)=> {
    this.setState({
      slideIndex: value
    })
  };

  componentWillMount() {
  }

  componentWillReceiveProps(nextProps, nextContext) {
  }

  componentDidMount() {
    const {fetchServers} = this.props;
    fetchServers({num: 10, page: 1})
  }

  render() {
    const {receiveServers} = this.props;
    var items = [];
    if (receiveServers.items != null) {
      receiveServers.items.map((item, i)=>
        items.push(
          <TableRow>
            <TableRowColumn>{item.id}</TableRowColumn>
            <TableRowColumn>{item.name}</TableRowColumn>
            <TableRowColumn>{item.openlevel}</TableRowColumn>
          </TableRow>
        )
      )
    }

    return (

      <MainBlock title={'Server Manager'}>
        <Paper>
          <Tabs
            onChange={this.handleSwitch}
            value={this.state.slideIndex}
          >
            <Tab label="Server List" value={0}/>
            <Tab label="Server Create" value={1}/>
          </Tabs>
          <SwipeableViews
            index={this.state.slideIndex}
            onChangeIndex={this.handleSwitch}
          >
            <div>
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
                  {items}
                  <TableRow>
                    <TableRowColumn>123</TableRowColumn>
                    <TableRowColumn>qwe</TableRowColumn>
                    <TableRowColumn>asd</TableRowColumn>
                  </TableRow>
                </TableBody>
              </Table>
            </div>
            <div>

              <form>
                <TextField
                  hintText="Server Id"
                  errorText="This field is required"
                /><br/>
                <TextField
                  hintText="Server Id"
                  errorText="This field is required"
                /><br/>
                <TextField
                  hintText="Server Id"
                  errorText="This field is required"
                />

              </form>


            </div>
          </SwipeableViews>
        </Paper>
      </MainBlock>
    );
  }
}

export default withWidth()(Server);