<template>
  <div>
    <div style=" height: 50px"></div>
    <center><h5 style="margin-bottom: 20px"><font color="#E6842D" size="35px">{{title}}</font></h5></center>
    <div style=" height: 30px"></div>
    <center><img v-show="picturePath!=null&&picturePath!=undefined&&picturePath!=''" :src="picturePath" height="300px" width="500px"/></center>
    <div style=" height: 30px"></div>
    <center>
      <div v-html="contain"></div>
    </center>
    <center>
      <div style="width: 30%">
      <a @click="goBackward" style="cursor:pointer;padding:8px;color: #e3e4e8; float:left;background-color: #42b983;font-size: 20px;width: 20%;height: 30px;">返回上页</a>
      <a href="/" style="cursor:pointer;padding:8px;color: #e3e4e8; float:right;background-color: #42b983;font-size: 20px;width: 20%;height: 30px">返回主页</a>
      </div>
      <div style=" height: 30px"></div>
    </center>

  </div>
</template>

<script>
  export default {
    created: function () {
      this.$http.post('/news/getNewsDetail', {id: this.$route.params.id}).then((res) => {
        this.title = res.data.title
        this.picturePath = res.data.picturePath
        this.contain = res.data.contain
        }, (err) => {
        console.log(err)
      })
    },data() {
      return {
        title:'',
        picturePath:'',
        contain:''
      }
    },methods:{
        goBackward(){
          this.$router.go(-1)
        }
    }
  }
</script>

<style>

</style>
