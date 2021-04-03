<template>
  <div>
    <section class="container" id="app">
      <header class="comm-title">
        <h2 class="tac">
          <span class="c-333">网校课程</span>
        </h2>
      </header>
      <div>
        <section class="c-tab-title">
          <!--<a href="javascript:void(0)" title="精品课程" class="fine"
            >精品课程</a
          >
          <a href="javascript:void(0)" title="最新课程" class="newest"
            >最新课程</a
          >
          <a href="javascript:void(0)" title="全部课程" class="all">全部课程</a>-->
          <router-link
            to="/fineCourses"
            :class="classA"
            @click.native="jump('fine')"
            >精品课程</router-link
          >
          <router-link
            to="/newestCourses"
            :class="classB"
            @click.native="jump('newest')"
            >最新课程</router-link
          >
          <a href="javascript:void(0)" title="全部课程" class="all">全部课程</a>
        </section>
      </div>
      <div>
        <!--网校课程部分-->
        <router-view></router-view>
        <section class="tac pt20">
          <a href="#" title="全部课程" class="comm-btn c-btn-2">全部课程</a>
        </section>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  mounted() {
    this.$router.push("/fineCourses").catch(err=>{});
  },
  data: function () {
    return {
      classA: "selectedShow",
      classB: "",
    };
  },
  methods: {
    jump(flag) {
      switch (flag) {
        case "fine":
          (this.classA = "selectedShow"),
            (this.classB = "");
          break;
        case "newest":
          (this.classA = ""),
            (this.classB = "selectedShow");
          break;
      }
    },
  },
};
</script>

<style scoped>
.selectedShow {
  border-bottom: 5px solid green;
}
</style>