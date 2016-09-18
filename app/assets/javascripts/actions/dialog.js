'use strict';
// 弹出框

export const ERROR_DIALOG = "ERROR_DIALOG";
export const NORMAL_DIALOG = "NORMAL_DIALOG";
export const CHECK_DIALOG = "CHECK_DIALOG";

export function errorDialog(memo) {
  return {
    type: ERROR_DIALOG,
    memo: memo
  };
}

export function normalDialog(memo) {
  return {
    type: NORMAL_DIALOG,
    memo: memo
  };
}

export function checkDialog(memo, func) {
  return {
    type: CHECK_DIALOG,
    memo: memo,
    func: func
  };
}

export function showErrorDialog(memo) {
  return dispatch => {
    return dispatch(errorDialog(memo));
  }
}

export function showNormalDialog(memo) {
  return dispatch => {
    return dispatch(normalDialog(memo));
  }
}

export function showCheckDialog(memo, func) {
  return dispatch => {
    return dispatch(checkDialog(memo, func));
  }
}