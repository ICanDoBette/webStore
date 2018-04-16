<template>
  <div>
    {{numberToDo}}

    <slot name="header">插槽header没东西</slot>
    <button @click="hello">{{myValue}}</button>
    <slot name="footer">插槽footer没东西</slot>
  </div>
</template>

<script>
  export default {
   // props:['number-to-do','god'],
    props:{
      'number-to-do':[Number,String],
      'god':[Number,String],
      'my-value':[String]
    },
    data() {
      return {}
    },
    methods: {
      hello(){
        console.log(this.number)
        this.$emit('emit2',this.myValue)
      }
    }
  }
</script>

<style scoped>
  div {
    background-color: blueviolet;
  }
</style>
