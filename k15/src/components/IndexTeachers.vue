<template>
  <div>
    <section class="container">
      <header class="comm-title">
        <h2 class="tac">
          <span class="c-333">网校名师</span>
        </h2>
      </header>
      <div>
        <article class="i-teacher-list">
          <ul class="of">
            <IndexTeachersItem v-for="famousTeacher in famousTeachers"
              :key="famousTeacher.id"
              :id="famousTeacher.id"
              :headimg="famousTeacher.headimg"
              :name="famousTeacher.name"
              :education="famousTeacher.education"
              :career="famousTeacher.career"></IndexTeachersItem>
          </ul>
          <div class="clear"></div>
        </article>
        <section class="tac pt20">
          <a
            th:href="@{/teacher/list}"
            title="全部讲师"
            class="comm-btn c-btn-2"
            >全部讲师</a
          >
        </section>
      </div>
    </section>
  </div>
</template>

<script>
import IndexTeachersItem from '@/components/IndexTeachersItem'
export default {
  components:{
    IndexTeachersItem
  },
  data:function(){
    return{
      url:'/teacher/getFamousTeachers',
      famousTeachers:[]
    }
  },
  mounted(){
    this.$axios({
      method:'get',
      url:this.url,
      params:{
        isfamous:'y'
      }
    }).then(res=>{
      this.famousTeachers=res.data.data.famousTeachers
    });;
  }
};
</script>

<style>
</style>