var path = require('path');
var webpack = require('webpack');

module.exports = {
  entry: './app/assets/javascripts',
  output: {
    path: path.join(__dirname, 'public', 'javascripts'),
    filename: 'bundle.js'
  },
  plugins: [
    new webpack.optimize.OccurenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin()
  ],
  module: {
    loaders: [
      {
        test: /\.(js|jsx)?$/,
        loader: 'babel',
        exclude: /node_modules/
      }
    ]
  }
};