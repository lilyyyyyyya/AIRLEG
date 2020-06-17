<template>
    <div id="AddUser">
        <div style="height: 540px">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" label-position="right" class="demo-ruleForm">
                <el-form-item label="会员卡号" prop="id" >
                    <el-input v-model="ruleForm.id"></el-input>
                </el-form-item>
                <el-form-item label="入会日期" prop="ffp_date" >
                    <el-input v-model="ruleForm.ffp_date"></el-input>
                </el-form-item>
                <el-form-item label="会员卡级别" prop="ffp_tier" >
                    <el-input v-model="ruleForm.ffp_tier"></el-input>
                </el-form-item>
                <el-form-item label="年龄" prop="age" >
                    <el-input v-model="ruleForm.age"></el-input>
                </el-form-item>
                <el-form-item label="飞行次数" prop="flight_count" >
                    <el-input v-model="ruleForm.flight_count"></el-input>
                </el-form-item>
                <el-form-item label="客户分类" prop="cluster" >
                    <el-input v-model="ruleForm.cluster"></el-input>
                </el-form-item>
                <el-form-item label="平均折扣率" prop="avg_discount" >
                    <el-input v-model="ruleForm.avg_discount"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {//用于绑定数据
                    id: '',
                    ffp_date: '',
                    ffp_tier: '',
                    age: '',
                    flight_count: '',
                    cluster: '',
                    avg_discount: ''
                },
                rules: {//用于校验数据
                    id: [
                        { required: true, message: '请输入会员卡号', trigger: 'blur' },
                    ],
                    ffp_date: [
                        { required: true, message: '请输入入会日期', trigger: 'blur' },
                    ],
                    ffp_tier: [
                        { required: true, message: '请输入会员卡级别', trigger: 'blur' },
                    ],
                    age: [
                        { required: true, message: '请输入年龄', trigger: 'blur' },
                    ],
                    flight_count: [
                        { required: true, message: '请输入飞行次数', trigger: 'blur' },
                    ],
                    cluster: [
                        { required: true, message: '请输入客户分类', trigger: 'blur' },
                    ],
                    avg_discount: [
                        { required: true, message: '请输入平均折扣率', trigger: 'blur' },
                    ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm)
                        axios.post('http://localhost:8181/Manage/save',this.ruleForm).then(function (resp) {
                            if(resp.data=="success"){
                                _this.$alert(_this.ruleForm.id+'添加成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/Manage/UserManage')
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
        text-align: center;
    }
</style>