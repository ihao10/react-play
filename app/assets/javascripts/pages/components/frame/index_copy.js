'use strict';
import React, {Component, PropTypes} from 'react';
import CodeBlock from './CodeBlock';
import ClearFix from 'material-ui/internal/ClearFix';
import Paper from 'material-ui/Paper';

class CodeExample extends Component {
  static propTypes = {
    children: PropTypes.node,
    code: PropTypes.string.isRequired,
    component: PropTypes.bool,
    description: PropTypes.string,
    exampleBlockStyle: React.PropTypes.object,
    layoutSideBySide: PropTypes.bool,
    title: PropTypes.string,
  };

  static defaultProps = {
    component: true,
  };

  static contextTypes = {
    muiTheme: PropTypes.object,
  };

  render() {
    const {
      children,
      code,
      component,
      exampleBlockStyle,
      layoutSideBySide,
    } = this.props;

    const palette = this.context.muiTheme.rawTheme.palette;
    const canvasColor = palette.canvasColor;

    const styles = {
      root: {
        backgroundColor: canvasColor,
        marginBottom: 32,
      },
      exampleBlock: {
        borderRadius: '0 0 2px 0',
        padding: '14px 24px 24px',
        margin: 0,
        width: layoutSideBySide ? '45%' : null,
        float: layoutSideBySide ? 'right' : null,
      },
    };


    return (
      <Paper style={styles.root}>
        <CodeBlock
          title={this.props.title}
          description={this.props.description}
        >
          {code}
        </CodeBlock>
        <ClearFix style={Object.assign(styles.exampleBlock, exampleBlockStyle)}>{children}</ClearFix>
      </Paper>
    );
  }
}

export default CodeExample;


/** WEBPACK FOOTER **
 ** ./src/app/components/CodeExample/index.js
 **/