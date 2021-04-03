// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
var axios=require('axios')
axios.defaults.baseURL='http://192.168.48.128/k15portals'//linux服务器的路径
Vue.prototype.$axios=axios
Vue.config.productionTip = false
//添加拦截器，拦截请求
axios.interceptors.request.use(config=>{
  if(sessionStorage.getItem('token')){
    config.headers['token']=sessionStorage.getItem('token');
  }
  return config;
});
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
