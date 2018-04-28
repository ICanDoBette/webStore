<template>
  <div style="width:1100px; margin-top: 15px; margin:0 auto"><img :src="picturePath"
                                                                  style="width:400px; height:400px; float:left; padding-left:50px"/>
    <div style="float:right; width:490px; height:400px; padding-right:50px;">
      <div>
        <h4 style="font-size:35px; padding-left:15px;">{{name}}</h4>
      </div>
      <hr color="#CCCCCC"/>
      <div style="height:55px; padding:3px;">
        <span style="color:#000033; font-size:20px; margin-top:10px; float:left">价格</span>
        <div style="float:left; width:130px; ">&nbsp;</div>
        <span style="color:#FF0000; font-size:30px; float:left">￥{{price}}</span>
      </div>
      <div style="height:55px; padding:3px;">
        <span style="color:#000033; font-size:20px; margin-top:10px; float:left">购买数量</span>
        <div style="float:left; width:130px;">&nbsp;</div>
        <counter style="float:left;" :max="count" :min="count-count" defaultNumber="0" @onChangeNum="changedBuy"
                 ref="buy_counter"></counter>
      </div>
      <div style="height:55px; padding:3px;">
        <span style="color:#000033; font-size:20px; margin-top:10px; float:left">库存</span>
        <div style="float:left; width:130px; ">&nbsp;</div>
        <span style="color:#FF0000; font-size:30px; float:left">{{count}}</span>
      </div>
      <div style="padding:3px;" v-if="isLogin">
        <div @click="buy"
             :class="buyCss">
          <div style="height:8px"></div>
          <center>
            {{buyWord}}
          </center>
        </div>
        <div style="float:left; width:8px;">&nbsp;</div>
        <div v-show="count!=0" @click="addShopCar"
             style="float:left; height:40px; width:150px; background:#F22D00;cursor:pointer; ">
          <div style="height:8px"></div>
          <center>
            <font color="#FFFFFF">加入购物车</font>
          </center>
        </div>
        <div>

        </div>
      </div>
      <div style="padding:3px;" v-else>
        <center>亲,登陆即可购买哦</center>
      </div>
    </div>
    <div style="height:40px;float:left; width:800px;">&nbsp;</div>
    <div style="background-color:#999999; margin-left:50px; height:1px; float:left; width:1000px"></div>
    <div
      style=" margin-top:50px; margin-left:50px; width:1000px; float:left;border:solid 1px; border-bottom-color:#FFFFFF; border-top-color:#333333; border-left-color:#E5E5EF; border-right-color:#E5E5EF; background-color:#666666">
      <div style="margin-left: 5px" :class="commentHeader1" @click="switchHeader(1)">
        <div style="height:8px"></div>
        <center>
          宝贝详情
        </center>
      </div>
      <div
        :class="commentHeader2" @click="switchHeader(2)">
        <div style="height:8px"></div>
        <center>
          宝贝评论
        </center>
      </div>
      <div style="width:1000px; float:left; background-color:#CCCCCC" v-if="isComment">
        <div style="float:left; margin-left:50px; margin-top:10px; width:1000px">平均分值:
          <font color="#FF0000"><span v-for="n in avg">★</span></font>
        </div>
        <div :class="{commentBackground:(index % 2==0) }" style="float:left; margin:5px;"
             v-for="(comment,index) in comments">
          <div style="float:left; width:100px; height:100px">
            <div style=" height:15px; position:relative; top:30%;">
              <center>
                {{comment.name}}
              </center>
            </div>
            <div style=" height:15px; position:relative; top:40%;">
              <center>
                <font color="#FF0000"><span v-for="n in comment.star">★</span></font>
              </center>
            </div>
          </div>
          <div style="float:left; height:100px; margin-left:20px; width:870px"><span
            style=" height:30px; position:relative; top:40%;">{{comment.comment}}</span></div>
        </div>
      </div>
      <div style="width:1000px; float:left; background-color:#CCCCCC" v-else v-html="information">
      </div>
    </div>

  </div>
</template>

<script>
  import Counter from '../components/base/counter'

  export default {
    created: function () {
      this.$http.post('/goods/detail',{'id':this.$route.params.id}).then((res) => {
        this.id = res.data.id
        this.name = res.data.name
        this.picturePath = res.data.picturePath
        this.bigType = res.data.bigType
        this.smallType = res.data.smallType
        this.count = res.data.count
        this.price = res.data.price
        this.information = res.data.information
      }, (err) => {
        console.log(err)
      })
      this.$http.post('/goods/comment',{'id':this.$route.params.id}).then((res) => {
        this.avg = res.data.avg
        this.comments =res.data.comments
      }, (err) => {
        console.log(err)
      })
    },
    components: {
      Counter: Counter,
    },
    data() {
      return {
        id: 0,
        name: '',
        picturePath: '',
        bigType: '',
        smallType: '',
        count: 0,
        price: '',
        information: '',
        buyNum: 0,
        isComment: false,
        avg: 0,
        comments: [],
        commentHeader1: 'commentHeaderCheckBackground',
        commentHeader2: 'commentHeaderUnCheckBackground',
        Msg: '',
        buyCss: '',
        buyWord: ''
      }
    }, methods: {
      changedBuy(val) {
        this.buyNum = val
      }, switchHeader(val) {
        if (val == 1) {
          this.isComment = false
        } else {
          this.isComment = true
        }
      },buy(){
        if(this.count>0&&this.buyNum>0){
          this.$http.post('/buy/addShopCar',{'id':this.id,'buyNum':this.buyNum}).then((res) => {
            if(res.data.msg!='ok'){
              if(res.data.count!=-1) {
                this.count = res.data.count
                this.buyNum = 0
              }
              this.$refs.buy_counter.beZero()
              this.$emit('onOperateChrild',res.data.msg,true)
            }else{
              if(res.data.count!=-1) {
                this.count = res.data.count
                this.buyNum = 0
              }
              this.$router.push({path: '/settlement/'+ res.data.shopCarId});
            }
          }, (err) => {
          console.log(err)
          })
        }else if(this.count>0&&this.buyNum<=0) {
          this.$emit('onOperateChrild','请输入购买数量！',true)
        }
      },addShopCar(){
        if(this.count>0&&this.buyNum>0){
          this.$http.post('/buy/addShopCar',{'id':this.id,'buyNum':this.buyNum}).then((res) => {
            if(res.data.msg!='ok'){
              if(res.data.count!=-1) {
               this.count = res.data.count
               this.buyNum = 0
              }
             this.$refs.buy_counter.beZero()
             this.$emit('onOperateChrild',res.data.msg,true)
           }else{
             if(res.data.count!=-1) {
               this.count = res.data.count
               this.buyNum = 0
             }
              this.$refs.buy_counter.beZero()
              this.$emit('onOperateChrild','添加成功，商品在购物车哦亲~',true)
            }
           }, (err) => {
             console.log(err)
           })
        }else if(this.count>0&&this.buyNum<=0) {
          this.$emit('onOperateChrild','请输入购买数量！',true)
        }
      }
    }, props: {
      'isLogin': [Boolean]
    },
    watch: {
      isComment() {
        if (!this.isComment) {
          this.commentHeader1 = 'commentHeaderCheckBackground'
          this.commentHeader2 = 'commentHeaderUnCheckBackground'
        } else {
          this.commentHeader1 = 'commentHeaderUnCheckBackground'
          this.commentHeader2 = 'commentHeaderCheckBackground'
        }
      }, count() {
        if (this.count > 0) {
          this.buyCss = 'canbuy'
          this.buyWord = '立即购买'
        } else {
          this.buyCss = 'cantbuy'
          this.buyWord = '已售光'
        }
      }
    }
  }
</script>

<style scoped>
  .commentBackground {
    background: #999999
  }

  .commentHeaderCheckBackground {
    cursor: pointer;
    background-color: #FFFFFF;
    width: 200px;
    height: 45px;
    float: left;
    color: #FF4400;
  }

  .commentHeaderUnCheckBackground {
    cursor: pointer;
    background-color: #999999;
    width: 200px;
    height: 45px;
    float: left;
    border-bottom-color: #E5E5EF
  }

  .canbuy {
    float: left;
    height: 40px;
    width: 135px;
    background: #FFD9BC;
    border: solid 1px #F0CAB6;
    cursor: pointer;
    color: #E5511D
  }

  .cantbuy {
    float: left;
    height: 40px;
    width: 135px;
    background: rgba(191, 191, 191, 0.93);
    cursor: not-allowed;
    color: #e8000a
  }
</style>
