<template>
  <div>
    <Header></Header>
    <div id="reg-div" class="bg-fa of">
      <div class="mt10"><p class="e-l-jy"></p></div>
      <form action="#" method="post">
        <div>
          <ol class="e-login-options">
            <li>
              <input
                id="u-account-reg"
                type="text"
                placeholder="请输入账号"
                v-model="loginVo.account"
              />
            </li>
            <br />
            <li>
              <input
                id="u-password-reg"
                type="password"
                placeholder="请输入密码"
                v-model="loginVo.password"
              />
              <p class="lr-tip-wrap"></p>
            </li>
          </ol>
          <section class="mt20 tac">
            <input
              type="button"
              class="e-login-btn"
              value="登 录"
              @click="login"
            />
          </section>
        </div>
      </form>
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
    Footer,
  },
  data:function(){
      return{
          loginVo:{
              account:'',
              password:''
          },
          url:'/login'
      }
  },
  methods:{
      login(){
          this.$axios.post(this.url,this.loginVo).then(res=>{
              let token=res.data.data.token;
              if(token!=null){
                  sessionStorage.setItem('token',token);
                  /*//跳转前台首页
                  window.location.href="/";*/
                  //跳转前台首页
                  this.$router.push('/');
              }
          });
      }
  }
};
</script>

<style>
@import url("../assets/css/reset.css");
@import url("../assets/css/global.css");
@import url("../assets/css/web.css");
@import url("../assets/css/k15.css");
</style>