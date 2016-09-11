'use strict';

// 单元测试模块，__tests__目录下的所有文件必须包含测试代码
// before publishing app, run: npm test --no-cache
// TODO integrate with Jenkins

jest.unmock('../utils/test');

describe('sum', () => {
  it('adds 1 + 2 to equal 3', () => {
    const sum = require('../utils/test');
    expect(sum(1, 2)).toBe(3);
  });
});