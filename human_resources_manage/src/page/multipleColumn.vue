<template lang="html">
<div class="multipleColumn">
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
      styleArr: [],
      myChart: {},
      name: "人员备份"
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
    var multipleColumn = document.querySelector(".multipleColumn .main");
    this.myChart = echarts.init(multipleColumn);
    axios
      .get(
        "http://10.61.180.134:8080/hr_manager/screen/get_employee_backup?organizationID=10030377&organizationType=Department"
      )
      .then(res => {
        let createDate = [];
        let backupContent = [];
        let currentProgress = [];
        function getCurrentProgress(name) {
          let currentProgress = [];
          for (let i = 0; i < res.data.length; i++) {
            if (res.data[i].backupContent == name) {
              currentProgress.push(parseInt(res.data[i].currentProgress));
            }
          }
          return currentProgress;
        }
        for (let i = 0; i < res.data.length; i++) {
          if (createDate.indexOf(res.data[i].createDate) == -1) {
            createDate.push(res.data[i].createDate);
          }
          if (backupContent.indexOf(res.data[i].backupContent) == -1) {
            backupContent.push(res.data[i].backupContent);
          }
          currentProgress.push(res.data[i].currentProgress);
        }
        let series = [];
        for (let i = 0; i < backupContent.length; i++) {
          series.push({
            name: backupContent[i],
            type: "line",
            //stack: '总量',
            data: getCurrentProgress(backupContent[i])
          });
        }
        this.myChart.setOption({
          tooltip: {
            trigger: "axis"
          },
          legend: {
            textStyle: {
              color: "#D86464"
            },
            data: backupContent
          },
          toolbox: {
            show: true,
            feature: {
              mark: { show: true },
              dataView: { show: true, readOnly: false },
              magicType: {
                show: true,
                type: ["line", "bar", "stack", "tiled"]
              },
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
              data: createDate
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
                formatter: "{value}%"
              },
              boundaryGap: false
              //data : currentProgress
            }
          ],
          series: series
        });
        this.init();
      });
    
  }
};
</script>
<style lang="stylus" scoped>
.multipleColumn {
  height: 1000px;
  background: url('../assets/bg.jpg') no-repeat;
  background-size: 100% 100%;
}

.main {
  width: 100%;
  height: calc(100% - 100px);
  margin-top: 20px;
}
</style>