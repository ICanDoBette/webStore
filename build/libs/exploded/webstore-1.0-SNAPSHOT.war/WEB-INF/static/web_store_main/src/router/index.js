import Vue from 'vue'
import Router from 'vue-router'
import IndexPage from '../pages/index.vue'
import News from '../pages/news.vue'
import Goods from '../pages/goods.vue'
import Select from '../pages/select.vue'
import User from '../pages/user'
import ShopCar from '../pages/shopCar'
import Settlement from '../pages/settlement'
import AlreadyBuy from '../pages/alreadyBuy'

Vue.use(Router)

export default new Router({
  model: 'history',
  routes: [
    {
      path: '/',
      component: IndexPage,
      meta: {keepAlive: true}
    },{
      path: '/news/:id',
      component: News,
      meta: {keepAlive: false}
    },{
      path: '/goods/:id',
      component: Goods,
      meta: {keepAlive: false}
    },{
      path: '/selectPage',
      component: Select,
      meta: {keepAlive: false}
    },{
      path: '/alreadyBuy',
      component: AlreadyBuy,
      meta: {keepAlive: false}
    },{
      path: '/settlement/:val',
      component: Settlement,
      meta: {keepAlive: false}
    },{
      path: '/shopCar',
      component: ShopCar,
      meta: {keepAlive: false}
    },{
      path: '/user',
      component: User,
      meta: {keepAlive: true}
    }
  ]
})
