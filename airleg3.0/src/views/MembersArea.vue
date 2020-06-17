<template>
    <div id="MembersArea">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 100px"></div>
            <el-row>
                <el-col :span="4" :offset="16">
                    <el-card :body-style="{ padding: '20px' }" style="opacity: 0.95">
                        <div style="text-align: center; padding: 10px">
                            <el-avatar
                                    :size="150"
                                    src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                        </div>
                        <div style="padding: 10px">
                            <span style="text-align: center; display:block">尊贵的会员，您好</span>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
            <div style="height: 100px"></div>
            <el-row :gutter="20">
                <el-col :span="6" :offset="3"><div class="grid-content bg-purple" style="text-align: center">
                    <el-button  icon="el-icon-s-order" circle @click="handleClick_PointsDetails(id)"></el-button>
                    <div style="color: #FFFFFF; padding: 10px">积分明细</div>
                </div></el-col>
                <el-col :span="6"><div class="grid-content bg-purple" style="text-align: center">
                    <el-button icon="el-icon-s-promotion" circle @click="handleClick_PointsExchange(id)"></el-button>
                    <div style="color: #FFFFFF; padding: 10px">积分兑换</div>
                </div></el-col>
                <el-col :span="6"><div class="grid-content bg-purple" style="text-align: center">
                    <el-button icon="el-icon-s-marketing" circle @click="handleClick_Upgrade(id)"></el-button>
                    <div style="color: #FFFFFF; padding: 10px">里程升舱</div>
                </div></el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                id: this.$route.query.id,
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        methods: {
            handleClick_PointsDetails(id) {
                this.$router.push({
                    path: '/MembersArea/PointsDetails',
                    query: {
                        id: this.id
                    }
                })
            },
            handleClick_PointsExchange(id) {
                this.$router.push({
                    path: '/MembersArea/PointsExchange',
                    query: {
                        id: this.id
                    }
                })
            },
            handleClick_Upgrade(id) {
                this.$router.push({
                    path: '/MembersArea/Upgrade',
                    query: {
                        id: this.id
                    }
                })
            }
        },
        created() {
            if(this.$route.query.id == "undefined") {
                this.$router.push('/LogIn')
            }
        }
    }
</script>

<style scoped>

</style>