<template>
    <div id="Activity">
        <div  style="height: 600px" :style="backgroundDiv">
            <div style="height: 140px"></div>
            <el-row :gutter="100">
                <el-col :span="8" :offset="4"><div class="grid-content bg-purple">
                    <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95">
                        <img
                                :src="picURL1"
                                class="image"
                                fit = 'fill'>
                        <div style="padding: 14px;">
                            <div class="information">北京-武汉 {{flightno1}}</div>
                            <div class="information">
                                <span style="padding-right: 20px">原价：¥{{price}}</span>
                                <span style="padding-right: 20px">折扣：{{discount}}%</span>
                                <span style="padding-right: 20px">现价：¥{{getNowPrice(price,discount)}}</span>
                            </div>
                            <div class="bottom clearfix">
                                <time class="time">{{ currentDate }}</time>
                                <el-button type="text" class="button" @click="open(flightno1,getNowPrice(price,discount))">点击购买</el-button>
                            </div>
                        </div>
                    </el-card>
                </div></el-col>
                <el-col :span="8"><div class="grid-content bg-purple">
                    <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95">
                        <img
                                :src="picURL2"
                                class="image"
                                fit = 'fill'>
                        <div style="padding: 14px;">
                            <div class="information">福州-巴黎 {{flightno2}}</div>
                            <div class="information">
                                <span style="padding-right: 20px">原价：¥{{price1}}</span>
                                <span style="padding-right: 20px">折扣：{{discount}}%</span>
                                <span style="padding-right: 20px">现价：¥{{getNowPrice(price1,discount)}}</span>
                            </div>
                            <div class="bottom clearfix">
                                <time class="time">{{ currentDate }}</time>
                                <el-button type="text" class="button" @click="open(flightno2,getNowPrice(price1,discount))">点击购买</el-button>
                            </div>
                        </div>
                    </el-card>
                </div></el-col>
            </el-row>
        </div>
    </div>
</template>


<style scoped>
    .image {
        width: 100%;
        display: block;
        height: auto;
    }

    .button {
        padding: 0;
        float: left;
    }

    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }

    .information {
        margin: 2px;
        padding-bottom: 5px;
        text-align: justify;
        font-family: 微软雅黑;
        font-size: medium;
    }
</style>

<script>
    export default {
        data() {
            return {
                id: this.$route.query.id,
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'non-repeat',
                    backgroundSize:'100% 100%'
                },
                flightno1: 'CZ9378',
                flightno2: 'MF825',
                picURL1: require('../assets/BeijingToWuhan.png'),
                picURL2: require('../assets/FuzhouToParis.png'),
                discount: 50,
                price: 2000,
                price1:10000
            }
        },
        methods: {
            getImageURL(taskImg){
                return require('@/assets/Product/'+taskImg);
            },
            getNowPrice(price, discount){
                return price*discount*0.01;
            },
            open(flightno,price) {
                this.$router.push({
                    path: '/Buy',
                    query: {
                        id: this.id,
                        flightno: flightno,
                        price: price
                    }
                })
            }
        },
        activated () {
            this.mounted();
            this.select();
        },
        created() {
            // this.mounted();
            if(this.$route.query.id == "undefined") {
                this.$router.push('/LogIn')
            }
            const _this = this
            // this.mounted();
            axios.get("http://localhost:8181/Activity/getDiscount/"+_this.$route.query.id).then(function(resp){
                console.log(resp)
                _this.discount = resp.data
                // _this.itemData.pic_url = require(resp.data.picURL)
            })
        },
        mounted: function () {
            // this.id = this.$route.query.id;
        }
    }
</script>