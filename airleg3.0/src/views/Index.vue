<template>
    <div id="Index">
        <div style="height: 600px">
            <el-container style="height: 600px; border: 1px solid #eee">
                <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                    <el-menu router :default-openeds="['0']">
                        <el-submenu index="0">
                            <template slot="title"><i class="el-icon-menu"></i>会员管理</template>
                            <el-menu-item index="/Manage/UserManage">查询会员</el-menu-item>
                            <el-menu-item index="/Manage/AddUser">添加会员</el-menu-item>
                            <el-menu-item index="/Manage/ShowUser">数据可视化</el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>

                <el-container style="padding: 30px">
                    <router-view></router-view>
                </el-container>
            </el-container>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>

</style>