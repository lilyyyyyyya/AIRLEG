<template>
    <div id="PersonalCenter">
        <div style="height: 600px" :style="backgroundDiv">
            <el-row >
                <div style="height: 5px"></div>
                <el-col :span="8" :offset="8">
                    <el-card :body-style="{ padding: '18px' }" style="opacity: 0.95">
                        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="85px" label-position="right" class="demo-ruleForm" >
                            <el-form-item label="会员卡号" prop="id" >
                                <el-input v-model="ruleForm.id" readonly></el-input>
                            </el-form-item>
                            <el-form-item label="入会日期" prop="ffp_date" >
                                <el-input v-model="ruleForm.ffp_date" readonly></el-input>
                            </el-form-item>
                            <el-form-item label="会员卡级别" prop="ffp_tier" >
                                <el-input v-model="ruleForm.ffp_tier" readonly></el-input>
                            </el-form-item>
                            <el-form-item label="年龄" prop="age" >
                                <el-input v-model="ruleForm.age" readonly></el-input>
                            </el-form-item>
                            <el-form-item label="工作城市" prop="work_city" >
                                <el-input v-model="ruleForm.work_city" readonly></el-input>
                            </el-form-item>
                            <el-form-item label="工作省份" prop="work_province" >
                                <el-input v-model="ruleForm.work_province" readonly></el-input>
                            </el-form-item>
                            <el-form-item label="工作国家" prop="work_country" >
                                <el-input v-model="ruleForm.work_country" readonly></el-input>
                            </el-form-item>
                            <el-form-item label="飞行次数" prop="flight_count" >
                                <el-input v-model="ruleForm.flight_count" readonly></el-input>
                            </el-form-item>
                        </el-form>
                        <el-row>
                            <el-col :span="6" :offset="6">
                                <el-button type="primary" @click="submitForm('ruleForm')">修改信息</el-button>
                            </el-col>
                            <el-col :span="6">
                                <el-button @click="resetPassword('ruleForm')">修改密码</el-button>
                            </el-col>
                        </el-row>
                    </el-card>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {//用于绑定数据
                    id: this.$route.query.id,
                    ffp_date: '',
                    ffp_tier: '',
                    age: '',
                    work_city:'',
                    work_province:'',
                    work_country:'',
                    flight_count: '',
                },
                rules: {//用于校验数据
                },
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        methods: {
            submitForm(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm.id)
                        this.$router.push({
                            path:'/PersonalCenter/UpdateOwn',
                            query:{
                                id:this.ruleForm.id
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetPassword(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm.id)
                        this.$router.push({
                            path:'/PersonalCenter/UpdatePassword',
                            query:{
                                id:this.ruleForm.id
                            }
                        })
                    } else {
                        console.log('error!');
                        return false;
                    }
                });
            }
        },
        created() {//根据id拿数据
            console.log(this.$route.query.id)
            if(this.$route.query.id == "undefined") {
                this.$router.push('/LogIn')
            }
            const _this = this
            axios.get('http://localhost:8181/Personal/findById/?id='+this.$route.query.id).then(function(resp){
                _this.ruleForm = resp.data
            })
        },
    }
</script>

<style scoped>
    .demo-ruleForm{
        margin-top: 10px;
        text-align: center;
    }
</style>