'use strict';
import React, { Component } from 'react';

const styles = {
  layout: {
    height: '60px',
    position: 'fixed',
    bottom: '0px',
    right: '0px'
  },
  footerText: {
    textAlign: 'right',
    padding: '40px 0',
    fontSize: '10px'
  }

};

export default class Footer extends Component {
  render() {
    return (
      <div style={styles.layout}>
        <div style={styles.footerText}>
          Contribute to the
          <a href='http://www.youzu.com'
             target='_blank'
             style={{textDecoration: 'none'}}> TOPSANGO </a>.
        </div>
      </div>
    );
  }
}
