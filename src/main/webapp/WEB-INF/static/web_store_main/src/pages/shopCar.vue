<template>

  <div class="main">
    <!-- 头部开始 -->
    <div style=" width:1280px; height:142px; margin-left:30px;">
      <div style="font-size:medium; height:100px;">
        <span style="font-size:40px;margin-left: 150px;">我的购物车</span>
        <span @click="goToBuy" class="headButton">结算选中商品</span>
        <span @click="resetCar" class="headButton">清空购物车</span>
      </div>
      <div class="header" style="width:40px; margin-left: 150px;">
        <center>
          &nbsp;
        </center>
      </div>
      <div class="header" style="width:380px;">
        <center>
          宝贝
        </center>
      </div>
      <div class="header" style="width:150px; ">
        <center>
          单价
        </center>
      </div>
      <div class="header" style="width:160px;">
        <center>
          数量
        </center>
      </div>
      <div class="header" style="width:200px;">
        <center>
          需付款
        </center>
      </div>
      <div class="header" style="width:60px; padding-right:20px;">
        <center>
          去结算
        </center>
      </div>
    </div>
    <!-- 头部结束 商品开始 -->
    <div v-for="(item,index) in shopCars" style=" width:1280px;  margin-left:30px; margin-left: 180px;">
      <div class="carTitle"><span>2018-03-12</span><span>购物车编号: {{index}}</span></div>
      <div style=" width:100%;height:90px;">
        <div class="carDetail" style="width:40px;">
          <center>
            <input v-model="buyItem" style="margin-top:40px;" type="checkbox" :value="item.id"/>
          </center>
        </div>
        <div class="carDetail" style="width:90px;">
          <center>
            <img :src="item.picturePath" width="80px" height="80px" style="margin-top:5px;"/>
          </center>
        </div>
        <div class="carDetail" style="width:290px;">
          <center>
            {{item.name}}
          </center>
        </div>
        <div class="carDetail" style="width:150px;">
          <center>
            {{item.price}}
          </center>
        </div>
        <div class="carDetail" style="width:160px;">
          <center>
            <counter class="counter" style="margin-left:8px;width:140px;  margin-top:27px;" :max="item.allCount" :min="0"
                     :defaultNumber="item.counts" :defaultId="index" ref="shopCar_counter"
                     @onChangeNum="changeCount"
            ></counter>
          </center>
        </div>

        <div class="carDetail" style="width:200px;">
          <center>
            {{item.counts*item.price}}
          </center>
        </div>
        <div class="carDetail" style="width:60px; padding-right:20px;">
          <center>
            <img @click="goToBuyOne(item.id)" style="margin-top:25px; cursor:pointer" src="../assets/buy.png"/>
          </center>
        </div>
      </div>
    </div>
    <!-- 商品结束 -->

    <!-- 测试 -->
  </div>
</template>

<script>
  import counter from '../components/base/counter'

  export default {
    components: {counter},
    created: function () {
      this.$http.post('/user/getShopCar').then((res) => {
        this.shopCars=res.data
    }, (err) => {
        console.log(err)
      })
    }, data() {
      return {
        buyPicUrl: require('../assets/buy.png'),
        shopCars: [
          {
            id: 1,
            picturePath: '',
            name: '暖宝宝',
            price: 36,
            counts: 2,
            updateTime: '2018-09-12',
            allCount: 5
          }, {
            id: 2,
            picturePath: '',
            name: '暖宝宝',
            price: 36,
            counts: 2,
            updateTime: '2018-09-12',
            allCount: 5
          }, {
            id: 3,
            picturePath: '',
            name: '暖宝宝',
            price: 36,
            counts: 2,
            updateTime: '2018-09-12',
            allCount: 5
          }, {
            id: 4,
            picturePath: '',
            name: '暖宝宝',
            price: 36,
            counts: 2,
            updateTime: '2018-09-12',
            allCount: 5
          }, {
            id: 5,
            picturePath: '',
            name: '暖宝宝',
            price: 36,
            counts: 2,
            updateTime: '2018-09-12',
            allCount: 5
          }
        ],
        buyItem: []
      }
    }, methods: {
      changeCount(changeCountNum, index) {
       this.$http.post('/test',{'id':this.shopCars[index].id,'buyNum':changeCountNum}).then((res) => {
         if(res.data.msg!='ok'){
           this.$refs.shopCar_counter[index].beNumber(this.shopCars[index].counts)
          this.$emit('onOperateChrild',res.data.msg,true)
        }else{
           if(changeCountNum>0) {
             this.shopCars[index].counts = changeCountNum
           }else{
             this.shopCars.splice(index,1);
           }
        }
      }, (err) => {
          console.log(err)
          this.$refs.shopCar_counter[index].beNumber(this.shopCars[index].counts)
        })

      }, goToBuy() {
        this.$router.push({path: '/settlement/' + this.buyItem});
      }, goToBuyOne(val) {
        this.$router.push({path: '/settlement/' + val});
      }, resetCar() {
        this.$http.post('/test').then((res) => {
          if(res.data.msg!='ok'){
          this.$emit('onOperateChrild',res.data.msg,true)
        }else{
          this.shopCars=[]
          this.$emit('onOperateChrild','清空成功',true)
        }
      }, (err) => {
          this.$emit('onOperateChrild','清空失败，请稍后重试',true)
          console.log(err)
        })
      }
    },
    watch: {}
  }
</script>

<style scoped>
  . .main {
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
    margin-right: 120px;
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

  .counter {
    float: left;
    line-height: 0px;
  }
</style>
