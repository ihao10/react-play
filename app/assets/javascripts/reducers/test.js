'use strict';
export default function showNav2(state = {trueOrFalse: false}, action) {
  return {
    trueOrFalse: !state.trueOrFalse,
    ...state
  };
};
