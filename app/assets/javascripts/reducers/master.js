'use strict';

export default function showNav(state = {navOpen: false}, action) {

  return Object.assign({}, state, {
    navOpen: !state.navOpen
  });

};

// export default function fetchMenu(state, action) {
//
//
// }

