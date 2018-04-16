<template>
  <div>
    <p :style="'color:'+ myColor">123</p>
    {{ hello }}
    <button @click="getParam">get param</button>
    <p>{{$route.params.color}}</p>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        myColor:'black',
        hello: 'apple'
      }
    }
    ,methods:{
      getParam(){
        this.myColor=this.$route.params.color
      }
    }
  }
</script>

<style scoped>

</style>
