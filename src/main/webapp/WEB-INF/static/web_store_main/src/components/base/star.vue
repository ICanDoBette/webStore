<template>
  <div >
          <span v-for="(item,index) in stars" style="color: red;font-size: 25px;cursor: pointer;" @click="rating(index)">{{item.src}}</span>
  </div>

</template>

<script>
  export default {
     data() {
      return {
        stars: [{
          src: '☆',
        }, {
          src: '☆',
        }, {
          src: '☆',
        },
          {
            src: '☆',
          }, {
            src: '☆',
          }
        ],
      }
    },
    methods: {
      rating(index) {
        var i=0
        for (;i<=index;i++){
          this.stars[i].src='★'
        }
        debugger
        for (;i<this.stars.length;i++){
          this.stars[i].src='☆'
        }
        this.$emit('onChange',index+1)
      }
    }
  }
</script>

<style scoped>

</style>
