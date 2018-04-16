<template>
  <div id="app">
    <div class="app-head">
      <div class="app-head-inner">
        <img src="../assets/logo.png"/>
        <div class="head-nav">
          <ul v-if="!this.loginModel.isLogin" class="nav-list">
            <li @click="operateLoginWindow">登录</li>
            <li class="nav-pile">|</li>
            <li @click="operateRegistWindow">注册</li>
          </ul>
          <ul v-else class="nav-list">
            <li>你好！{{this.loginModel.name}}</li>
            <li @click="operateLoginWindow">&nbsp;&nbsp;&nbsp;个人中心</li>
            <li class="nav-pile">|</li>
            <li>购物车</li>
            <li class="nav-pile">|</li>
            <li @click="logout">退出登录</li>
          </ul>
        </div>
      </div>
    </div>
    <div class="app-content">
      <keep-alive>
        <router-view v-if="$route.meta.keepAlive" @onOperateChrild="operateChrild" :isLogin="loginModel.isLogin"></router-view>
      </keep-alive>
      <router-view v-if="!$route.meta.keepAlive" @onOperateChrild="operateChrild" :isLogin="loginModel.isLogin"></router-view>
    </div>
    <div class="app-foot">
      <p>© 2016 fishenal MIT</p>
    </div>
    <my-dialog :isShow="isShowLogin" @on-close="operateLoginWindow">
      <div>用户名:<input type="text" v-model="name"/></div>
      <div>密码:<input type="password" v-model="password"/></div>
      <div>
        <div><button @click="login">登录</button></div>
      </div>
      <div v-show="hitLogin">
        <font color="red">
        <span>用户名或密码不正确！</span>
        </font>
      </div>
    </my-dialog>
    <my-dialog :isShow="isShowRegist" @on-close="operateRegistWindow">
      <div>用户名:<input type="text" v-model="registName"/></div>
      <div>密码:<input type="password" v-model="registPassword"/></div>
      <div>请再输一次密码:<input type="password" v-model="registPasswordRe"/></div>
      <div>电话:<input type="text" v-model="registTel"/></div>
      <div>邮箱:<input type="text" v-model="registEmail"/></div>
      <div>
        <div><button @click="regist">注册</button></div>
      </div>
      <div v-show="hitRegist">
        <font color="red">
          <span>{{ registMessage }}</span>
        </font>
      </div>
    </my-dialog>
    <my-dialog :isShow="isShowChrildMsg" @on-close="operateChrild('',false)">
      {{ Msg }}
    </my-dialog>
  </div>
</template>

<script>
  import Dialog from '../components/base/dialog.vue'

  export default {
    created: function () {
      this.$http.post('/checkLogin').then((res) => {
        this.loginModel = res.data
      }, (err) => {
        this.loginModel.id=-1
        this.loginModel.name=''
        this.loginModel.isLogin=false
      })
    },components: {
      MyDialog: Dialog
    },
    data() {
      return {
        name:'',
        password:'',
        registName:'',
        registPassword:'',
        registPasswordRe:'',
        registTel:'',
        registEmail:'',
        registMessage:'',
        isShowLogin: false,
        isShowRegist:false,
        hitLogin: false,
        hitRegist:false,
        loginModel: {
          id: -1,
          name: '',
          isLogin: false
        },
        Msg:'',
        isShowChrildMsg:false
      }
    }, methods: {
      regist(){
        if (this.registName==''||this.registEmail==''||this.registTel==''||this.registPassword==''){
          this.hitRegist=true
          this.registMessage='所有必填项不能为空！'
        }else if (this.registPassword!=this.registPasswordRe){
          this.hitRegist=true
          this.registMessage='两次密码不一致！'
        }else {
          this.$http.post('/regist',{'name':this.registName,'password':this.registPassword,'tel':this.registTel,'email':this.registEmail}).then((res) => {
            if(res.data.isRegist){
              alert('注册成功')
              this.hitRegist=false
              this.loginModel = res.data.loginModel
              this.operateRegistWindow()
            }else{
              this.hitRegist=true
              this.registMessage=res.data.registMessage
              this.loginModel.id=-1
              this.loginModel.name=''
              this.loginModel.isLogin=false
            }
          }, (err) => {
            this.hitRegist=true
            this.loginModel.id=-1
            this.loginModel.name=''
            this.loginModel.isLogin=false
          })
        }

      },
      login(){
        this.$http.post('/login',{'name':this.name,'password':this.password}).then((res) => {
          if(res.data.isLogin){
          this.hitLogin=false
          this.loginModel = res.data
          this.operateLoginWindow()
        }else{
          this.hitLogin=true
          this.loginModel.id=-1
          this.loginModel.name=''
          this.loginModel.isLogin=false
          console.log(this.hitLogin)
        }
      }, (err) => {
          this.hitLogin=true
          this.loginModel.id=-1
          this.loginModel.name=''
          this.loginModel.isLogin=false
        })
      },
      operateLoginWindow() {
        this.isShowLogin = !this.isShowLogin
      },
      operateRegistWindow() {
        this.isShowRegist = !this.isShowRegist
      },
      logout(){
        this.$http.post('/logout').then((res) => {
          console.log(res.data.OK)
          if(res.data.OK){
            this.loginModel.id=-1
            this.loginModel.name=''
            this.loginModel.isLogin=false
            this.name=''
            this.password=''
          }
        }, (err) => {
        })
      },operateChrild(val,isOpen){
        if (isOpen){
          this.Msg=val
          this.isShowChrildMsg=true
        }else{
          this.Msg=''
          this.isShowChrildMsg=false
        }
      }
    }
  }
</script>

<style>
  /* http://meyerweb.com/eric/tools/css/reset/
     v2.0 | 20110126
     License: none (public domain)
  */

  html, body, div, span, applet, object, iframe,
  h1, h2, h3, h4, h5, h6, p, blockquote, pre,
  a, abbr, acronym, address, big, cite, code,
  del, dfn, em, img, ins, kbd, q, s, samp,
  small, strike, strong, sub, sup, tt, var,
  b, u, i, center,
  dl, dt, dd, ol, ul, li,
  fieldset, form, label, legend,
  table, caption, tbody, tfoot, thead, tr, th, td,
  article, aside, canvas, details, embed,
  figure, figcaption, footer, header, hgroup,
  menu, nav, output, ruby, section, summary,
  time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
  }

  /* HTML5 display-role reset for older browsers */
  article, aside, details, figcaption, figure,
  footer, header, hgroup, menu, nav, section {
    display: block;
  }

  body {
    line-height: 1;
  }

  ol, ul {
    list-style: none;
  }

  blockquote, q {
    quotes: none;
  }

  blockquote:before, blockquote:after,
  q:before, q:after {
    content: '';
    content: none;
  }

  table {
    border-collapse: collapse;
    border-spacing: 0;
  }

  a {
    color: inherit;
    text-decoration: none;
  }

  body {
    background: #f0f2f5;
    font-family: "Helvetica Neue", Helvetica, Arial, "Hiragino Sans GB", "Hiragino Sans GB W3", "Microsoft YaHei UI", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif;
    font-size: 14px;
    color: #444;
  }

  .app-head {
    background: #363636;
    color: #b2b2b2;
    height: 90px;
    line-height: 90px;
    width: 100%;
  }

  .app-head-inner {
    width: 1200px;
    margin: 0 auto;
  }

  .head-logo {
    float: left;
  }

  .app-head-inner img {
    width: 50px;
    margin-top: 20px;
  }

  .head-nav {
    float: right;
  }

  .head-nav ul {
    overflow: hidden;
  }

  .head-nav li {
    cursor: pointer;
    float: left;
  }

  .nav-pile {
    padding: 0 10px;
  }

  .app-foot {
    text-align: center;
    height: 80px;
    width: 100%;
    line-height: 80px;
    background: #e3e4e8;
    clear: both;
    margin-top: 30px;
  }

  .container {
    width: 1200px;
    margin: 0 auto;
  }

  .hr {
    height: 1px;
    width: 100%;
    background: #ddd;
  }

  .button {
    background: #4fc08d;
    color: #fff;
    display: inline-block;
    padding: 10px 20px;
    cursor: pointer;
  }

  .button-cant {
    background: rgba(191, 191, 191, 0.93);
    color: #e8000a;
    display: inline-block;
    padding: 10px 20px;
    cursor: not-allowed;
  }

  .button:hover {
    background: #4fc08d;
  }

  .g-form {

  }

  .g-form-line {
    padding: 15px 0;
  }

  .g-form-label {
    width: 100px;
    font-size: 16px;
    display: inline-block;
  }

  .g-form-input {
    display: inline-block;
  }

  .g-form-input input {
    height: 30px;
    width: 200px;
    line-height: 30px;
    vertical-align: middle;
    padding: 0 10px;
    border: 1px solid #ccc;
  }

  .g-form-btn {
    padding-left: 100px;
  }

  .g-form-error {
    color: red;
    padding-left: 15px;
  }
</style>
