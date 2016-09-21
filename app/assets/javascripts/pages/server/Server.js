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
import FlatButton from 'material-ui/FlatButton';
import withWidth from "material-ui/utils/withWidth";
import MainBlock from "../components/frame/MainBlock";
import {Tabs, Tab} from "material-ui/Tabs";
import SwipeableViews from "react-swipeable-views";
import Paper from "material-ui/Paper";
import MenuItem from 'material-ui/MenuItem'
import {Field, reduxForm} from 'redux-form';
import RaisedButton from 'material-ui/RaisedButton';
import {APP_STYLES} from "../../utils/appStyles"

import * as ReduxForms from "../components/form/ReduxForm";

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

  state = {
    slideIndex: 0,
    // 是save还是update
    isSave: true
  };

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

  handleSubmit = (formData)=> {
    const {create, update} = this.props;
    if (this.state.isSave == true) {
      create(formData);
    } else {
      update(formData);
    }
  };


  render() {
    const {receiveServers, handleSubmit, pristine, reset, submitting} = this.props;
    var items = [];
    if (receiveServers.items != null) {
      receiveServers.items.map((item, i)=>
        items.push(
          <TableRow key={item.id}>
            <TableRowColumn>{item.id}</TableRowColumn>
            <TableRowColumn>{item.name}</TableRowColumn>
            <TableRowColumn>{item.openLevel}</TableRowColumn>
            <TableRowColumn>{item.worldOpenTime}</TableRowColumn>
            <TableRowColumn> <FlatButton label="Update" primary={true}/> </TableRowColumn>
          </TableRow>
        )
      )
    }
    var submitLabel = this.state.isSave ? "Submit" : "update";
    return (

      <MainBlock title={'Server Manager'}>
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
            <div style={APP_STYLES.appContent}>
              <Table
                fixedHeader={true}
              >
                <TableHeader>
                  <TableRow>
                    <TableHeaderColumn>ID</TableHeaderColumn>
                    <TableHeaderColumn>Name</TableHeaderColumn>
                    <TableHeaderColumn>Status</TableHeaderColumn>
                    <TableHeaderColumn>OpenTime</TableHeaderColumn>
                    <TableHeaderColumn>Operate</TableHeaderColumn>
                  </TableRow>
                </TableHeader>
                <TableBody>
                  {items}
                </TableBody>
              </Table>
            </div>
            <div style={APP_STYLES.appContent}>

              <form onSubmit={handleSubmit(this.handleSubmit)}>

                <div>
                  <Field name="id" type="number" component={ReduxForms.renderTextField} label="Server id"/>
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
                <div>
                  <Field name="passportKey" component={ReduxForms.renderTextField} label="Passport Key"/>
                </div>
                <div>
                  <Field name="flashUrl" component={ReduxForms.renderTextField} label="Flash Url"/>
                </div>
                <div>
                  <Field name="userDataCenterUrl" component={ReduxForms.renderTextField} label="User Data Center Url"/>
                </div>
                <br/>
                <div>
                  <RaisedButton type="Submit" label={submitLabel} primary={true} fullWidth={true}
                                disabled={pristine || submitting}/>
                  <br/>
                  <br/>
                  <RaisedButton type="Submit" label="Synchronize" secondary={true} fullWidth={true}
                                disabled={pristine || submitting}/>
                  <br/>
                  <br/>
                  <RaisedButton label="Reset" fullWidth={true} disabled={pristine || submitting} onClick={reset}/>
                </div>

              </form>

            </div>

          </SwipeableViews>
      </MainBlock>
    );
  }
}

// export default withWidth()(Server);

export default reduxForm({
  form: 'ServerSaveForm',  // a unique identifier for this form
  validate
})(Server)