npm <template>
    <div id="LogIn">
        <div style="height: 600px" :style="backgroundDiv">
            <el-row>
                <el-col :span="6" :offset="9">
                    <div style="height: 160px"></div>
                    <el-card :body-style="{ padding: '20px' }" style="opacity: 0.95">
                        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm" >
                            <el-form-item prop="id" >
                                <el-input placeholder="会员卡号" v-model="ruleForm.id" clearable></el-input>
                            </el-form-item>
                            <el-form-item prop="password" >
                                <el-input placeholder="密码" v-model="ruleForm.password" show-password></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
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
            return {
                ruleForm: {//用于绑定数据
                    id: '',
                    password: '',
                },
                rules: {//用于校验数据
                    id: [
                        { required: true, message: '请输入用户id', trigger: 'blur' },
                    ],
                    password: [
                        { required: true, validator: validatePass, trigger: 'blur' },
                    ]
                },
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        methods:{
            submitForm(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm)
                        //get方法
                        //判断id是不是等于特定id 等于特定id且验证成功跳转到管理员页面
                        axios.post('http://localhost:8181/login',this.ruleForm).then(function (resp) {
                            if(resp.data==="success"){
                                _this.$alert(_this.ruleForm.id+'登录成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        if(_this.ruleForm.id==="0"){
                                            _this.$router.push('/manage')
                                        }
                                        else{
                                            _this.$router.push({
                                                path:'/',
                                                query:{
                                                    id:_this.ruleForm.id
                                                }
                                            })
                                        }
                                    }
                                })
                            }
                            else if(resp.data==="no such member"){
                                _this.$alert('没有id='+_this.ruleForm.id+'的会员', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/login')
                                    }
                                })
                            }
                            else if(resp.data==="wrong password"){
                                _this.$alert('密码错误', '消息', {
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
        }
    }
</script>

<style scoped>
    .demo-ruleForm{
        margin-top: 10px;
        text-align: center;
    }
</style>