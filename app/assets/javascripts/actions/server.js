'use strict';
import * as appFetch from "../utils/appFetch";

const URI_SERVER = '/server';
const URI_SERVER_DETAIL = URI_SERVER + '/detail';

export const RECEIVE_SERVERS = 'RECEIVE_SERVERS';
export const RECEIVE_SERVER_DETAIL = 'RECEIVE_SERVER_DETAIL';
export const CREATE_SERVER = 'CREATE_SERVER';
export const UPDATE_SERVER = 'UPDATE_SERVER';
export const DELETE_SERVER = 'DELETE_SERVER';


function receiveServers(servers) {
  return {
    type: RECEIVE_SERVERS,
    json: servers
  }
}

function receiveServerDetail(detail) {
  return {
    type: RECEIVE_SERVER_DETAIL,
    json: detail
  }
}

function createServer(server) {
  return {
    type: CREATE_SERVER,
    json: server
  }
}

function updateServer() {
  return {
    type: UPDATE_SERVER
  }
}

function deleteServer() {
  return {
    type: DELETE_SERVER
  }
}

export function fetchServers(body) {
  return dispatch => {
    return appFetch.readJson(URI_SERVER, body, json => {
      dispatch(receiveServers(json))
    })
  }
}

export function fetchServerDetail(body) {
  return dispatch => {
    return appFetch.readJson(URI_SERVER_DETAIL, body, json => {
      dispatch(receiveServerDetail(json))
    })
  }
}

export function create(body) {
  return dispatch => {
    return appFetch.create(URI_SERVER, body, response => {
      dispatch(createServer(response))
    })
  }
}

export function update(body) {
  return dispatch => {
    return appFetch.update(URI_SERVER, body, response => {
      dispatch(updateServer())
    })
  }
}

export function destory(body) {
  return dispatch => {
    return appFetch.destroy(URI_SERVER, body, response => {
      dispatch(deleteServer())
    })
  }
}
