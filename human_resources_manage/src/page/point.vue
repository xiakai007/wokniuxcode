<!-- 散点图 -->
<style lang="stylus" scoped>
.point {
  background: white;
  background-size: 100% 100%;
}
.main {
  height: 600px;
  width: 100%;
  transition: all 0.5s linear;
  margin-top: 30px;
}
</style>

<template lang="html">
<div class="point">
  <v-header :name="name" :legendArr="legendArr" :myChart="myChart"></v-header>
  <!-- <v-filter v-if="myChart._dom"></v-filter> -->
  <div class="main"></div>
</div>
</template>

<script>
import axios from "axios";
import echarts from "echarts";
import china from "echarts/map/js/china";
import header from "../components/header";
import filter from '../components/filter'


const USER_NAME = "elastic";
const PSW = "elasticl@ethical.cn";
const AUTH_TOKEN = "Basic " + btoa(USER_NAME + ":" + PSW);

export default {
  created() {
    this._getCityData();
  },
  data() {
    return {
      legendArr: [],
      color: ["#325B69", "#698570", "#AE5548", "#6D9EA8", "#9CC2B0", "#C98769"],
      myChart: {},
      geoCoordMap: {},
      name: "员工分布"
    };
  },
  methods: {
    beginInit(options) {
      this.myChart = echarts.init(document.querySelector(".point .main"));
      this.myChart.setOption(options);
      this.legendArr = options.series;
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
    _getCityData() {
      axios.get("static/data/cityData.json").then(res => {
        this.geoCoordMap = res.data;
        this.$nextTick(() => {
          this._getMyChart();
        });
      });
    },
    convertData(data) {
      let res = [];
      for (let i = 0; i < 4; i++) {
        let l = data.length;
        let x = parseInt(Math.random() * l);
        let geoCoord = this.geoCoordMap[data[x].name];
        if (geoCoord) {
          res.push({
            name: data[x].name,
            value: geoCoord.concat(Math.random() * 200),
            areaNum: data[x].value
          });
        }
      }
      return res;
    },
    _getMyChart() {
      axios.get("http://10.61.180.134:8080/hr_manager/screen/get_employee_distribution?userId=9").then(res => {
          let options = {
            title: {
              show: false
            },
            tooltip: {
              trigger: "item",
              formatter: function(params) {
                return (
                  "地区：" +
                  params.data.name +
                  "</br>" +
                  "人数：" +
                  params.data.areaNum
                );
              }
            },
            legend: {
              show: false
            },
            visualMap: {
              min: 0,
              max: 200,
              bottom: 50,
              splitNumber: 5,
              inRange: {
                color: ["#255B78", "#2A7484", "#2F9696", "#3BBCB0", "#51D4EB"]
              },
              textStyle: {
                color: "#fff"
              }
            },
            geo: {
              map: "china",
              label: {
                emphasis: {
                  show: false
                }
              },
              zoom: 1,
              top: 50,
              itemStyle: {
                normal: {
                  color: "#3c4247",
                  opacity: 0.6,
                  borderColor: "rgba(255, 255, 255, 0.35)"
                },
                emphasis: {
                  color: "#2a333d"
                }
              }
            },
            series: [
              {
                name: "标签1",
                type: "scatter",
                coordinateSystem: "geo",
                symbolSize: function(val) {
                  return val[2] / 6;
                },
                label: {
                  normal: {
                    show: false
                  },
                  emphasis: {
                    show: false
                  }
                },
                itemStyle: {
                  emphasis: {
                    borderColor: "#fff",
                    borderWidth: 1
                  }
                },
                data: this.convertData(res.data)
              },
              {
                name: "标签2",
                type: "scatter",
                coordinateSystem: "geo",
                symbolSize: function(val) {
                  return val[2] / 6;
                },
                label: {
                  normal: {
                    show: false
                  },
                  emphasis: {
                    show: false
                  }
                },
                itemStyle: {
                  emphasis: {
                    borderColor: "#fff",
                    borderWidth: 1
                  }
                },
                data: this.convertData(res.data)
              },
              {
                name: "标签3",
                type: "scatter",
                coordinateSystem: "geo",
                symbolSize: function(val) {
                  return val[2] / 6;
                },
                label: {
                  normal: {
                    show: false
                  },
                  emphasis: {
                    show: false
                  }
                },
                itemStyle: {
                  emphasis: {
                    borderColor: "#fff",
                    borderWidth: 1
                  }
                },
                data: this.convertData(res.data)
              }
            ]
          };
          this.beginInit(options);
        });
    }
  },
  components: {
    "v-header": header,
    "v-filter": filter
  }
};
</script>
