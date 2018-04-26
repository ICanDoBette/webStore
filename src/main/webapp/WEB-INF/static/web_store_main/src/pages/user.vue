<template>
  <div class="main">
    <div><span>用户ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{id}}</span></div>
    <div><span>用户昵称:&nbsp;&nbsp;&nbsp;&nbsp;</span>
      <input type="text" v-model="name"/>
    </div>
    <div><span>电话:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
      <input type="text" v-model="tel"/>
    </div>
    <div><span>邮箱:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
      <input type="text" v-model="email"/>
    </div>
    <div><span style="margin-left:30px;">收货地址</span>
      <div style="margin-bottom:8px; font-size:small; margin-top:3px;">&nbsp;&nbsp;&nbsp;&nbsp;
        <span @click="addAddress" style="cursor:pointer; color:#4F4FCC">添加收货地址</span>
      </div>
      <div class="table" v-for="(item,index) in addresses"><span style="width:350px;">{{item.address}}</span>
        <div style="float:left; height:30px; width:1px; background-color:#99CC00;"></div>
        <span @click="deleteAddress(index)" style="height:30px; cursor:pointer;"><font color="#FF0000">&nbsp;&nbsp;×&nbsp;&nbsp;</font></span>
      </div>

    </div>
    <div style=" margin-top:0px;">
      <div @click="save"
           style="width:80px; height:30px; background-color:#99FF00; padding-top:13px; margin-left:170px;cursor: pointer;">
        <center>保存</center>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    created: function () {
      this.$http.post('/user/getAddresses').then((res) => {
        this.id=res.data.id
        this.name=res.data.name
        this.tel=res.data.tel
        this.email=res.data.email
        }, (err) => {
        console.log(err)
      })
      this.getAddress()
    }, data() {
      return {
        id: 0,
        name: '面包',
        tel: 110,
        email: '1034065132@qq.com',
        addresses: [
          {
            id: 1,
            address: '上海'
          }, {
            id: 2,
            address: '上海'
          }, {
            id: 3,
            address: '上海'
          }, {
            id: 4,
            address: '上海'
          }
        ]
      }
    }, methods: {
      deleteAddress(val) {
        this.$http.post('/test',{'id':this.addresses[val].id}).then((res) => {
          if(res.data.msg=='ok'){
          this.addresses.splice(val, 1);
          this.$emit('onOperateChrild','删除成功',true)
        }else{
          this.$emit('onOperateChrild',res.data.msg,true)
        }
      }, (err) => {
          console.log(err)
        })
      },
      save() {
        this.$http.post('/test',{'name':this.name,'tel':this.tel,'email':this.email}).then((res) => {
          if(res.data.msg=='ok'){
          this.$emit('onOperateChrild','修改成功',true)
        }else{
          this.$emit('onOperateChrild',res.data.msg,true)
        }
      }, (err) => {
          console.log(err)
        })
      }, addAddress() {
        this.$emit('onOperateAddress')
      }, getAddress() {
        this.$http.post('/test').then((res) => {
          this.addresses=res.data
      }, (err) => {
          console.log(err)
        })
      }
    },
    watch: {}
  }
</script>

<style scoped>
  .main {
    width: 463px;
    margin: 30px;
    border: groove 15px #F0CAB6;
    margin-left: 427px;
    margin-right: 427px;
  }

  .main > div {
    padding: 20px;
    margin-top: 28px;
  }

  .main > div > span {
    float: left;
    margin-left: 66px;
    font-size: medium;
  }

  .main > div > input {
    float: left;
    width: 200px;
  }

  .table {
    border: groove 2px #99CC00;
    margin-left: 30px;
    margin-right: 5px;
    height: 30px;
  }

  .table > span {
    float: left;
  }
</style>
