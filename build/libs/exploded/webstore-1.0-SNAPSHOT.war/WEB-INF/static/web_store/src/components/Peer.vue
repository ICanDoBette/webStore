<template>
  <div>
    {{ hello }}
    <router-view></router-view>
    <router-link :to="{path:'red',param:{color:'green'}}" tag="li">red</router-link>
    <router-link :to="{path:'green'}">green</router-link>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        hello: '<div>peer</div>'
      }
    }
  }
</script>

<style scoped>

</style>
