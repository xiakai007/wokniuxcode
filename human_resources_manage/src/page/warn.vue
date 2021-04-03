<style lang="stylus" scoped>
*{
  margin:0;
  padding:0;
}
.warn {
  height: 1000px;
  background: url('../assets/bg.jpg') no-repeat;
  background-size: 100% 100%;
}

.main {
  width: 100%;
  height: 100%;
  color: white;
}
.main .title{
    height:100px;
    color:red;
}
.main .title h1 {
    font-size:30px;
    line-height:100px;
}
.main .warnInfo{
    height: calc(100% - 100px);
    color: #f00;
}
.main .warnInfo ul{
  text-align:left;
  font-size:16px;
  padding-bottom:35px;
  padding-left:60px;
}
.main .warnInfo ul li{
  margin-top:5px;
}
</style>

<template lang="html">
<div class="warn">
  <div class="main">
      <v-header :name="name" :legendArr="legendArr" :myChart="myChart"></v-header>
      <div class = "title"> 
          <h1>告警信息</h1>
    </div>
    <div class="warnInfo">
        <ul v-for="item in num">
            <li>告警编号：{{warnId}}</li>
            <li>告警内容：{{warnContent}}</li>
            <li style="color:#fa0"><img src='../assets/svg/warn.jpg' style="margin-right:10px">告警状态：{{warnStatus}}</li>
            <li>汇报人编号：{{handlerID}}</li>
            <li>汇报人姓名：{{handlerName}}</li>
            <li>项目名称：{{organizationName}}</li>
            <li>告警时间：{{warnTime}}</li>
        </ul>
    </div>
  </div>
</div>
</template>

<script>
import axios from "axios";
import { format } from 'url';
export default {
  data() {
    return {
        num: '',
        warnId: '',
        warnContent: "",
        warnStatus: "",
        handlerID: "",
        handlerName: "",
        organizationID: "",
        organizationName: "",
        warnTime: ""
    };
  },
  created() {
    axios.get("http://10.61.180.134:8080/hr_manager/screen/get_screen_warn?organizationID=IM1803717662&organizationType=ProjectTeam").then(res => {
      console.log(res.data);
          for(let i = 0;i < res.data.length;i++) {
              this.warnId = res.data[i].warnID;
              this.warnContent = res.data[i].warnContent;
              this.warnStatus = res.data[i].warnStatus;
              this.handlerID = res.data[i].handlerID;
              this.handlerName = res.data[i].handlerName;
              this.organizationName = res.data[i].organizationName;
              this.warnTime = res.data[i].warnTime;
          }
        this.num = res.data.length;
      });
  }
};
</script>
