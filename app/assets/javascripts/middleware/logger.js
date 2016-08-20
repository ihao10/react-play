/**
 * 只是个例子，没有实际使用：log中间件，记录所有action改变前后state状态
 */
'use strict';
export default function logger({getState}) {
  return next => action => {
    console.group();
    console.log('will dispatch', action);
    const result = next(action);
    console.log('state after dispatch', getState());
    console.groupEnd();
    return result
  }
}
