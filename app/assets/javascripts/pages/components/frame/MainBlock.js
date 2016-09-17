'use strict';
import React, {Component, PropTypes} from "react";
import MainBolckTitle from "./MainBolckTitle";
import Paper from "material-ui/Paper";
import spacing from "material-ui/styles/spacing";

const styles = {
  block: {
    margin: spacing.desktopGutterMini,
    paddingBottom: spacing.desktopGutter
  },
  blockTitle: {
    marginTop: spacing.desktopGutterMini
  }
};

class MainBlock extends Component {
  static propTypes = {
    description: PropTypes.string,
    title: PropTypes.string
  };

  state = {
    expand: false
  };

  handleTouchTap = () => {
    this.setState({
      expand: !this.state.expand
    });
  };

  render() {
    let tooltip = 'Show';
    if (this.state.expand) {
      tooltip = 'Hide';
    }
    const {children, title} = this.props;
    return (
      <Paper style={styles.blockTitle} zDepth={0}>
        <div onTouchTap={this.handleTouchTap}>
          <MainBolckTitle title={title} tooltip={tooltip}/>
        </div>
        <div style={styles.block}>
          {children}
        </div>
      </Paper>
    );
  }
}


export default MainBlock;
