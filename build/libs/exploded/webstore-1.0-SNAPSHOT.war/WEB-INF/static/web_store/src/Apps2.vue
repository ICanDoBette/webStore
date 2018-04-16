<template>
  <div>
    <p>
      <a v-if="isA">to baidu1</a>
      <a v-else>nobaidu1**</a>
    </p>
    <transition name="my-trans">
      <p v-show="!isA">to baidu2</p>
    </transition>
    <p>
      <button @click="toggle">toggle</button>
    </p>
    <div>
      <button @click="toggleCompenet">Toggle</button>
      <div class="ab">
        <transition name="fade">
          <div :is="currentView">

          </div>
        </transition>
      </div>
    </div>
    <p v-color="'green'">hello world</p>
    <input type="text" v-focus/>
    <router-view></router-view>


    <router-link :to="{path:'apple'}">to apple</router-link>
    <router-link :to="{path:'peer'}">to peer</router-link>
    <router-link :to="{path:'peer/red'}">to red</router-link>
    <router-link :to="{name:'peerPage'}">to peer!!</router-link>
    <router-view name="viewA"></router-view>

    <router-view name="viewB"></router-view>
  </div>

</template>
<script>
  import componentA from './components/A'
  import componentB from './components/B'
  import componentC from './components/C'
  import Vue from 'vue'
  import greenPeer from './components/greenPeer'
  import redPeer from './components/redPeer'

  export default {
    components: {
      componentA,
      componentB,
      componentC,
      greenPeer,
      redPeer,
      viewA:greenPeer,
      viewB:redPeer
    },
    data() {
      return {
        isA: true,
        currentView: 'component-a',
        show: true
      }
    },
    methods: {
      toggle() {
        this.isA = !this.isA
        console.log(this.isA)
      },
      toggleCompenet() {
        if (this.currentView === 'component-a') {
          this.$http.get('http://www.baidu.com').then((response) => {
            debugger;
          })
          this.currentView = 'component-b'
        } else {
          this.currentView = 'component-a'
        }
      }
    },
    computed: {},
    watch: {},
    //自定义指令
    directives: {
      // el指向的元素，binding绑定的值
      color: function (el, binding) {
        el.style.color = binding.value
      },
      focus: {
        inserted(el, binding) {
          el.focus();
        }
      }
    }
  }
</script>
<style>
  html {
    height: 100%;
  }

  body {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
  }

  #app {
    colour: #2c3e50;
    margin-top: -100px;
    max-width: 600px;

    font-family: Source Sans Pro, Helvetica, sans-serif;
    text-align: center;
  }

  #a {
    color: #42b983;
  }

  <!--
  fade 第一种

  -->
  .fade-enter-active, .fade-leave-active {
    transition: opacity 5s ease-out;
  }

  .fade-enter, .fade-leave {
    opacity: 0;
  }

  <!--
  my-trans 第二种

  -->
  .my-trans-enter-active, .my-trans-leave-active {
    transition: all 5s ease-out;
  }

  .my-trans-enter {
    transform: translateY(-500px);
    opacity: 0;
  }

  .my-trans-leave-active {
    transform: translateY(500px);
    opacity: 1;
  }


</style>
