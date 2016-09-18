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
import MenuItem from 'material-ui/MenuItem'
import {Field, reduxForm} from 'redux-form';

import * as ReduxForms from "../components/form/ReudxForm";

const validate = values => {
  const errors = {};
  const requiredFields = ['id', 'openLevel', 'name', 'worldOpenTime'];
  requiredFields.forEach(field => {
    if (!values[field]) {
      errors[field] = 'Required'
    }
  });
  return errors
};

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
    const {receiveServers, handleSubmit, pristine, reset, submitting} = this.props;
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
                    <TableHeaderColumn>OpenTime</TableHeaderColumn>
                  </TableRow>
                </TableHeader>
                <TableBody>
                  {items}
                  <TableRow>
                    <TableRowColumn>demo</TableRowColumn>
                    <TableRowColumn>demo</TableRowColumn>
                    <TableRowColumn>demo</TableRowColumn>
                    <TableRowColumn>demo</TableRowColumn>
                  </TableRow>
                </TableBody>
              </Table>
            </div>
            <div>

              <form onSubmit={handleSubmit}>

                <div>
                  <Field name="id" component={ReduxForms.renderTextField} label="Server id"/>
                </div>

                <div>
                  <Field name="name" component={ReduxForms.renderTextField} label="Server name"/>
                </div>

                <div>
                  <Field name="openLevel" component={ReduxForms.renderSelectField} label="Open Status">
                    <MenuItem value={'ALL'} primaryText="ALL"/>
                    <MenuItem value={'TEST'} primaryText="TEST"/>
                  </Field>
                </div>

                <div>
                  <Field name="worldOpenTime" component={ReduxForms.renderTextField} label="Open Time"/>
                </div>
                <br/>
                <div>
                  <button type="submit" disabled={pristine || submitting}>Submit</button>
                  <button type="button" disabled={pristine || submitting} onClick={reset}>Clear Values
                  </button>
                </div>

              </form>

            </div>
          </SwipeableViews>
        </Paper>
      </MainBlock>
    );
  }
}

// export default withWidth()(Server);

export default reduxForm({
  form: 'ServerSaveForm',  // a unique identifier for this form
  validate
})(Server)