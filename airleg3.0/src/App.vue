<template>
  <div id="app">
    <el-container style="height: 720px; border: 1px solid #eee">
      <el-header>
        <el-row :gutter="0" style="height: 60px">
          <el-col :span="4"><div class="grid-content bg-purple" style="height: 60px">
            <el-image
                    style="object-fit: contain; height: 60px"
                    :src="url1"></el-image>
          </div></el-col>
          <el-col :span="16"><div class="grid-content bg-purple" style="height: 60px">
            <el-menu
                    style="height: 60px"
                    :default-active="activeIndex"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleSelect"
                    background-color="#ffffff"
                    text-color="#0962b1"
                    active-text-color="#409EFF"
                    router>
              <el-menu-item style="height: 60px" :index="'/'+'?id='+this.$route.query.id">首页</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/FlightRealTime'+'?id='+this.$route.query.id">航班动态</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/FlightCheck'+'?id='+this.$route.query.id">航班查询</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/Activity'+'?id='+this.$route.query.id">今日优惠</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/MembersArea'+'?id='+this.$route.query.id">会员专区</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/Service'+'?id='+this.$route.query.id">推荐专区</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/Travel'+'?id='+this.$route.query.id">旅游出差</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/OrderCenter'+'?id='+this.$route.query.id">订单中心</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/PersonalCenter'+'?id='+this.$route.query.id">个人中心</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/LogIn'">登录</el-menu-item>
              <el-menu-item style="height: 60px" :index="'/Register'">注册</el-menu-item>
            </el-menu>
          </div></el-col>
        </el-row>
      </el-header>

      <router-view></router-view>

      <el-footer>
        Copyright © 2020 薛定谔的大腿
      </el-footer>
    </el-container>
  </div>
</template>

<style>
  .el-header {
    background-color: #FFFFFF;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-footer {
    background-color: #001848;
    color: #FFFFFF;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #ffffff;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .el-carousel__item h3 {
    color: #FFFFFF;
    font-size: 14px;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #ffffff;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #ffffff;
  }

</style>

<script>
  export default {
    data() {
      return {
        id: this.$route.query.id,
        activeIndex: '/',
        url1: require('./assets/LOGO5.png')
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
