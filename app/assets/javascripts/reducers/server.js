'use strict';

import * as ServerActions from '../actions/server';

export function receiveServers(state = {}, action) {
  switch (action.type) {
    case ServerActions.RECEIVE_SERVERS:
      return action.json;
    default:
      return state
  }
}


export function createServer(state = {}, action) {
  switch (action.type) {

    case ServerActions.CREATE_SERVER:
      return action.json;
    default:
      return state
  }

}


