<template>
    <div id="UpdateOwn">
        <div style="height: 600px" :style="backgroundDiv">
            <el-row>
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
                                <el-input v-model="ruleForm.age"></el-input>
                            </el-form-item>
                            <el-form-item label="工作城市" prop="work_city" >
                                <el-input v-model="ruleForm.work_city"></el-input>
                            </el-form-item>
                            <el-form-item label="工作省份" prop="work_province" >
                                <el-input v-model="ruleForm.work_province"></el-input>
                            </el-form-item>
                            <el-form-item label="工作国家" prop="work_country" >
                                <el-input v-model="ruleForm.work_country"></el-input>
                            </el-form-item>
                            <el-form-item label="飞行次数" prop="flight_count" >
                                <el-input v-model="ruleForm.flight_count" readonly></el-input>
                            </el-form-item>
                        </el-form>
                        <el-row>
                            <el-col :span="4" :offset="8">
                                <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                            </el-col>
                            <el-col :span="4">
                                <el-button @click="resetForm('ruleForm')">重置</el-button>
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
            var validatePass3 = (rule, value, callback) => {
                if (value === "") {
                    callback(new Error("请输入年龄"));
                } else if (value <0 || value >99) {
                    callback(new Error("年龄在0-99岁"));
                } else {
                    callback();
                }
            };
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
                    age: [
                        { required: true, validator: validatePass3, trigger: 'blur' },
                    ],
                },
                backgroundDiv: {
                    backgroundImage:'url(' + require('../../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm)
                        axios.put('http://localhost:8181/Personal/update',this.ruleForm).then(function (resp) {
                            if(resp.data=="success"){
                                _this.$alert(_this.ruleForm.id+'修改成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/PersonalCenter?id='+_this.$route.query.id)
                                    }
                                })
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            // alert(this.$route.query.id)
            const _this = this
            axios.get('http://localhost:8181/Personal/findById/?id='+this.$route.query.id).then(function(resp){
                _this.ruleForm = resp.data
            })
        }
    }
</script>

<style scoped>
    .demo-ruleForm{
        margin-top: 10px;
        text-align: center;
    }
</style>