import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import FineCourses from '@/components/FineCourses'
import NewestCourses from '@/components/NewestCourses'
import Login from '@/components/Login'
import TeacherView from '@/components/TeacherView'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name:'index',
      component: Index,
      children:[
        {
          path:'fineCourses',
          component:FineCourses
        },
        {
          path:'newestCourses',
          component:NewestCourses
        }
      ]
    },
    {
      path:'/login',
      component:Login
    },
    {
      path:'/toTeacherView',
      name:'viewid',
      component:TeacherView
    }
  ]
})
