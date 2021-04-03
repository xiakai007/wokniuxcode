import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/'
// import 'element-ui/lib/theme-chalk/index.css'; // 默认主题


import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'

Vue.use(ElementUI)
Vue.config.productionTip = false;

// Vue.use(ElementUI);

new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
    data: {
        eventHub: new Vue(),
        charts: []
    },
	components: { App }
})
