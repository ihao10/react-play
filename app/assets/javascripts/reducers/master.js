'use strict';

export default function showNav(state={navOpen:false}, action) {
  return {
    navOpen: !state.navOpen,
    ...state
  };
};


