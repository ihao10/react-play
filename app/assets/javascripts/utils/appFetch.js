'use strict';
/** 抽象成 RestFul风格的 API */
import fetch from "isomorphic-fetch";

const defaultParams = {
  mode: 'cors',
  credentials: 'include',
  timeout: 10000,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json; charset=utf-8'
  }
};

/**
 * HTTP GET
 * @param  {string} url
 * @param  {object} body
 * @param  {function} func
 * @return {Promise}
 */
export function read(url, body = {}, func = doNothing) {
  return fetch(url, {
    ...defaultParams,
    method: 'get',
    body: JSON.stringify(body)
  }).then(checkStatus)
    .then(response => handleResponse(response))
    .then(response => func(response))
    .catch(error => console.log('request get error', error));
}

/**
 * HTTP GET
 * @param  {string} url
 * @param  {object} body
 * @param  {function} func
 * @return {Promise}
 */
export function readJson(url, body = {}, func = doNothing) {
  return fetch(url, {
    ...defaultParams,
    method: 'get',
    body: JSON.stringify(body)
  }).then(checkStatus)
    .then(response => response.json())
    .then(json => func(json))
    .catch(error => console.log('request get json error', error));
}

/**
 * HTTP POST
 * @param  {string} url
 * @param  {object} body
 * @param  {function} func
 * @return {Promise}
 */
export function create(url, body = {}, func = doNothing) {
  return fetch(url, {
    ...defaultParams,
    method: 'post',
    body: JSON.stringify(body)
  }).then(checkStatus)
    .then(response => handleResponse(response))
    .then(response => func(response))
    .catch(error => console.log('request post error', error));
}

/**
 * HTTP PUT
 * @param  {string} url
 * @param  {object} body
 * @param  {function} func
 * @return {Promise}
 */
export function update(url, body = {}, func = doNothing) {
  return fetch(url, {
    ...defaultParams,
    method: 'put',
    body: JSON.stringify(body)
  }).then(checkStatus)
    .then(response => handleResponse(response))
    .then(response => func(response))
    .catch(error => console.log('request put error', error));
}


/**
 * HTTP DELETE
 * @param  {string} url
 * @param  {object} body
 * @param  {function} func
 * @return {Promise}
 */
export function destroy(url, body = {}, func = doNothing) {
  return fetch(url, {
    ...defaultParams,
    method: 'delete',
    body: JSON.stringify(body)
  }).then(checkStatus)
    .then(response => handleResponse(response))
    .then(response => func(response))
    .catch(error => console.log('request delete error', error));
}


// TODO 根据code跳出不同弹出框
function checkStatus(response) {
  if (response.status >= 200 && response.status < 300) {
    return response;
  } else {
    var err = new Error(response.statusText);
    err.response = response;
    throw err;
  }
}


function handleResponse(response) {
  // TODO 根据response跳出不同弹出框

  return response;
}

function doNothing(json) {
}