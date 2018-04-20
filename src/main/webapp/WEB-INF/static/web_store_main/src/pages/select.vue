<template>
  <div class="main">
    <div>
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品类型：&nbsp;&nbsp;</h3>
      <select style="width:80px; float:left; margin-top:20px" v-model="selectProp.bigTypeValue"  autocomplete="off">
        <option value="-1">全部</option>
        <option v-for="(bigType,index) in bigTypes" :value="bigType.id">{{bigType.name}}</option>
      </select>
      <span style="float:left; height:1px; width:15px"></span>
      <select  autocomplete="off" v-if="selectProp.bigTypeValue!=-1" style="width:80px; float:left; margin-top:20px" v-model="selectProp.smallTypeValue">
        <option value="-1">全部</option>
        <option v-for="(smallType,index) in smallTypes" :value="smallType.id">{{smallType.name}}</option>
      </select>
    </div>
    <div>
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格区间：&nbsp;&nbsp;</h3>
      <div style="float:left" class="money">
        <input type="text" v-model.number="selectProp.selectMoneySmall"/>
        <span>元&nbsp;&nbsp;----&nbsp;&nbsp;</span>
        <input type="text" v-model.number="selectProp.selectMoneyBig"/>
        <span>元</span></div>
    </div>
    <div>
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关键字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
      <div style="float:left" class="money">
        <input style="width:200px;margin-left: -5px;" type="text" v-model="selectProp.selectName"/>
        <span @click="initData"
          :style="'background-image:url('+serchPic+');cursor: pointer;margin-top: 0px; width:26px; height:26px;'">&nbsp;</span>
      </div>
    </div>
    <hr style="margin:18px"/>
    <div class="items">
      <div v-for="good in goods"><img @click="goToDetail(good.id)" :src="good.picturePath"/>
        <div @click="goToDetail(good.id)" style="margin-top:8px"><span class="name"> {{good.name}}</span></div>
        <div @click="goToDetail(good.id)" style="height: 30px"><span style="float:left">￥{{good.price}}</span> <span style="float:right">{{good.buyCount}}人付款</span></div>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    created: function () {
      if(this.$route.query.selectName!=null){
        this.selectProp.selectName=this.$route.query.selectName
      }
      if (this.$route.query.bigTypeValue!=null){
        this.selectProp.bigTypeValue=this.$route.query.bigTypeValue
      }
      if (this.$route.query.smallTypeValue!=null){
        this.selectProp.smallTypeValue=this.$route.query.smallTypeValue
      }
      this.$http.post('/goods/type').then((res) => {
        this.bigTypes=res.data
        }, (err) =>{
          console.log(err)
        }
      )
      this.initData()
      this.selectProp.bigTypeValue=-1
      this.selectProp.smallTypeValue=-1
    },
    data() {
      return {
        serchPic:require('../assets/serch.png'),
        selectProp:{
          selectMoneyBig: null,
          selectMoneySmall: null,
          selectName: null,
          bigTypeValue: -1,
          smallTypeValue: -1,
        },
        bigTypes: [
          {
            name: 'big1',
            id: 1,
            smallTypes: [
              {
                name: 'small1',
                id: 4,
              }, {
                name: 'small2',
                id: 5,
              }, {
                name: 'small3',
                id: 6,
              }
            ]
          }, {
            name: 'big2',
            id: 2,
            smallTypes: [
              {
                name: 'small4',
                id: 4,
              }, {
                name: 'small5',
                id: 5,
              }, {
                name: 'small6',
                id: 6,
              }
            ]
          }, {
            name: 'big3',
            id: 3,
            smallTypes: [
              {
                name: 'small7',
                id: 4,
              }, {
                name: 'small8',
                id: 5,
              }, {
                name: 'small9',
                id: 6,
              }
            ]
          },
        ],
        smallTypes:[],
        goods: [
          {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          }, {
            name: 'small1',
            picturePath: '',
            price: 0,
            buyCount: 0,
            id: 4,
          },
        ]
      }
    }, methods: {
      goToDetail(val) {
        this.$router.push({path: '/goods/' + val});
      },initData(){
        this.$http.post('/goods/select', this.selectProp).then((res) => {
            this.goods=res.data
          }, (err) =>{
            console.log(err)
          }
        )
      }
    },
    watch: {
      ['selectProp.bigTypeValue'](){
        if(this.selectProp.bigTypeValue==-1){
          this.selectProp.smallTypeValue=-1
        }else {
            for(var i=0;i<this.bigTypes.length;i++){
              if (this.selectProp.bigTypeValue==this.bigTypes[i].id) {
                this.smallTypes=this.bigTypes[i].smallTypes
                break
              }
            }
        }
      },
      ['selectProp.selectMoneyBig'](){
        if(this.selectProp.selectMoneyBig==''){
          this.selectProp.selectMoneyBig=null
        }
        if (!((this.selectProp.selectMoneyBig | 0) === parseInt(this.selectProp.selectMoneyBig))||this.selectProp.selectMoneyBig<0){
          this.selectProp.selectMoneyBig=null
        }
      },
      ['selectProp.selectMoneySmall'](){
        if(this.selectProp.selectMoneySmall==''){
          this.selectProp.selectMoneySmall=null
        }
        if (!((this.selectProp.selectMoneySmall | 0) === parseInt(this.selectProp.selectMoneySmall))||this.selectProp.selectMoneySmall<0){
          this.selectProp.selectMoneySmall=null
        }
      },
    }
  }
</script>

<style scoped>
  .main{
    width:1347px;
    margin: 15px;
  }
  .main > div > h3 {
    float: left;
    font-size: 30px;
    margin-top: 15px;
  }

  .money input {
    float: left;
    height: 20px;
    width: 80px;
  }

  .money span {
    height: 15px;
    float: left;
    margin-top: 6px;
  }

  .main > div {
    height: 70px;
    position: relative;
    top: 40%;
  }

  .money {
    height: 40px;
    margin-top: 18px;
  }

  .items {
    height: auto;
  }

  .items > div {
    float: left;
    width: 200px;
    height: 285px;
    margin-left: 25px;
    margin-right: 25px;
    padding-bottom: -15px;
  }

  .items > div > div{
    cursor: pointer;
  }

  .items > div > img {
    width: 200px;
    height: 200px;
    cursor: pointer;
  }

  .items > div span {
    margin-top: 8px;
    height: 40px;
  }
</style>
