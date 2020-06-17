<template>
    <div id="UpdateOwn">
        <div style="height: 600px" :style="backgroundDiv">
            <el-row>
                <div style="height: 120px"></div>
                <el-col :span="8" :offset="8">
                    <el-card :body-style="{ padding: '18px' }" style="opacity: 0.95">
                        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm" >
                            <el-form-item prop="oldpassword" >
                                <el-input placeholder="请输入旧密码" v-model="ruleForm.oldpassword" type="password"></el-input>
                            </el-form-item>
                            <el-form-item prop="newpassword" >
                                <el-input placeholder="请输入新密码" v-model="ruleForm.newpassword" type="password"></el-input>
                            </el-form-item>
                            <el-form-item prop="newpassword1" >
                                <el-input placeholder="请再次输入新密码" v-model="ruleForm.newpassword1" type="password"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
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
                    callback(new Error("请输入新密码"));
                } else if (value.toString().length < 6 || value.toString().length > 18) {
                    callback(new Error("密码长度为6-18位"));
                } else {
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === "") {
                    callback(new Error("请再次输入密码"));
                } else if (value !== this.ruleForm.newpassword) {
                    callback(new Error("两次输入密码不一致!"));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {//用于绑定数据
                    oldpassword: '',
                    newpassword: '',
                    newpassword1: '',
                },
                rules: {//用于校验数据
                    oldpassword: [
                        { required: true, message: '请输入原密码', trigger: 'blur' },
                    ],
                    newpassword: [
                        { required: true, validator: validatePass, trigger: 'blur' },
                    ],
                    newpassword1: [
                        { required: true, validator: validatePass2, trigger: 'blur' },
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
                        axios.put('http://localhost:8181/Personal/changePassword/'+_this.$route.query.id,this.ruleForm).then(function (resp) {
                            if(resp.data=="success"){
                                _this.$alert(_this.$route.query.id+'修改成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/PersonalCenter?id='+_this.$route.query.id)
                                    }
                                })
                            }else if(resp.data=="wrong password"){
                                _this.$alert(_this.$route.query.id+'原密码错误！', '消息', {
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
    }
</script>

<style scoped>
.demo-ruleForm{
    margin-top: 20px;
    text-align: center;
}
</style>