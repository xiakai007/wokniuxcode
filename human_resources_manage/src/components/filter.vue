<style>
  .linkage {
    position: relative;
    display: flex;
    z-index: 9999;
    left:28%;
    top:9%;
    }
    .linkage .el-select .el-input__inner{
      width:150px;
      background: rgb(248, 248, 250);
    }
</style>

<template>
<div class="linkage" lang="html">
  <!-- <el-select v-model="value" placeholder="BD">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select> -->
    <el-select
      v-model="sheng"
      @change="choseProvince"
      placeholder="BU">
      <el-option
        v-for="item in province"
        :key="item.id"
        :label="item.value"
        :value="item.id">
      </el-option>
    </el-select>
    <el-select
      v-model="shi"
      @change="choseCity"
      placeholder="CU">
      <el-option
        v-for="item in city"
        :key="item.id"
        :label="item.value"
        :value="item.id">
      </el-option>
    </el-select>
    <el-select
      v-model="qu"
      @change="choseBlock"
      placeholder="项目组">
      <el-option
        v-for="item in qu1"
        :key="item.id"
        :label="item.value"
        :value="item.id">
      </el-option>
    </el-select>
  </div>
</template>

<script type="text/javascript">
import axios from 'axios'
export default {
  data () {
    return {
      organizationID: [],
      mapJson:'../../static/data/map.json',
      province:[],
      sheng: '',
      shi: '',
      shi1: [],
      qu: '',
      qu1: [],
      city:[],
      cityValue:'',
      block:'',
      id:'',
      value:''
    }
  },
  methods:{
    // 加载china地点数据，三级
      getCityData:function(){
        var that = this;
        axios.get("http://10.61.180.134:8080/hr_manager/organization/get_child_organization_infos?organizationID=10022580").then(res => {
          that.province = [];
          var data = res.data;
          data.forEach(element => {
            that.province.push({id:element.organizationID,value:element.organizationName});
          });
        })  
      },
      choseProvince:function(e) {  
        var that = this;
        that.city = [];
        that.organizationID.push(e);
        axios.get("http://10.61.180.134:8080/hr_manager/organization/get_child_organization_infos?organizationID=" + e).then(
          res => {
            var data = res.data;
            data.forEach(element => {
              that.city.push({id:element.organizationID,value:element.organizationName});
            });
        });
      },
      choseCity:function(e) {
        var that = this;
        that.organizationID.push(e);
        that.qu1 = [];
        axios.get("http://10.61.180.134:8080/hr_manager/organization/get_child_organization_infos?organizationID=" + e).then(
          res => {
            var data = res.data;
            data.forEach(element => {
              that.qu1.push({id:element.organizationID,value:element.organizationName});
            });
        });
      },
      choseBlock:function(e) {
        this.E=e;
      }
    },
    created:function(){
      this.getCityData();
    }
}
</script>
