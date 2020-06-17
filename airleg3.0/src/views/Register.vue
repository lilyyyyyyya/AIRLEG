<template>
    <div id="Register">
        <div style="height: 600px" :style="backgroundDiv">
            <el-row>
                <el-col :span="6" :offset="9">
                    <div style="height: 18px"></div>
                    <el-card :body-style="{ padding: '20px' }" style="opacity: 0.95">
                        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm" >
                            <el-form-item prop="id" >
                                <el-input placeholder="请输入用户id" v-model="ruleForm.id" clearable></el-input>
                            </el-form-item>
                            <el-form-item prop="password" >
                                <el-input placeholder="请设置密码" v-model="ruleForm.password" show-password></el-input>
                            </el-form-item>
                            <el-form-item  prop="password1" >
                                <el-input placeholder="请再次输入密码" v-model="ruleForm.password1" show-password></el-input>
                            </el-form-item>
                            <el-form-item  prop="age" >
                                <el-input placeholder="请输入年龄" v-model="ruleForm.age"></el-input>
                            </el-form-item>
                            <el-form-item  prop="work_city" >
                                <el-input placeholder="请输入工作城市" v-model="ruleForm.work_city"></el-input>
                            </el-form-item>
                            <el-form-item  prop="work_province" >
                                <el-input placeholder="请输入工作省份" v-model="ruleForm.work_province"></el-input>
                            </el-form-item>
                            <el-form-item  prop="work_country" >
                                <el-input placeholder="请输入工作国家" v-model="ruleForm.work_country"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
                                <el-button @click="resetForm('ruleForm')">重置</el-button>
                            </el-form-item>
                        </el-form>
                    </el-card>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            var validatePass = (rule, value, callback) => {
                if (!value) {
                    callback(new Error("请输入密码"));
                } else if (value.toString().length < 6 || value.toString().length > 18) {
                    callback(new Error("密码长度为6-18位"));
                } else {
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === "") {
                    callback(new Error("请再次输入密码"));
                } else if (value !== this.ruleForm.password) {
                    callback(new Error("两次输入密码不一致!"));
                } else {
                    callback();
                }
            };
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
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                },
                ruleForm: {//用于绑定数据
                    id: '',
                    password: '',
                    password1: '',
                    age:'',
                    work_city:'',
                    work_province:'',
                    work_country:'',
                },
                rules: {//用于校验数据
                    id: [
                        { required: true, message: '请输入用户id', trigger: 'blur' },
                    ],
                    password: [
                        { required: true, validator: validatePass, trigger: 'blur' },
                    ],
                    password1:[
                        { required: true, validator: validatePass2, trigger: 'blur' },
                    ],
                    age:[
                        { required: true, validator: validatePass3, trigger: 'blur' },
                    ]
                }
            }
        },
        methods:{
            submitForm(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm)
                        axios.post('http://localhost:8181/register',this.ruleForm).then(function (resp) {
                            if(resp.data=="success"){
                                _this.$alert(_this.ruleForm.id+'注册成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/login')
                                    }
                                })
                            }else if(resp.data == "error"){
                                _this.$alert(_this.ruleForm.id+'用户已存在！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/login')
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
        }
    }
</script>

<style scoped>
    .demo-ruleForm{
        text-align: center;
        margin-top: 20px;
    }
</style>