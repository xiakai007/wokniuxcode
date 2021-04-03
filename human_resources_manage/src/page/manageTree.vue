<template lang="html">
  <!-- <div class="tree fillcontain">
    
  </div> -->
  <div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
            <TreeChart :json="data" :class="{landscape: landscape.length}" @click-node="clickNode" />
    </div>
    </div>
</template>

<script>
import TreeChart from "../components/TreeChart";
import headTop from '../components/headTop';
export default {
  name: 'app',
  components: {
    TreeChart,
    headTop
  },
  data() {
    return {
      landscape: [],
      data: {
        name: '云核心网',
        image_url: "https://static.refined-x.com/avat.jpg",
        children: [
          {
            name: '云核心网1',
            image_url: "https://static.refined-x.com/avat1.jpg"
          },
          {
            name: '云核心网2',
            image_url: "https://static.refined-x.com/avat2.jpg",
            // mate: {
            //   name: 'mate',
            //   image_url: "https://static.refined-x.com/avat3.jpg"
            // },
            children: [
              {
                name: '云核心网3',
                image_url: "https://static.refined-x.com/avat.jpg"
              },
              {
                name: '云核心网4',
                image_url: "https://static.refined-x.com/avat1.jpg"
              },
              {
                name: '云核心网5',
                image_url: "https://static.refined-x.com/avat2.jpg"
              }
            ]
          }
        ]
      }
    }
  },
  methods: {
    clickNode: function(node){
      this.$router.push({path:'/userList'})
      console.log(node)
    }
  }
}
</script>

<style lang="less">
	@import '../style/mixin';
    .table_container{
        padding: 20px;
    }
    .demo-table-expand {
	    font-size: 0;
	}
	.demo-table-expand label {
	    width: 90px;
	    color: #99a9bf;
	}
	.demo-table-expand .el-form-item {
	    margin-right: 0;
	    margin-bottom: 0;
	    width: 50%;
	}
</style>





