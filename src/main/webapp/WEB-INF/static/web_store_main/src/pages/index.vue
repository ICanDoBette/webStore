<template>
  <div class="index-wrap">
    <div class="index-left">
      <div class="index-left-block">
        <h2>全部产品</h2>
        <template v-for="product in productList">
          <h3 @click="function() {
            $router.push({path: '/selectPage?bigTypeValue='+ product.id});
          }" style="cursor: pointer;">{{ product.name}}</h3>
          <ul>
            <li v-for="item in product.smallTypes">
              <a :href="'/#/selectPage?smallTypeValue='+item.id">{{ item.name }}</a>
            </li>
          </ul>
          <div class="hr"></div>
        </template>
      </div>
      <div class="index-left-block lastest-news">
        <h2>最新消息</h2>
        <ul>
          <li v-for="item in newsList">
            <a :href="item.url" class="new-item">{{ item.title }}&nbsp;&nbsp;
              <span v-if="item.hot===true"
                    class="hot-tag">HOT</span></a>
            <div style="background-color: #EEE ; width: 150px ;height: 2px; margin-bottom: 20px;margin-top: 8px"></div>

          </li>
        </ul>
      </div>
    </div>
    <div class="index-right">
      <slide-show :slides="slides" :inv="invTime"></slide-show>
      <div class="index-board-list">
        <div
          class="index-board-item"
          v-for="(item, index) in boardList"
          :class="[{'line-last' : index % 2 !== 0} ]">
          <div class="index-board-item-inner" :style="'background: url('+item.picturePath+') no-repeat;'">
            <h2>{{ item.name }}</h2>
            <p>{{ item.comment }}</p>
            <div v-if="!item.saleout" class="index-board-button">
              <router-link class="button" :to="{path: '/goods/' + item.goodId}">去看看</router-link>
            </div>
            <div v-else class="index-board-button">
              <div class="button-cant">已售光</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import slideShow from '../components/slideShow.vue'
  export default {
    created: function () {
      this.$http.post('/goods/type').then((res) => {
        this.productList = res.data
      }, (err) => {
        console.log(err)
      })
      this.$http.post('/news/getBigNews').then((res) => {
        this.slides = res.data
      }, (err) => {
        console.log(err)
      })
      this.$http.post('/news/getSmallNews').then((res) => {
        this.newsList = res.data
      }, (err) => {
        console.log(err)
      })
      this.$http.post('/goods/boardList').then((res) => {
        this.boardList = res.data
    }, (err) => {
        console.log(err)
      })
    },components:{
      slideShow
    },
    data() {
      return {
        invTime:10000,
        slides:[],
        productList: [
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
        newsList: [
          {
            title: 'news1',
            url: '/news1'
          }, {
            title: 'news2',
            url: '/news2',
            hot: true
          }, {
            title: 'news2',
            url: '/news2'
          }, {
            title: 'news2',
            url: '/news2'
          },
        ],
        boardList: [
          {
            goodId:1,
            name: '开放产品',
            picturePath: '',
            comment: '开放产品是一款开放产品',
            saleout: false
          }, {
            goodId:2,
            name: '品牌营销',
            picturePath: '',
            comment: '品牌营销帮助你的产品更好地找到定位',
            saleout: false
          }, {
            goodId:3,
            name: '使命必达',
            comment: '使命必达快速迭代永远保持最前端的速度',
            picturePath: '',
            saleout: true
          }, {
            goodId:4,
            name: '永攀高峰',
            picturePath: '',
            comment: '帮你勇闯高峰，到达事业的顶峰',
            saleout: false
          }
        ]
      }
    }
  }
</script>

<style scoped>
  .index-wrap {
    width: 1200px;
    margin: 0 auto;
    overflow: hidden;
  }

  .index-left {
    float: left;
    width: 300px;
    text-align: left;
  }

  .index-right {
    float: left;
    width: 900px;
  }

  .index-left-block {
    margin: 15px;
    background: #fff;
    box-shadow: 0 0 1px #ddd;
  }

  .index-left-block .hr {
    margin-bottom: 20px;
  }

  .index-left-block h2 {
    background: #4fc08d;
    color: #fff;
    padding: 10px 15px;
    margin-bottom: 20px;
  }

  .index-left-block h3 {
    padding: 0 15px 5px 15px;
    font-weight: bold;
    color: #222;
  }

  .index-left-block ul {
    padding: 10px 15px;
  }

  .index-left-block li {
    padding: 5px;
  }

  .index-board-list {
    overflow: hidden;
  }

  .index-board-item {
    float: left;
    width: 400px;
    background: #fff;
    box-shadow: 0 0 1px #ddd;
    padding: 20px;
    margin-right: 20px;
    margin-bottom: 20px;
  }

  .index-board-item-inner {
    min-height: 125px;
    padding-left: 120px;
  }

  .index-board-car .index-board-item-inner {

  }

  .index-board-loud .index-board-item-inner {
    background: url(../../../../files/pictures/2.png) no-repeat;
  }

  .index-board-earth .index-board-item-inner {
    background: url(../../../../files/pictures/3.png) no-repeat;
  }

  .index-board-hill .index-board-item-inner {
    background: url(../../../../files/pictures/4.png) no-repeat;
  }

  .index-board-item h2 {
    font-size: 18px;
    font-weight: bold;
    color: #000;
    margin-bottom: 15px;
  }

  .line-last {
    margin-right: 0;
  }

  .index-board-button {
    margin-top: 20px;
  }

  .lastest-news {
    min-height: 512px;
  }

  .hot-tag {
    background: red;
    color: #fff;
  }

  .new-item {
    display: inline-block;
    width: 230px;
  }
</style>
