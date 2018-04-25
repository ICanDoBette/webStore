<template>
  <div class="main">
    <!-- 头部开始 -->
    <div style=" width:1280px; height:142px; margin-left:30px;">
      <div style="font-size:medium; height:100px;"><span style="font-size:40px;">已经买到的宝贝</span></div>

      <div class="header" style="width:340px;">
        <center>
          宝贝
        </center>
      </div>
      <div class="header" style="width:80px; ">
        <center>
          数量
        </center>
      </div>
      <div class="header" style="width:160px;">
        <center>
          总价
        </center>
      </div>
      <div class="header" style="width:370px;">
        <center>
          收货地址
        </center>
      </div>
      <div class="header" style="width:160px;">
        <center>
          配送状态
        </center>
      </div>
      <div class="header" style="width:100px; padding-right:20px;">
        <center>
          去评论
        </center>
      </div>
    </div>
    <!-- 头部结束 商品开始 -->
    <div v-for="(item,index) in alreadyBuy" style=" width:1280px;  margin-left:30px;">
      <div class="carTitle"><span>{{item.createTime}}</span><span>订单号: {{item.id}}</span></div>
      <div style=" width:100%;height:90px;">
        <div class="carDetail" style="width:90px;">
          <center>
            <img src="" width="80px" height="80px" style="margin-top:5px;"/>
          </center>
        </div>
        <div class="carDetail" style="width:250px;">
          <center>
           {{item.name}}
          </center>
        </div>
        <div class="carDetail" style="width:80px;">
          <center>
            {{item.counts}}
          </center>
        </div>
        <div class="carDetail" style="width:160px;">
          <center>
            {{item.pay}}
          </center>
        </div>
        <div class="carDetail" style="width:370px;">
          <center>
            {{item.address}}
          </center>
        </div>
        <div class="carDetail" style="width:160px;">
          <center>
            {{item.state}}
          </center>
        </div>
        <div class="carDetail" style="width:100px; padding-right:20px;">
          <center>
            <img @click="commentBuy(item.id)" v-if="item.state=='交易完成'" style="margin-top:25px; cursor:pointer" :src="commentPictuerURL"/>
            <span v-else>收货后可评论</span>
          </center>
        </div>
      </div>
    </div>
    <!-- 商品结束 -->

    <!-- 测试 -->
  </div>
</template>

<script>
  export default {
    created: function () {

    }, data() {
      return {
        commentPictuerURL:require('../assets/comment.png'),
        alreadyBuy: [
          {
            createTime: '2018-09-12',
            id:1,
            picturePath: '',
            name: '暖宝宝',
            counts: 2,
            pay:500,
            address:'内蒙古',
            state:'正在配送',
          },{
            createTime: '2018-09-12',
            id:2,
            picturePath: '',
            name: '暖宝宝',
            counts: 2,
            pay:500,
            address:'内蒙古',
            state:'正在配送',
          },{
            createTime: '2018-10-12',
            id:1,
            picturePath: '',
            name: '暖宝宝',
            counts: 2,
            pay:500,
            address:'内蒙古',
            state:'交易完成',
          },{
            createTime: '2018-09-12',
            id:1,
            picturePath: '',
            name: '暖宝宝',
            counts: 2,
            pay:500,
            address:'内蒙古',
            state:'正在配送',
          }
        ]
      }
    }, methods: {
      commentBuy(val){
        this.$emit('onComment',val)
      }
    },
    watch: {}
  }
</script>

<style scoped>
  .main {
    width: 1347px;
    margin: 15px;
  }

  .header {
    background-color: #7F7F7F;
    float: left;
    padding-top: 10px;
    padding-bottom: 10px;
  }

  .headButton {
    float: right;
    margin-top: 60px;
    margin-right: 49px;
    background: #4FC08D;
    color: #FFFFFF;
    padding: 8px;
    cursor: pointer;
  }

  .carTitle {
    width: 1230px;
    height: 20px;
    background-color: #F1F1F1;
    font-size: small
  }

  .carTitle span {
    margin: 8px;
  }

  .carDetail {
    height: 90px;
    background-color: #B3B3B3;
    font-size: middle;
    float: left;
    line-height: 90px;
  }
</style>
