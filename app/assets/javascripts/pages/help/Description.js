import React from "react";
import Paper from "material-ui/Paper";

// 说明书，之后修改
const style = {
  height: 100,
  width: 100,
  margin: 20,
  textAlign: 'center',
  display: 'inline-block',
};

const Description = () => (
  <div>
    <Paper style={style} zDepth={0}/>
    <Paper style={style} zDepth={1}/>
    <Paper style={style} zDepth={2}/>
    <Paper style={style} zDepth={3}/>
    <Paper style={style} zDepth={4}/>
    <Paper style={style} zDepth={5}/>
  </div>
);

export default Description;