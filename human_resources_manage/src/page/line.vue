<!-- 入离职趋势图 -->
<style lang="stylus" scoped>
.line {
  height: 1000px;
  background: url('../assets/bg.jpg') no-repeat;
  color: white;
  background-size: 100% 100%;
}

.main {
  width: 100%;
  height: calc(100% - 100px);
  margin-top: 25px;
}
</style>

<template lang="html">
<div class="line">
  <v-header :name="name" :legendArr="legendArr" :myChart="myChart"></v-header>
  <!-- <v-filter :myChart="myChart" v-if="myChart._dom"></v-filter> -->
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
      name: "员工入离职趋势图"
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
    this.myChart = echarts.init(document.querySelector(".line .main"));
    axios
      .get(
        "http://10.61.180.134:8080/hr_manager/screen/get_month_entry_leave_employee?organizationID=10030377&organizationType=Department"
      )
      .then(res => {
        let month = [];
        let entryNum = [];
        let leaveNum = [];
        for (let i = 0; i < res.data.length; i++) {
          month.push(res.data[i].month);
          entryNum.push(res.data[i].entryNum);
          leaveNum.push(res.data[i].leaveNum);
        }
        this.myChart.setOption({
          title: {
            text: "入离职变化",
            subtext: "模拟",
            textStyle: {
              color: "#fa0"
            }
          },
          tooltip: {
            trigger: "axis"
          },
          legend: {
            textStyle: {
              color: "#f80"
            },
            data: ["入职人数", "离职人数"]
          },
          toolbox: {
            show: true,
            feature: {
              mark: { show: true },
              dataView: { show: true, readOnly: false },
              magicType: { show: true, type: ["line", "bar"] },
              restore: { show: true },
              saveAsImage: { show: true }
            }
          },
          calculable: true,
          xAxis: [
            {
              type: "category",
              axisLine: {
                lineStyle: {
                  color: "#fff"
                }
              },
              axisLabel: {
                textStyle: {
                  color: "#fff",
                  fontSize: "14"
                },
                formatter: "{value}"
              },
              boundaryGap: false,
              data: month
            }
          ],
          yAxis: [
            {
              type: "value",
              axisLine: {
                lineStyle: {
                  color: "#fff"
                }
              },
              axisLabel: {
                textStyle: {
                  color: "#fff",
                  fontSize: "14"
                },
                formatter: "{value}"
              }
            }
          ],
          series: [
            {
              name: "入职人数",
              type: "line",
              data: entryNum,
              markPoint: {
                data: [
                  { type: "max", name: "最大值" },
                  { type: "min", name: "最小值" }
                ]
              }
            },
            {
              name: "离职人数",
              type: "line",
              data: leaveNum,
              itemStyle: {
                normal: {
                  lineStyle: {
                    color: "#00FF00"
                  }
                }
              }
            }
          ]
        });
        this.init();
      });
  }
};
</script>
