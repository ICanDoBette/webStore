<template>
  <div>
    <div class="main">
      <div style="float:right;margin-right:80px;">
        <div style="margin-top:100px; font-size:20px;  height:40px;">
          <span>请选择您的收货地址&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span>
          <span @click="updateAddress" style="
    background: #4FC08D;
    color: #FFFFFF;
    padding: 5px;
    cursor: pointer; font-size:small">更新收货地址信息</span></div>
        <!--收货地址 -->
        <div v-for="(item,index) in addresses" style=" width:550px;height:90px;">
          <div class="carDetail" style="width:40px;">
            <center>
              <input style="margin-top:40px;" v-model="selectAddress" type="radio" name="addressRadio"
                     :value="item.id"/>
            </center>
          </div>
          <div class="carDetail" style="width:510px;"> {{item.address}}</div>
        </div>

        <!--收货地址结束,测试 -->
        <div style="margin-top:5px; font-size:30px;  height:40px;"><span>需付款{{needToPay}}元</span></div>
        <div style="margin-top:5px; font-size:20px;  height:40px;"><span>请选择您的付款方式</span></div>

        <bank-chooser @onChangeBank="setBankId"></bank-chooser>

        <div style="margin-top:5px; height:40px;">
        <span @click="pay" style="
    background: #4FC08D;
    color: #FFFFFF;
    padding: 5px;
    cursor: pointer; font-size:20px; float:right; margin-right:30px;">付款</span></div>
      </div>
      <!-- 测试没事-->
    </div>
    <!-- 头部开始 -->
    <div style=" width:580px; height:180px; margin-left:30px;">
      <div style="font-size:medium; height:100px;"><span style="font-size:40px;">结算</span></div>
      <div style="font-size:medium; height:40px;"><span style="font-size:20px;">您将购买以下商品</span></div>
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
    </div>
    <!-- 头部结束 商品开始 -->
    <div v-for="(item,index) in shopCars" style=" width:580px;  margin-left:30px;">
      <div class="carTitle"><span>{{item.updateTime}}</span><span>购物车号: {{item.id}}</span></div>
      <div style=" width:100%;height:90px;">
        <div class="carDetail" style="width:90px;">
          <center>
            <img :src="item.picturePath" width="80px" height="80px" style="margin-top:5px;"/>
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
            {{item.counts*item.price}}
          </center>
        </div>
      </div>
    </div>
    <!-- 商品结束 -->

    <!-- 测试 -->
  </div>
</template>

<script>
  import BankChooser from '../components/bankChooser'

  export default {
    created: function () {
      this.payThings=this.$route.params.val
      this.$http.post('/user/getAddresses').then((res) => {
        this.addresses=res.data
    }, (err) => {
        console.log(err)
      })
      this.$http.post('/user/getShopCar',{'id':this.payThings}).then((res) => {
        this.shopCars=res.data
    }, (err) => {
        console.log(err)
      })
    },
    components: {
      BankChooser: BankChooser,
    }, data() {
      return {
        payThings:[],
        bankId: -1,
        selectAddress: -1,
        addresses: [],
        shopCars: []
      }
    }, methods: {
      updateAddress() {
        this.$router.push({path: '/user'})
      }, setBankId(val) {
        this.bankId = val
      }, pay() {
        if (this.bankId == -1) {
          this.$emit('onOperateChrild','请选择付款方式',true)
          return;
        }
        if (this.selectAddress == -1) {
          this.$emit('onOperateChrild','请选择或新增收货地址',true)
          return;
        }
        this.$http.post('/buy/pay',{'id':this.payThings,'payWay':this.bankId,'address':this.selectAddress}).then((res) => {
          if(res.data.msg!='ok'){
          this.$emit('onOperateChrild','付款失败!'+res.data.msg,true)
        }else{
          this.$router.push({path: '/alreadyBuy'})
          this.$emit('onOperateChrild','购买成功!!',true)
        }
      }, (err) => {
          this.$emit('onOperateChrild','付款失败!'+err,true)
        })
      }
    },
    computed: {
      // 计算属性
      needToPay() {
        var temp = 0
        for (var i = 0; i < this.shopCars.length; i++) {
          temp = temp + this.shopCars[i].price * this.shopCars[i].counts
        }
        return temp;
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
    width: 580px;
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
