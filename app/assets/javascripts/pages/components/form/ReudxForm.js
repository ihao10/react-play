'use strict';

// Redux Form 需要调用的表单组件

import React from 'react';
import TextField from 'material-ui/TextField';
import { RadioButton, RadioButtonGroup } from 'material-ui/RadioButton'
import Checkbox from 'material-ui/Checkbox'
import SelectField from 'material-ui/SelectField'

export const renderTextField = ({input, label, meta: {touched, error}, ...custom}) => (
  <TextField
    hintText={label}
    floatingLabelText={label}
    errorText={touched && error}
    {...input}
    {...custom}
    style ={{width: '100%'}}
  />
);

export const renderCheckbox = ({input, label}) => (
  <Checkbox
    label={label}
    checked={input.value ? true : false}
    onCheck={input.onChange}/>
);

export const renderRadioGroup = ({input, ...rest}) => (
  <RadioButtonGroup
    {...input} {...rest}
    valueSelected={input.value}
    onChange={(event, value) => input.onChange(value)}/>
);

export const renderSelectField = ({input, label, meta: {touched, error}, children}) => (
  <SelectField
    floatingLabelText={label}
    errorText={touched && error}
    {...input}
    onChange={(event, index, value) => input.onChange(value)}
    children={children}/>
);

