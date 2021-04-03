<template>
  <header id="header" style="background-color:lightsteelblue">
        <section class="container">
            <h1 id="logo">
                <a href="" title="蜗牛K15在线教育">
                    <img src="../assets/img/logo.png" width="100%" alt="蜗牛K15在线教育">
                </a>
            </h1>
            <div class="h-r-nsl">
                <ul class="nav">
                    <li><a href="#" title="首页">首页</a></li>
                    <li><a href="#" title="课程">课程</a></li>
                    <li><a href="#" title="名师">名师</a></li>
                </ul>
                <!-- / nav -->
                <ul class="h-r-login">
                    <li id="no-login" v-if="!userInfo">
                        <router-link to="/login">
                            <em class="icon18 login-icon">&nbsp;</em><span class="vam ml5">登录</span>
                        </router-link>
                        <a href="#" title="注册">
                            <span class="vam ml5">注册</span>
                        </a>
                    </li>
                    <li class="mr10" id="is-login-one" v-if="userInfo">
                        <a href="" title="消息" id="headerMsgCountId">
                            <em class="icon18 news-icon">10</em>
                        </a>
                        <q class="red-point" style="display: block"></q>
                    </li>
                    <li class="h-r-user" id="is-login-two" v-if="userInfo">
                        <a href="uc" title="">
                            <img src="../assets/img/avatar-boy.gif" width="30" height="30" class="vam picImg" alt="">
                            <span class="vam disIb" id="userName"></span>
                        </a>
                        <a href="javascript:void(0)" title="退出" @click="logout()" class="ml5">退出</a>
                    </li>
                </ul>
                <aside class="h-r-search">
                    <form action="" method="post">
                        <label class="h-r-s-box"><input type="text" placeholder="输入你想学的课程" name="queryCourse.courseName"
                                                        value="">
                            <button type="submit" class="s-btn">
                                <em class="icon18">&nbsp;</em>
                            </button>
                        </label>
                    </form>
                </aside>
            </div>
            <div class="clear"></div>
        </section>
    </header>
</template>

<script>
export default {
    data:function(){
        return{
            url:'/getUserInfo',
            userInfo:null
        }
    },
    mounted(){
        this.$axios.get(this.url).then(res=>{
            this.userInfo=res.data.data.userInfo;
        });
    },
    methods:{
        logout(){
            sessionStorage.removeItem('token');
            window.location.href="/";
        }
    }
}
</script>

<style>

</style>