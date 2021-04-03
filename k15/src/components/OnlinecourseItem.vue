<template>
  <div>
    <li>
      <div class="cc-l-wrap">
        <section class="course-img">
          <img :src="cover" class="img-responsive" />
          <div class="cc-mask">
            <a href="#" title="开始学习" class="comm-btn c-btn-1">开始学习</a>
          </div>
        </section>
        <h3 class="hLh30 txtOf mt10">
          <a href="#" class="course-title fsize18 c-333">{{ name }}</a>
        </h3>
        <section class="mt10 hLh20 of">
          <span class="fr jgTag bg-green" v-if="isfree=='y'" style="background:green;">
            <tt class="c-fff fsize12 f-fA">免费</tt>
          </span>
          <span class="fr jgTag bg-green" v-if="isfree=='n'" style="background:red;">
            <tt class="c-fff fsize12 f-fA">付费</tt>
          </span>
          <span class="fl jgAttr c-ccc f-fA">
            <tt class="c-999 f-fA">{{ viewnum }}人浏览</tt> |
            <tt class="c-999 f-fA">{{ buynum }}人购买</tt></span
          >
        </section>
      </div>
    </li>
  </div>
</template>

<script>
export default {
  props: ["cover", "name", "viewnum", "buynum", "isfree"],
};
</script>

<style>
</style>