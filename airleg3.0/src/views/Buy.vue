<template>
    <div id="Buy">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 100px"></div>
            <el-row >
                <el-col :span="8" :offset="8"><div class="grid-content bg-purple">
                    <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95">
                        <div style="height: 30px"></div>
                        <el-row :gutter="0">
                            <el-col :span="20" :offset="2">
                                <el-row :gutter="0">
                                    <el-col :span="18">
                                        <div class="myText">航班号：{{flightno}}</div>
                                    </el-col>
                                    <el-col :span="6" >
                                        <div class="myText">¥{{price}} RMB</div>
                                    </el-col>
                                </el-row>
                                <el-divider></el-divider>
                                <span class="myText">支付方式：</span>
                                <el-select v-model="select" placeholder="请选择">
                                    <el-option label="支付宝" value="1"></el-option>
                                    <el-option label="微信支付" value="2"></el-option>
                                    <el-option label="网银+" value="3"></el-option>
                                    <el-option label="银联在线" value="4"></el-option>
                                    <el-option label="信用卡" value="5"></el-option>
                                </el-select>
                                <div style="height: 10px"></div>
                                <div class="myText">AirLeg ID：{{id}}</div>
                                <el-divider></el-divider>
                                <el-checkbox v-model="checked">我同意《
                                    <el-button type="text" @click="open">AirLeg用户协议</el-button>
                                    》中的条款</el-checkbox>
                                <el-row>
                                    <el-col :span="6" :offset="18">
                                        <template>
                                            <el-button type="primary"  @click="openBuy"> 确认购买</el-button>
                                        </template>
                                    </el-col>
                                </el-row>
                            </el-col>
                        </el-row>
                    </el-card>
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
                price: 0,
                flightno: '',
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                },
                select: '',
                checked: 'false'
            };
        },
        created(){
            this.id = this.$route.query.id;
            this.flightno = this.$route.query.flightno;
            this.price = this.$route.query.price;
        },
        methods: {
            open() {
                this.$alert('<div>尊敬的用户，欢迎您访问薛定谔的大腿航空公司（以下简称“AirLeg”）官方网站。</div> ' +
                    '<div>本协议是您（或称“用户”）与AirLeg之间就使用本网站服务所订立的契约。</div> ' +
                    '<div>如您对协议有任何疑问，可向AirLeg咨询。您开始登录或使用本网站，即表示您已同意本协议内容，本协议即构成对双方有约束力的法律文件。</div>' +
                    '<div style="height: 5px"></div>'+
                    '<strong>关于商品交易</strong>'+
                    '<div>1、用户可以使用本网站提供的商品交易服务，可以通过从本网站订购AirLeg或平台内经营者销售的商品和服务（统称“商品”）。</div>' +
                    '<div>2、在您下订单购买商品时，请您仔细确认所购商品的名称、价格、数量、电话、乘机人等信息。乘机人与用户本人不一致的，乘机人/用户的行为和意思表示视为用户/乘机人的行为和意思表示，用户/乘机人应对乘机人/用户的行为及意思表示的法律后果承担连带责任。</div>',
                    'AirLeg用户协议', {
                        dangerouslyUseHTMLString: true,
                        confirmButtonText: '确定',
                });
            },
            openBuy() {
                if(this.checked != 'false'){
                    this.$confirm('是否确认购买?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.$message({
                            type: 'success',
                            message: '购买成功!'
                        });
                        this.$router.push({
                            path: '/',
                            query: {
                                id: this.id
                            }
                        })
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消购买'
                        });
                    });
                } else {
                    this.$alert('请先阅读《用户协议》并勾选同意', '提示', {
                        confirmButtonText: '确定'
                    });
                }
            }
        }
    }
</script>

<style scoped>
    .myText {
        margin: 2px;
        padding-bottom: 5px;
        text-align: justify;
        font-family: 微軟正黑體;
    }
</style>