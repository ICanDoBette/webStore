<template>
  <div id="app">
    <div class="app-head">
      <div class="app-head-inner">
        <img src="../assets/logo.png" style="cursor: pointer;" @click="routeToIndex"/>
        <div class="head-nav">
          <ul v-if="!this.loginModel.isLogin" class="nav-list">
            <li @click="routeToIndex">回到首页</li>
            <li class="nav-pile">|</li>
            <li @click="operateLoginWindow">登录</li>
            <li class="nav-pile">|</li>
            <li @click="operateRegistWindow">注册</li>
          </ul>
          <ul v-else class="nav-list">
            <li>你好！{{this.loginModel.name}}</li>
            <li @click="rountToUser">&nbsp;&nbsp;&nbsp;个人中心</li>
            <li class="nav-pile">|</li>
            <li @click="rountToShopCar">购物车</li>
            <li class="nav-pile">|</li>
            <li @click="rountToAlreadyBuy">已买到的宝贝</li>
            <li class="nav-pile">|</li>
            <li @click="routeToIndex">回到首页</li>
            <li class="nav-pile">|</li>
            <li @click="logout">退出登录</li>
          </ul>
        </div>
      </div>
    </div>
    <div class="app-content">
      <keep-alive>
        <router-view ref="chrildComponenet" v-if="$route.meta.keepAlive" @onOperateUserName="operateUserName" @onOperateChrild="operateChrild" @onOperateAddress="operateAddress" :isLogin="loginModel.isLogin"></router-view>
      </keep-alive>
      <router-view ref="chrildComponenet" v-if="!$route.meta.keepAlive" @onComment="operateComment" @onOperateChrild="operateChrild" :isLogin="loginModel.isLogin"></router-view>
    </div>
    <div class="app-foot">
      <p>© 2016 fishenal MIT</p>
    </div>
    <my-dialog :isShow="isShowLogin" @on-close="operateLoginWindow">
      <div style="margin: 8px;font-size: 25px;">用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="name"/></div>
      <div style="margin: 8px;font-size: 25px;">密码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" v-model="password"/></div>
      <div>
        <div><span class="buttonStyle" @click="login">登录</span></div>
      </div>
      <div v-show="hitLogin">
        <font color="red">
        <span>用户名或密码不正确！</span>
        </font>
      </div>
    </my-dialog>
    <my-dialog :isShow="isShowRegist" @on-close="operateRegistWindow">
      <div style="margin: 8px;font-size: 25px;">用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="registName"/></div>
      <div style="margin: 8px;font-size: 25px;">密码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" v-model="registPassword"/></div>
      <div style="margin: 8px;font-size: 25px;">请再输一次密码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" v-model="registPasswordRe"/></div>
      <div style="margin: 8px;font-size: 25px;">电话:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="registTel"/></div>
      <div style="margin: 8px;font-size: 25px;">邮箱:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="registEmail"/></div>
      <div>
        <div><span  class="buttonStyle" @click="regist">注册</span></div>
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
    <my-dialog :isShow="isShowAddress" @on-close="operateAddressWindow">
      <div style="margin: 8px;font-size: 25px;">收货地址:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="addreess"/></div>
      <div style="margin: 8px;font-size: 25px;">收货电话:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="addressTel"/></div>
      <div style="margin: 8px;font-size: 25px;">收货人:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="addressName"/></div>
      <div>
        <div><span @click="addAddress" class="buttonStyle">增加</span></div>
      </div>
      <div v-show="hitAddress">
        <font color="red">
          <span>{{ addressMessage }}</span>
        </font>
      </div>
    </my-dialog>
    <my-dialog :isShow="isShowComment" @on-close="operateCommentWindow">
      <star @onChange="changeCommentStar"></star>
      <div>{{commentStarStr}}</div>
      <div>请输入您的评价:<input type="text" v-model="commentStr"/></div>
      <div><span @click="addComment" class="buttonStyle">提交</span> </div>
      <div v-show="hitComment">
        <font color="red">
          <span>{{ commentMessage }}</span>
        </font>
      </div>
    </my-dialog>
  </div>
</template>

<script>
  import Dialog from '../components/base/dialog.vue'
  import Star from '../components/base/star'
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
      MyDialog: Dialog,
      Star:Star
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
        isShowChrildMsg:false,
        isShowAddress:false,
        addreess:'',
        addressTel:null,
        addressName:'',
        hitAddress:false,
        addressMessage:'',
        isShowComment:false,
        commentStar:-1,
        commentStr:'',
        commentMessage:'',
        hitComment:false,
        commentId:-1,
      }
    },
    computed: {
      // 计算属性
      commentStarStr() {
        if (this.commentStar==-1){
          return ''
        } else {
          return '您的评分:'+this.commentStar+'分'
        }
      }
    },
    methods: {
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
          if(res.data.OK){
            this.loginModel.id=-1
            this.loginModel.name=''
            this.loginModel.isLogin=false
            this.name=''
            this.password=''
            this.$router.push({path: '/'})
          }
        }, (err) => {
          console.log(err)
        })
      },operateChrild(val,isOpen){
        if (isOpen){
          this.Msg=val
          this.isShowChrildMsg=true
        }else{
          this.Msg=''
          this.isShowChrildMsg=false
        }
      },operateAddressWindow(){
        this.isShowAddress=false
        this.hitAddress=false
      },operateAddress(){
        this.isShowAddress=true
        this.hitAddress=false
      },addAddress(){
        if (this.addreess==''){
          this.hitAddress=true
          this.addressMessage='请输入收货地址'
          return
        }
        if(this.addressTel==0){
          this.hitAddress=true
          this.addressMessage='请输入收货电话'
          return
        }
        if(this.addressName==''){
          this.hitAddress=true
          this.addressMessage='请输入收货人姓名'
          return
        }
        this.$http.post('/user/addAddress',{'addreess':this.addreess,'addressTel':this.addressTel,'name':this.addressName}).then((res) => {
          if(res.data.msg=='ok'){
          this.$refs.chrildComponenet.getAddress()
          this.operateAddressWindow()
        }else{
          this.hitAddress=true
          this.addressMessage=res.data.msg
        }
      }, (err) => {
          this.hitAddress=true
          this.addressMessage=err
        })
      },operateComment(buyId){
        this.commentId=buyId
        this.isShowComment=true
        this.hitComment=false
      },operateCommentWindow(){
        this.commentId=-1
        this.hitComment=false
        this.isShowComment=false
      },addComment(){
        if (this.commentStar==-1){
          this.hitComment=true
          this.commentMessage='请输入星级'
          return
        }
        if(this.commentStr==''){
          this.hitComment=true
          this.commentMessage='请输入评价'
          return
        }
        this.$http.post('/afterSale/addComment',{'buyId':this.commentId,'commentStar':this.commentStar,'commentStr':this.commentStr}).then((res) => {
          if(res.data.msg=='ok'){
          alert('评价成功！')
          this.operateCommentWindow()
        }else{
          this.hitComment=true
          this.commentMessage=res.data.msg
        }}, (err) => {
          this.hitComment=true
          this.commentMessage=err
        })
      },changeCommentStar(val){
        this.commentStar=val
      },rountToShopCar(){
        this.$router.push({path: '/shopCar'})
      },rountToAlreadyBuy(){
        this.$router.push({path: '/alreadyBuy'})
      },rountToUser(){
        this.$router.push({path: '/user'})
      },operateUserName(val){
        this.loginModel.name=val
        this.name=val
      },routeToIndex(){
        this.$router.push({path: '/'})
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
    width: 1349px;
  }

  .app-head-inner {
    width: 1349px;
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
    width: 1349px;
    line-height: 80px;
    background: #e3e4e8;
    clear: both;
    margin-top: 30px;
  }

  .container {
    width: 1349px;
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

  .buttonStyle{
    background: #4FC08D;
    color: #FFFFFF;
    padding: 5px;
    cursor: pointer;
    font-size:20px;
    margin-right:30px;
    margin-left: 20px;
  }
</style>
