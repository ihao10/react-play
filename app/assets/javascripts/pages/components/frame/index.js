'use strict';
import React, {Component, PropTypes} from "react";
import MainBlock from "./MainBlock";

class Main extends Component {
  static propTypes = {};


  render() {
    const {
      children
    } = this.props;


    // const styles = {
    //   root: {
    //     backgroundColor: canvasColor,
    //     marginBottom: 32
    //   },
    //   // exampleBlock: {
    //   //   borderRadius: '0 0 2px 0',
    //   //   padding: '14px 24px 24px',
    //   //   margin: 0,
    //   //   width: layoutSideBySide ? '45%' : null,
    //   //   float: layoutSideBySide ? 'right' : null,
    //   // },
    // };


    return (
      <MainBlock
        title={this.props.title}
      >
        sajdfiasjdiofjiosajdifj
        sadifjsidf
        sadjfisojdf
      </MainBlock>
    );
  }
}

export default Main;
