<template>
  <div style="border:solid 1px #8E8E8E; width:140px; height:32px">
    <div @click="remove" :class="canremove"
         style="float:left; width:30px; background-color:#BEBEBE;border:solid 1px #8E8E8E; height:30px;">
      <div style="height:3px"></div>
      <center>
        -
      </center>
    </div>
    <div style="float:left; width:74px;border:solid 1px #8E8E8E; height:30px">
      <div style="height:3px"></div>
      <center>
        <input style="margin-top: -3px;width: 70px;height: 25px;text-align:center" type="text" v-model.number="number" @keyup="fixNumber"/>
      </center>
    </div>
    <div @click="add" :class="canPlus"
         style="float:right; width:30px; background-color:#BEBEBE;border:solid 1px #8E8E8E; height:30px;">
      <div style="height:3px"></div>
      <center>+
      </center>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    max: {
      type: Number,
      default: 10
    },
    min: {
      type: Number,
      default: 1
    }
  },
  data () {
    return {
      canPlus: 'can_do',
      canremove: 'cant_do',
      number: this.min
    }
  },
  watch: {
    number () {
      this.$emit('onChangeNum', this.number)
    }
  },
  methods: {
    fixNumber () {
      if (!((this.number | 0) === parseInt(this.number))||this.number<this.min){
        this.number=this.min
      }else if(this.number>parseInt(this.max)){
        this.number=this.max
      }
      this.makeCss()
    },
    makeCss(){
      if (this.number<=this.min){
        this.canremove='cant_do'
      }else {
        this.canremove='can_do'
      }
      if (this.number>=this.max){
        this.canPlus='cant_do'
      }else {
        this.canPlus='can_do'
      }
    },
    remove () {
      if (this.number <= this.min) {
        return
      }
      this.number --
      this.makeCss()
    },
    add () {
      if (this.number >= this.max) {
        return
      }
      this.number ++
      this.makeCss()
    }
  }
}
</script>

<style scoped>
  .can_do {
    cursor: pointer;
    color: #000000;
  }

  .cant_do {
    cursor: not-allowed;
    color: #8E8E8E;
  }
</style>
