# react-play
Learn react and play!

# Play-Reactjs-ES6-ES7-Material-UI-MongoDB
This is a application with [Play Framework 2](https://playframework.com/), [React.js](https://facebook.github.io/react/) and ES6 (ECMAScript 6, a.k.a. ES2015), ES7,
[Redux](http://redux.js.org/), [Webpack](http://webpack.github.io/), [Babel](https://babeljs.io/),
[MongoDB](https://www.mongodb.com/), [Morphia](https://github.com/mongodb/morphia)

## Prerequisite :
#### INSTALL
* Install Node.js,npm (then install webpack)
* Install MongoDB
* Optional: install activator or sbt

#### JS
* Tool: Webpack
* Js frame: React, Redux, React-router, Babel(Parse ES6,ES7 to ES5)
* Css frame: Material-UI (An implementation of Material Design in React)


* Use terminal
* ```cd gm```
* Install npm dependencies(which was depended on `package.json`) with ```npm install``` (then folder `node_modules` will be created, don't commit `node_modules`)
* ```npm install``` will run `webpack` automatically (this was written in `package.json`). So just run ```npm install```
* `public/javascripts/bundle.js` will be created automatically (don't commit it too).
* Optional: you can install a plugin for Chrome: `React Developer Tools` (React debugging tools)

#### JAVA

If you use gradle to build play framework:
* Gradle refresh
* Use terminal
* Run with ```gradle run```
* Hot run with ```gradle -t run```

If you use sbt to build play framework:
* Sbt refresh (It will be failed, because our network is a shit)
* Or ```sbt clean``` & ```sbt compile``` & ```sbt run```
* Or just Run Play 2 App in Intellij

#### DATABASE
* Install MongoDB (It's so hot, Let's try it)
* Windows 7: use cmd
* ```your\MongoDB\bin\mongod.exe --dbpath your\data```
* Client: ```mongo.exe```

#### Intellij IDEA Plugins
* required: Scala, .ignore, Docker integration, LiveEdit, Markdown support, Bash support, SBT, Karma
* optional: FindBugs-IDEA, Mongo Plugin, PlantUML integration, Remote call

## Usage :
* Install npm dependencies with ```npm install```
* Build bundle dev with ```webpack --grogress --color```
* Hot build bundle dev with ```webpack --grogress --color --watch```
* Build bundle prod with ```webpack -p``` (`bundle.js` will be compressed)


## FUTURE :
* APP on IOS, Android
* [Reactive Native](https://facebook.github.io/react-native/)

## 内网配置：
* npm config set registry https://registry.npm.taobao.org
* // 配置后可通过下面方式来验证是否成功 npm config get registry