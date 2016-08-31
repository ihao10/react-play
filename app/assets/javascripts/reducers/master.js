'use strict';

export default function showNav(state = {navOpen: false}, action) {

  return {
    ...state,
    navOpen: !state.navOpen
  };
};


