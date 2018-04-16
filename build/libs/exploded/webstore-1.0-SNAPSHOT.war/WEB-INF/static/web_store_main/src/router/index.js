import Vue from 'vue'
import Router from 'vue-router'
import IndexPage from '../pages/index.vue'
import DetailPage from '../pages/detail.vue'
import DetailAnalysisPage from '../pages/detail/analysis.vue'
import DetailCountPage from '../pages/detail/count.vue'
import DetailForecastPage from '../pages/detail/forecast.vue'
import DetailPublishPage from '../pages/detail/publish.vue'
import News from '../pages/news.vue'
import Goods from '../pages/goods.vue'
Vue.use(Router)

export default new Router({
  model: 'history',
  routes: [
    {
      path: '/',
      component: IndexPage,
      meta: {keepAlive: true}
    },{
      path: '/detail',
      component: DetailPage,
      meta: {keepAlive: true},
      children:[
        {
          path:'forecast',
          component:DetailForecastPage,
          meta: {keepAlive: true}
        },{
          path:'count',
          component:DetailCountPage,
          meta: {keepAlive: true}
        },{
          path:'analysis',
          component:DetailAnalysisPage,
          meta: {keepAlive: true}
        },{
          path:'publish',
          component:DetailPublishPage,
          meta: {keepAlive: true}
        }
      ]
    },{
      path: '/news/:id',
      component: News,
      meta: {keepAlive: false}
    },{
      path: '/goods/:id',
      component: Goods,
      meta: {keepAlive: true}
    }
  ]
})
