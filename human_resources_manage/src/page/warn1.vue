<!-- 饼状图 -->
<style lang="stylus" scoped>
.warna {
  height: 800px;
  background: '#fff';
  background-size: 100% 100%;
  color: white;
  position: absolute;
}

.main {
  width: 100%;
  height: calc(100% - 100px);
  margin-top: 40px;
  position: absolute;
}

.buttonInfo {
  position: relative;
  top: 75%;
}

</style>

<template lang="html">
<div class="warna">
  <v-header :name="name" :legendArr="legendArr" :myChart="myChart"></v-header>
  <!-- <v-filter :myChart="myChart" v-if="myChart._dom"></v-filter>  -->
  <div class="main"></div>
  <div class = "buttonInfo">
      <el-popover
        placement="top"
        width="550"
        trigger="click">
        <el-table :data="gridData">
            <el-table-column width="100" property="warnTime" label="告警日期"></el-table-column>
            <el-table-column width="200" property="organizationName" label="项目名称"></el-table-column>
            <el-table-column width="150" property="warnContent" label="告警内容"></el-table-column>
            <el-table-column width="100" property="handlerName" label="处理人"></el-table-column>
        </el-table>
        <el-button slot="reference"  type="danger">告警详情</el-button>
        </el-popover>
  </div>
</div>

</template>

<script>
import axios from "axios";
import echarts from "echarts";
import header from "../components/header";
import filter from "../components/filter";
export default {
  data() {
    return {
      legendArr: [],
      color: this.$store.state.color,
      myChart: {},
      name: "告警信息",
      gridData:[{
          warnTime: '',
          organizationName: '',
          warnContent: '',
          handlerName: ''
      }]
    };
  },
  created() {
    var that = this;
    axios.get("http://10.61.180.134:8080/hr_manager/screen/get_screen_warn?organizationID=IM1803717662&organizationType=ProjectTeam").then(res => {
        for(let i = 0;i < res.data.length;i++) {
          var gridDataObj = {};
          gridDataObj['warnContent'] = res.data[i].warnContent;
          gridDataObj['handlerName'] = res.data[i].handlerName;
          gridDataObj['organizationName'] = res.data[i].organizationName;
          gridDataObj['warnTime'] = res.data[i].warnTime;
          that.gridData.push(gridDataObj);
        }
    })
    },
  methods: {
    init() {
      this.legendArr = this.myChart.getOption().series;
      this.legendArr.forEach(data => {
        data.selected = true;
      });
      this.$root.charts.push(this.myChart);
      window.addEventListener(
        "resize",
        function() {
          this.myChart.resize();
        }.bind(this)
      );
    },
    getWarnDetail() {}
  },
  components: {
    "v-header": header,
    "v-filter": filter
  },
  mounted() {
    // 基于准备好的dom，初始化echarts实例
    this.myChart = echarts.init(document.querySelector(".warna .main"));
    this.myChart.setOption({
      title: {
        text: "告警程度", //标题文本内容
        textStyle: {
          fontWeight: 'bolder',
          color: "#f00",
          fontSize: "20px"
        }
      },
      toolbox: {
        //可视化的工具箱
        show: true,
        feature: {
          restore: {
            //重置
            show: true
          },
          saveAsImage: {
            //保存图片
            show: true
          }
        }
      },
      tooltip: {
        //弹窗组件
        formatter: "{a} <br/>{b} : {c}%"
      },
      series: [
        {
          name: "告警级别",
          type: "gauge",
          axisLine: {
                lineStyle: {
                    width: 50  // 这个是修改宽度的属性
                }
          },
          detail: { formatter: "{value}%" },
          data: [{ value: 85, name: "告警程度" }],
          label: {
            normal: {
              show: true,
              textStyle: {
                fontSize: 18, //文字的字体大小
                color: "#f00"
              }
            }
          }
        }
      ]
    });
    this.init();
    setInterval(function() {
      //把option.series[0].data[0].value的值使用random()方法获取一个随机数
      // option.series[0].data[0].value = (Math.random() * 100).toFixed(2) - 0;
      // myChart.setOption(option, true);
    }, 2000);

    
  }
};
</script>
