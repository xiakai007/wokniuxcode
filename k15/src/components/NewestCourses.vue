<template>
  <article class="comm-course-list">
    <ul class="of" id="bna">
      <!--v-bind:key提高渲染效率-->
      <OnlinecourseItem
        v-for="course in courses"
        :key="course.id"
        :cover="course.cover"
        :name="course.name"
        :viewnum="course.viewnum"
        :buynum="course.buynum"
        :isfree="course.isfree"
      ></OnlinecourseItem>
    </ul>
    <div class="clear"></div>
  </article>
</template>

<script>
import OnlinecourseItem from "@/components/OnlinecourseItem";
export default {
  components: {
    OnlinecourseItem,
  },
  data: function () {
    return {
      url: "/course/getNewestCourses",
      courses: [],
    };
  },
  mounted() {
    this.$axios({
      method: "get",
      url: this.url,
      params: {
        isfine: "y",
      },
    }).then((res) => {
      this.courses = res.data.data.newestCourses;
    });
  },
};
</script>

<style>

</style>