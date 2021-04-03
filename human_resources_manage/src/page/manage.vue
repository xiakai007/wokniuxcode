<template>
  <div class="manage_page fillcontain">
    <el-row style="height: 100%;">
      <el-col :span="3" style="min-height: 100%; background-color: #324057;">
        <el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
          <!-- 用户头像 -->
          <div class="user-avator">
            <img src="../assets/img/img.jpg">
            <!-- 用户名下拉菜单 -->
            <el-dropdown class="user-name" trigger="click" @command="handleCommand">
              <span class="el-dropdown-link">
                {{username}}
                <i class="el-icon-caret-bottom"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <a @click="getPersonInfo">
                  <el-dropdown-item>个人中心</el-dropdown-item>
                </a>
				<a @click="loginOut">
                	<el-dropdown-item divided command="loginout">退出登录</el-dropdown-item>
				</a>
              </el-dropdown-menu>
            </el-dropdown>
          </div>

          <el-menu-item index="manage">
            <i class="el-icon-menu"></i>智能人力资源管理系统
          </el-menu-item>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-document"></i>IPSA员工管理
            </template>
            <el-menu-item index="adminList">批量录入</el-menu-item>
            <el-menu-item index="orderList">员工查询</el-menu-item>
            <el-menu-item index="foodList">员工信息修改</el-menu-item>
            <el-menu-item index="shopList">入离职管理</el-menu-item>
          </el-submenu>
          <el-submenu index="5">
            <template slot="title">
              <i class="el-icon-star-on"></i>系统管理
            </template>
            <el-menu-item index="adminList">用户管理</el-menu-item>
            <el-menu-item index="orderList">用户组管理</el-menu-item>
            <el-menu-item index="foodList">部门管理</el-menu-item>
          </el-submenu>
            <el-submenu index="6">
                <template slot="title">
                    <i class="el-icon-star-on"></i>部门管理
                </template>
                <el-menu-item index="Organization">部门信息展示</el-menu-item>
            </el-submenu>
          <el-submenu index="7">
            <template slot="title">
              <i class="el-icon-setting"></i>设置
            </template>
            <el-menu-item index="adminSet">管理员设置</el-menu-item>
            <!-- <el-menu-item index="sendMessage">发送通知</el-menu-item> -->
          </el-submenu>
        </el-menu>
      </el-col>
      <el-col :span="21" style="height: 100%;overflow: auto;">
        <keep-alive>
          <router-view></router-view>
        </keep-alive>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      collapse: false,
      fullscreen: false,
      name: "gangwangi"
    };
  },
  computed: {
    defaultActive: function() {
      return this.$route.path.replace("/", "");
    },
    username() {
      let username = localStorage.getItem("ms_username");
      return username ? username : this.name;
    }
  },
  methods: {
    // 用户名下拉菜单选择事件
    handleCommand(command) {
      if (command == "loginout") {
        localStorage.removeItem("ms_username");
        this.$router.push("/login");
      }
    },
    // 侧边栏折叠
    collapseChage() {
      this.collapse = !this.collapse;
      bus.$emit("collapse", this.collapse);
	},
	getPersonInfo() {
	this.$router.push("/adminSet");
	},
	loginOut() {
	this.$router.push("/");
	}
  }
};
</script>


<style lang="less" scoped>
@import "../style/mixin";
.user-avator {
  width: 40%;
  height: 130px;
  margin: 70px 0 0 25%;
}
.user-avator img {
  display: block;
  width: 80px;
  height: 80px;
  border-radius: 50%;
}
.user-name {
  margin-top: 10px;
  color: #bfcbd9;
}
.el-dropdown-link {
  color: #bfcbd9;
  cursor: pointer;
}
.el-dropdown-menu {
	border-radius: 4%;
	color:black;
}
.el-dropdown-menu__item {
	font-size:13px;
	color: #606266;
  	text-align: center;
}
</style>
