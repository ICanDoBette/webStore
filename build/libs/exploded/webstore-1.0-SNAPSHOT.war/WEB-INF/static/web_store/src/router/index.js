import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import redPeer from '../components/redPeer.vue'
import greenPeer from '../components/greenPeer.vue'
import Apple from '../components/Apple.vue'
import Peer from '../components/Peer.vue'
Vue.use(Router)

export default new Router({
  routes: [
   /* {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }*/
    {
      path: '/apple',
      redirect: '/mygod'
    },{
      path: '/apple/:color',
      component: Apple
    },
    {
      path: '/peer',
      name:'peerPage',
      component: Peer,
      children:[
        {
          path: 'red',
          component: redPeer,
        },
        {
          path: 'green',
          component: greenPeer,
        }
      ]
    }
  ]
})
