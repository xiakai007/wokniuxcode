<template>
  <li @click="toTeacherView">
    <section class="i-teach-wrap">
      <div class="i-teach-pic">
          <img alt="" :src="headimg" style="width:140px;height:140px"/>
          <input type="hidden" :value="id">
      </div>
      <div class="mt10 hLh30 txtOf tac">
        <a class="fsize18 c-666">{{name}}</a>
        <!--<a href="" title="老谭" class="fsize18 c-666">{{name}}</a>-->
      </div>
      <div class="hLh30 txtOf tac">
        <span class="fsize14 c-999">{{education}}</span>
      </div>
      <div class="mt15 i-q-txt">
        <p class="c-999 f-fA">
          {{career}}
        </p>
      </div>
    </section>
  </li>
</template>

<script>
export default {
    props:["headimg","name","education","career","id"],
    methods:{
      toTeacherView(){
        this.$router.push({name:'viewid',query:{id:this.id}})
      }
    }
};
</script>

<style>
</style>