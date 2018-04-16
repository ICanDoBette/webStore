import Vue from 'vue'
import App from './Apps2'
import router from './router'
import VueRouter from 'vue-router'
//import VueResource from 'vue-resource'
import Apple from './components/Apple.vue'
import Peer from './components/Peer.vue'


Vue.config.productionTip = false

Vue.use(VueRouter);
//Vue.use(VueResource);
/* eslint-disable no-new */
/*new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})*/
//全局组件
{
  let router = new VueRouter({
    mode:'history',
    routes: [
      {
        path: '/apple/:color',
        component: Apple
      },
      {
        path: '/peer',
        component: Peer
      }
    ]
  });
}
/*
Vue.component('my-header',{
    template : '<p>this is my header</p>'
  }
)
*/
/*
var myheaderchild = {
  template: '<p>i am my header child</p>'
}
var myheader = {
  template: '<p>' +
  'this is my header<my-header-child/></p>',
  data:{
    a:123
  },
  components: {
    'my-header-child': myheaderchild
  }
}
new Vue({
  el: '#app',
  //template: "<p>hello vue!!!{{world}}</p>",
  data: function () {
    return {
      world: 'hahaha123'
    }
  },
  //子组件
  components: {
    'my-header': myheader
  }
})
*/





/*
myheader.$data
myheader.$on('hello',function () {

})
*/
new Vue({
  router:router,
  el:'#app',
  components:{
    Apple,
    Peer
  },
  //v2
  //render: h => h(App)
  //v1
  render:function (h) {
    return h(App)
  }
})
