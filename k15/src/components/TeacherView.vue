<template>
  <div>
      <Header></Header>
    <div id="aCoursesList" class="bg-fa of">
      <!-- /课程列表 开始 -->
      <section class="container">
        <header class="comm-title">
          <h2 class="fl tac">
            <span class="c-333">讲师介绍</span>
          </h2>
        </header>
        <div class="t-infor-wrap">
          <div class="fl t-infor-menu">
            <section id="t-infor-menu" class="c-tab-title">
              <p>
                <a
                  class="current"
                  name="c-desc"
                  title="讲师详情"
                  href="javascript: void(0)"
                  >讲师详情</a
                >
              </p>
              <p>
                <a title="主讲课程" name="c-course" href="javascript: void(0)"
                  >主讲课程</a
                >
              </p>
            </section>
          </div>
          <section class="fl t-infor-box c-desc-content">
            <div class="mt20 ml20">
              <section class="t-infor-pic">
                <img th:src="@{/images/teacher/2.jpg}" alt="" />
              </section>
              <h3 class="hLh30">
                <span class="fsize24 c-333">{{teacherview.name}}</span>
              </h3>
              <section class="mt10">
                <span class="t-tag-bg">{{teacherview.education}}</span>
              </section>
              <section class="t-infor-txt">
                <img src="teacherview.headimg" alt="" width="150px" height="150px">
                <p class="mt20">
                  {{teacherview.career}}
                </p>
              </section>
              <div class="clear"></div>
            </div>
          </section>
          <div class="clear"></div>
        </div>
        <section class="mt30">
          <div>
            <header class="comm-title all-teacher-title c-course-content">
              <h2 class="fl tac">
                <span class="c-333">主讲课程</span>
              </h2>
              <section class="c-tab-title">
                <a href="javascript: void(0)">&nbsp;</a>
              </section>
            </header>
            <!-- /无数据提示 开始-->
            <!-- /无数据提示 结束-->
            <article class="comm-course-list">
              <ul class="of">
                <li>
                  <div class="cc-l-wrap">
                    <section class="course-img">
                      <img
                        th:src="@{/img/default-img.gif}"
                        class="img-responsive"
                        alt=""
                      />
                      <div class="cc-mask">
                        <a
                          th:href="@{/course/view/1}"
                          title="开始学习"
                          class="comm-btn c-btn-1"
                          >开始学习</a
                        >
                      </div>
                    </section>
                    <h3 class="hLh30 txtOf mt10">
                      <a
                        href="http://127.0.0.1:82/front/couinfo/20"
                        title="C4D零基础"
                        class="course-title fsize18 c-333"
                        >{{teacherview.subject.name}}</a
                      >
                    </h3>
                  </div>
                </li>
              </ul>
              <div class="clear"></div>
            </article>
          </div>
          <!-- 公共分页 开始 -->
          <div>
            <form
              action="http://127.0.0.1:82/front/teacher/83"
              method="post"
              id="searchForm"
            >
              <input
                type="hidden"
                name="page.currentPage"
                id="pageCurrentPage"
                value="1"
              />
            </form>
            <div class="paging">
              <a href="javascript:goPage(1);" title="">首</a>
              <a
                id="backpage"
                class="undisable"
                href="javascript:void(0)"
                title=""
                >&lt;</a
              >
              <a
                id="nextpage"
                href="javascript:void(0)"
                title=""
                class="undisable"
                >&gt;</a
              >
              <a href="javascript:goPage(1);" title="">末</a>
              <div class="clear"></div>
            </div>
          </div>
          <!-- 公共分页 结束 -->
        </section>
      </section>
      <!-- /课程列表 结束 -->
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
export default {
  components: {
    Header,
    Footer
  },
  data:function(){
    return{
      url:'/teacher/getTeacherById',
      teacherview:null
    }
  },
  mounted(){
    this.$axios({
      method:"get",
      url:this.url,
      params:{
        id:this.$route.query.id
      }
    }).then(res=>{
      console.log(res.data.data.teacherView);
      this.teacherview=res.data.data.teacherView;
    });
    console.log(this.$route.query.id)
  }
};
</script>

<style>
@import url("../assets/css/reset.css");
@import url("../assets/css/global.css");
@import url("../assets/css/web.css");
@import url("../assets/css/k15.css");
</style>