<template>
  <div>
    {{hello}}
    <button @click="emitOnComponentBMyEvent">emitOnComponentBMyEvent</button>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        name: "b",
        hello: 'hello i am component B'
      }
    },
    methods: {
      emitOnComponentBMyEvent() {
        this.$emit('my-event', this.hello)
      }
    }
  }
</script>

<style scoped>
  div {
    background-color: aqua;
  }
</style>
