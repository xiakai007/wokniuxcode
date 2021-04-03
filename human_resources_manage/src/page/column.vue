<!-- 饼状图 -->
<style lang="stylus" scoped>
.columnChart {
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
}

.selectLevel {
  width: 20%;
  position: relative;
  bottom: 70%;
  left: 10%;
}

.levelButton {
  width: 10%;
  position: relative;
  bottom: 80%;
  left: 30%;
}

.el-select .el-input {
  width: 50px;
}

.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>

<template lang="html">
<div class="columnChart">
  <v-header :name="name" :legendArr="legendArr" :myChart="myChart"></v-header>
  <!-- <v-filter :myChart="myChart" v-if="myChart._dom"></v-filter> -->
  <div class="main"></div>
<!-- <div class="levelButton">
<el-button slot="append" icon="el-icon-search" @click="setData">确认</el-button>
</div> -->
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
      name: "员工级别占比",
      input3: [],
      optionsData: [],
      levelData: [],
      healthData: [],
      healthDataTwo: [],
      select: ""
    };
  },
  methods: {
    init() {
      // this.legendArr = this.myChart.getOption().series;
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
  },
  components: {
    "v-header": header,
    "v-filter": filter
  },
  mounted() {
    // 基于准备好的dom，初始化echarts实例
    this.myChart = echarts.init(document.querySelector(".columnChart .main"));
    let that = this;
    axios
      .get(
        "http://10.61.180.134:8080/hr_manager/organization/health_check?organizationID=IM1803717662"
      )
      .then(res => {
        that.realData = res.data[0].realList;
        that.healthData = res.data[0].healthList;
        let realName = [];
        for (let i = 0; i < res.data[0].realList.length; i++) {
          realName.push(res.data[0].realList.name);
        }
        this.myChart.setOption({
          title: {
            text: "员工级别占比",
            subtext: "总体级别占比",
            textStyle: {
              color: "#f90",
              fontSize: "30px"
            },
            x: "center"
          },
          tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
            orient: "horizontal",
            x: "center",
            y: "500",
            itemWidth: 40, // 设置图例图形的宽
            itemHeight: 20, // 设置图例图形的高
            textStyle: {
              color: "#ccc" // 图例文字颜色
            },
            //backgroundColor: '#eee',  // 设置整个图例区域背景颜色
            data: this.realName
            // data: this.levelName
          },
          toolbox: {
            show: true,
            feature: {
              mark: { show: true },
              dataView: { show: true, readOnly: false },
              magicType: {
                show: true,
                type: ["pie", "funnel"],
                option: {
                  funnel: {
                    x: "25%",
                    width: "50%",
                    funnelAlign: "left",
                    max: 1548
                  }
                }
              },
              restore: { show: true },
              saveAsImage: { show: true }
            }
          },
          calculable: true,
          graphic: [{
            type: "text",
            style: {
              text: '健康模型',
              fill: '#f00',
              x: 250,
              y: 150,
              width: 100,
              height: 200,
              fontSize: 18
            }
          },{
            type: "text",
            style: {
              text: '实际配比',
              fill: '#f00',
              x: 600,
              y: 150,
              width: 100,
              height: 200,
              fontSize: 18
            }
          },{
            type: "text",
            style: {
              text: '人员结构合理：健康',
              fill: '#0f0',
              x: 350,
              y: 550,
              width: 100,
              height: 200,
              fontSize: 18
            }
          }],
          series: [
            {
              name: "访问来源",
              type: "pie",
              radius: "25%",
              center: ["30%", "48%"],
              label: {
                //饼图图形上的文本标签
                normal: {
                  show: true,
                  // position:'inner', //标签的位置
                  textStyle: {
                    fontWeight: 300,
                    fontSize: 15, //文字的字体大小
                    color: "#fff"
                  },
                  formatter: "{b} : {c} \n ({d}%)"
                }
              },
              data: this.healthData
            },
            {
              name: "访问来源",
              type: "pie",
              radius: "25%",
            //   itemStyle: {
            //     normal:{
            //       color:['#00FFFF', '#00FF00', '#FFFF00', '#FF8C00', '#FF0000', '#FE8463']
            //     }    
            // },
              center: ["70%", "48%"],   
              label: {
                //饼图图形上的文本标签
                normal: {
                  show: true,
                  // position:'inner', //标签的位置
                  textStyle: {
                    fontWeight: 300,
                    fontSize: 15, //文字的字体大小
                    color: "#fff"
                  },
                  formatter: "{b} : {c} \n ({d}%)"
                }
              },
              data: this.realData
            } 
          ]
        });
        this.init();
        
      });
    
  }
};
</script>
