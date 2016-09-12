'use strict';

import {RECEIVE_SERVERS, RECEIVE_SERVER_DETAIL, CREATE_SERVER, UPDATE_SERVER, DELETE_SERVER} from '../actions/server';

export function receiveServers(state = [], action) {
  switch (action.type) {
    case RECEIVE_SERVERS:
      return action.json;
    default:
      return state
  }
}
