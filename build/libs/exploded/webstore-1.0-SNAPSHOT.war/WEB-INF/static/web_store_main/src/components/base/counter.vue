<template>
  <div style="border:solid 1px #8E8E8E; width:140px; height:32px">
    <div @click="remove" :class="canremove"
         style="float:left; width:30px; background-color:#BEBEBE;border:solid 1px #8E8E8E; height:30px;">

      <center style="padding-top: 8px;">
        -
      </center>
    </div>
    <div style="float:left; width:74px;border:solid 1px #8E8E8E; height:30px">
      <div style="height:3px"></div>
      <center>
        <input style="margin-top: -3px;width: 70px;height: 25px;text-align:center" type="text" v-model.number="number"
               @keyup="fixNumber"/>
      </center>
    </div>
    <div @click="add" :class="canPlus"
         style="float:right; width:30px; background-color:#BEBEBE;border:solid 1px #8E8E8E; height:30px;">

      <center style="padding-top: 8px;">+
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
      }, defaultNumber: {
        type: Number,
        default: 0
      }, defaultId: {
        type: Number,
        default: 0
      }
    },
    created: function () {
      if (this.defaultNumber != 0) {
        this.number = this.defaultNumber
      }
      if (this.defaultId != 0) {
        this.id = this.defaultId
      }
      this.makeCss()
    }, data() {
      return {
        id:0,
        number: 0,
        canPlus: 'can_do',
        canremove: 'cant_do',
      }
    },
    watch: {
      number() {
        //debugger
        console.log(this.number+'   '+this.id)
        this.$emit('onChangeNum',
          this.number,
          this.id
        )
      }
    },
    methods: {
      fixNumber() {
        if (!((this.number | 0) === parseInt(this.number)) || this.number < this.min) {
          this.number = this.min
        } else if (this.number > parseInt(this.max)) {
          this.number = this.max
        }
        this.makeCss()
      },
      makeCss() {
        if (this.number <= this.min) {
          this.canremove = 'cant_do'
        } else {
          this.canremove = 'can_do'
        }
        if (this.number >= this.max) {
          this.canPlus = 'cant_do'
        } else {
          this.canPlus = 'can_do'
        }
      },
      remove() {
        if (this.number <= this.min) {
          return
        }
        this.number--
        this.makeCss()
      },
      add() {
        if (this.number >= this.max) {
          return
        }
        this.number++
        this.makeCss()
      }, beZero() {
        this.beNumber(0)
      },beNumber(val){
        this.number = val
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
