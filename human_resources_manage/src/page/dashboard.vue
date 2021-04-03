<template lang="html">
  <div class="dashboard">
    <v-filter></v-filter>
    <div class="flex-container column">
        <div class="item one" @click="clickChart('1')" style="transform: translate(-27%,-33.5%) scale(0.33)">
          <multipleColumn></multipleColumn>
        </div>
        <div class="item two" @click="clickChart('2')" style="transform: translate(-27%,0.5%) scale(0.33)">
          <column></column>
        </div>
        <div class="item three" @click="clickChart('3')" style="transform: translate(-27%,34.5%) scale(0.33)">
          <v-line></v-line>
        </div>
        <div class="item four active" @click="clickChart('4')" style="transform: translate(38.7%, 0) scale(1)">
          <point></point>
        </div>
        <div class="item one" @click="clickChart('5')" style="transform: translate(113.4%,-33.5%) scale(0.33)">
            <sexColumn></sexColumn>
        </div>
        <div class="item two" @click="clickChart('6')" style="transform: translate(113.4%,0.5%) scale(0.33)">
            <skillColumn></skillColumn>
        </div>
        <div class="item three" @click="clickChart('7')" style="transform: translate(113.4%,34.5%) scale(0.33)">
            <warna></warna>
        </div>
    </div>
  </div>
</template>

<script>
import column from "./column";
import line from "./line";
import multipleColumn from "./multipleColumn";
import point from "./point";
import warna from "./warn1";
import sexColumn from "./sexColumn";
import skillColumn from "./skillColumn";
import filter from '../components/filter';

export default {
  data() {
    return {
      items: []
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    _resize() {
      this.$root.charts.forEach(myChart => {
        myChart.resize();
      });
    },
    init() {
      this.items = document.querySelectorAll(".flex-container .item");
      for (let i = 0; i < this.items.length; i++) {
        this.items[i].dataset.order = i + 1;
      }
    },
    clickChart(clickIndex) {
      let activeItem = document.querySelector(".flex-container .active");
      let activeIndex = activeItem.dataset.order;
      let clickItem = this.items[clickIndex - 1];
      if (activeIndex === clickIndex) {
        return;
      }
      activeItem.classList.remove("active");
      clickItem.classList.add("active");
      this._setStyle(clickItem, activeItem);
    },
    _setStyle(el1, el2) {
      let transform1 = el1.style.transform;
      let transform2 = el2.style.transform;
      el1.style.transform = transform2;
      el2.style.transform = transform1;
    },
  },
  components: {
    column,
    multipleColumn,
    point,
    "v-line": line,
    warna,
    sexColumn,
    skillColumn,
    "v-filter": filter
  },
};
</script>

<style lang="stylus" scoped>
* {
  box-sizing: border-box;
}

.point, .multipleColumn, .columnChart, .line, .warna, .sexColumn, .skillColumn{
  height: 100% !important;
  width: 100% !important;
  border: 1px solid white rgba(32, 32, 35, 0.4);
  background: url('../assets/back.png') !important;
}

.item {
  padding: 0px;
  margin: 0px;
  width: 54%;
  height: 100%;
  position: absolute;
  transform: scale(0.33);
  text-align: center;
  transition: all 0.8s;
  background: rgba(32, 32, 35, 0.5);
}

.dashboard {
  position: relative;
  width: 100%;
  height: 100%;
  margin: 0px;
  padding: 0px;
  padding-top: 20px;
  background: url('../assets/bg.jpg');
  background-size: 100% 100%;
}

.flex-container.column {
  position: relative;
  height: 95%;
  width: 100%;
  overflow: hidden;
  margin: 0 auto 20px auto;
  box-sizing: content-box;
}
.active {
  height: 100%;
  width: 56%;
  margin-left: 10px;
}
</style>
