<!-- 饼状图 -->
<style lang="stylus" scoped>
.sexColumn {
  height: 800px;
  background: '#fff';
  background-size: 100% 100%;
  color: white;
}

.main {
  width: 100%;
  height: calc(100% - 100px);
  margin-top: 40px;
}
</style>

<template lang="html">
<div class="sexColumn">
  <v-header :name="name" :legendArr="legendArr" :myChart="myChart"></v-header>
  <!-- <v-filter :myChart="myChart" v-if="myChart._dom"></v-filter>  -->
  <div class="main"></div>
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
      name: "员工性别占比"
    };
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
    }
  },
  components: {
    "v-header": header,
    "v-filter": filter
  },
  mounted() {
    // 基于准备好的dom，初始化echarts实例
    this.myChart = echarts.init(document.querySelector(".sexColumn .main"));
    axios
      .get(
        "http://10.61.180.134:8080/hr_manager/screen/get_sex_distribution?organizationID=IM1803717662&organizationType=ProjectTeam"
      )
      .then(res => {
        let sexName = [];
        for (let i = 0; i < res.data.length; i++) {
          sexName.push(res.data[i].name);
        }
        this.myChart.setOption({
          title: {
            text: "员工性别占比",
            subtext: "总体性别占比",
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
            y: "110",
            itemWidth: 40, // 设置图例图形的宽
            itemHeight: 20, // 设置图例图形的高
            textStyle: {
              color: "#ccc" // 图例文字颜色
            },
            //backgroundColor: '#eee',  // 设置整个图例区域背景颜色
            data: sexName
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
          series: [
            {
              name: "访问来源",
              type: "pie",
              radius: "45%",
              center: ["50%", "60%"],
              label: {
                //饼图图形上的文本标签
                normal: {
                  show: true,
                  // position:'inner', //标签的位置
                  textStyle: {
                    fontWeight: 300,
                    fontSize: 18, //文字的字体大小
                    color: "#fff"
                  },
                  formatter: "{b} : {c} \n ({d}%)"
                }
              },
              data: res.data
            }
          ]
        });
        this.init();
      });
    
  }
};
</script>
