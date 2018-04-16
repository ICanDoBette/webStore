<template>
  <div :title="hello">
    <hr/>
    <p v-for="item in list">
      {{item.name}}
      --
      {{item.price}}
    </p>
    <hr/>
    <div>
      <ul>
        <li v-for="item in list">
          {{item.name}}
          --
          {{item.price}}
        </li>
      </ul>
    </div>
    <hr/>
    <div>
      <ul>
        <li v-for="(item,index) in list"
            v-text="item.name + '-'+ item.price + '-' + index"
            :class="{odd:index % 2 || index == 0}">
          {{item.name}}
          --
          {{item.price}}
        </li>
      </ul>
    </div>
    <hr/>
    <div>
      <li v-for="(value,key ,index) in objList">
        {{key +'--'+ value+'--'+index}}
      </li>
    </div>
    <hr/>
    <p v-text="hello"></p>
    <p v-html="hello"></p>
    <hr/>
    {{ status?'success': num+1 }}
    <hr/>
    <componentA></componentA>
    <component-a id="a" v-for="(value,key) in objList"
                 :key="key"
    ></component-a>
    <hr/>
    <div>
      <ul>
        <li v-for="(item,index) in list"
            v-text="item.name + '-'+ item.price + '-' + index"
            :class="{odd:index % 2 || index == 0}">
          {{item.name}}
          --
          {{item.price}}
        </li>
      </ul>
      <button v-on:click="addItem">{{button1message}}</button>
    </div>
    <hr/>
    <div>
      <ul>
        <li v-for="(item,index) in list"
            v-text="item.name + '-'+ item.price + '-' + index"
            :class="{odd:index % 2 || index == 0}">
          {{item.name}}
          --
          {{item.price}}
        </li>
      </ul>
      <button v-on:click="addItem">{{button1message}}</button>
    </div>
    <hr/>
    <div>
      <componentA :dataA="dataA"></componentA>
      <a :href="address" v-bind:title="address+'!'">百度</a>
      <a class="link-herf" :class="[className,classList]" v-bind:title="address+'!'">百度</a>
      <a :style="linkCss" v-bind:title="address+'!'">百度</a>
    </div>
    <hr/>
    <a v-if="isA">to baidu1</a>
    <a v-else>nobaidu1**</a>
    <a v-show="!isA">to baidu2</a>
    <button @click="toggle">toggle</button>
    <!--
    阻止事件冒泡
    <button @click.stop="toggle">toggle</button>
    -->
    <hr>
    @keydown.enter
    <input @keydown.enter="onKeyDown"/>
    <hr>
    <!-- 判断输入的键代码是不是13 -->
    @keydown.13
    <input @keydown.13="onKeyDown"/>
    <hr>
    <componentB @my-event="onComponentBMyEvent"></componentB>
    <hr>
    <input v-model="myModle" type="text"/>
    {{myModle}}
    <hr>
    <input v-model="myBox" type="checkbox" value="apple"/>
    <input v-model="myBox" type="checkbox" value="banana"/>
    <input v-model="myBox" type="checkbox" value="pinapple"/>
    {{myBox}}
    <hr>
    <input v-model="myRadio" type="radio" value="apple"/>
    <input v-model="myRadio" type="radio" value="banana"/>
    <input v-model="myRadio" type="radio" value="pinapple"/>
    {{myRadio}}
    <hr>
    <select v-model="mySelect">
      <option v-for="(item,index) in mySelectOption" :value="item">
        {{index}}--{{item}}
      </option>
    </select>
    {{mySelect}}
    <hr>
    <select v-model="mySelect2">
      <option v-for="(item,index) in mySelectOption2" :value="item.value">
        {{index}}--{{item.text}}
      </option>
    </select>
    {{mySelect2}}
    <hr>
    <!--
    ???
    <vSelect @onSelect="" :list="mySelectOption2"></vSelect>
    -->
    <hr>
    <!-- 延迟加载，按下回车或者失焦时触发 -->
    lazy
    <input type="text" v-model.lazy="mySelect2"/>
    {{mySelect2}}
    <hr>
    <!-- 将对象转化为数字 -->
    number
    <input type="text" v-model.number="num"/>
    {{num}}--{{typeof num}}
    <hr>
    <!-- 去空格 -->
    trim
    <input type="text" v-model.trim="trim"/>
    {{trim}}
    <hr>
    <!-- 计算属性 -->
    <input type="text" v-model="trim"/>
    {{trimWithoutNumBer}}**
    {{getTrimWithoutNum()}}
    <hr>
    <keep-alive>
      <!-- 缓存数据 -->
      <p :is="componentToRender"></p>
      <button @click="componentToRenderMethod">componentToRender</button>
    </keep-alive>
    <hr>
    <component-c :number-to-do="num" god="trim"></component-c>
    <hr>
    <input type="text" v-model="componentSendMessage"/>
    <component-c :my-value="componentSendMessage" @emit2="componentCEmit">
      <p slot="header">插槽</p>
    </component-c>
  </div>

</template>
<script>
  import componentA from './components/A'
  import componentB from './components/B'
  import componentC from './components/C'
  import Vue from 'vue'

  export default {
    components: {
      componentA,
      componentB,
      componentC
    },
    data() {
      return {
        hello: '<span>world</span>',
        num: 1,
        status: true,
        list: [
          {
            name: 'apple',
            price: 34
          }, {
            name: 'banana',
            price: 56
          }, {
            name: 'peer',
            price: 66
          }
        ],
        objList: {
          name: 'apple',
          price: 34,
          color: 'red',
          weight: 14
        },
        button1message: 'buttonMessage1',
        address: 'http://www.baidu.com',
        dataA: 12,
        classStr: 'red-font',
        className: {
          'red-font': true,
          'blue-font': true
        },
        classList: ['red-font', 'big-font'],
        linkCss: {
          'color': 'red',
          'font-size': '20px'
        },
        isA: true,
        myModle: '',
        myBox: [],
        myRadio: '',
        mySelect: null,
        mySelectOption: ['hello', 'myGod', 'OH! F**K!!'],
        mySelect2: null,
        mySelectOption2: [
          {
            text: 'NO!',
            value: '0....'
          }, {
            text: 'F**K YOU!',
            value: '1....'
          }, {
            text: 'Asou!',
            value: '2....'
          }
        ],
        num: 0,
        trim: '',
        componentToRender: 'component-a',
        componentSendMessage: ''
      }
    },
    methods: {
      addItem: function () {
        this.list.push({
          name: 'pinaapple',
          price: 66
        })
        /**/
        /*
        //这样做不能更新,使用以下的方法更新
        this.list[1]={
          name:'pinaapple',
          price:66
        }
        */
        Vue.set(this.list, 1, {
          name: 'pinaapple',
          price: 66
        })
        console.log('OK!!!!!')
        console.log(this.list)
        this.linkCss = {
          'color': 'blue',
          'font-size': '200px'
        }
      },
      toggle() {
        this.isA = !this.isA
        console.log(this.isA)
      },
      onKeyDown() {
        console.log('onKeyDown!!!!!')
      },
      onComponentBMyEvent(paramFromA) {
        console.log('onComponentBMyEvent!!!!!' + paramFromA)
      },
      getTrimWithoutNum() {
        return this.trim.replace(/\d/g, '') + 'end'
      },
      componentToRenderMethod() {
        if (this.componentToRender === 'component-a') {
          this.componentToRender = 'componentB'
        } else {
          this.componentToRender = 'component-a'
        }
      },
      componentCEmit(a) {
        alert(a)
      }
    },
    computed: {
      // 计算属性
      trimWithoutNumBer() {
        //this.trim=this.trim.replace(/\d/g,'')可以禁止输入数字
        return Date.now();
      }
    },
    watch: {
      // 监听值得变化
      trim(val, oldVal) {
        console.log(val, oldVal)
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
</style>
