<template>
    <div id="Travel">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 80px"></div>
            <el-row >
                <el-col :span="8" :offset="8"><div class="grid-content bg-purple">
                    <el-tabs type="border-card" style="opacity: 0.95" stretch="true">
                        <el-tab-pane>
                            <span slot="label"><i class="el-icon-position"></i> 热门机场</span>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="http://www.bcia.com.cn/">北京首都国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="https://www.bdia.com.cn/#/">北京大兴国际机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="https://www.shanghaiairport.com/index_hqjc.html">上海虹桥国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="https://www.shanghaiairport.com/index_pdjc.html">上海浦东国际机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="http://www.cdairport.com/">成都双流国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="https://www.gbiac.net/byairport-web/index">广州白云国际机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="http://www.hzairport.com/">杭州萧山国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="http://www.whairport.com/">武汉天河国际机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="http://www.szairport.com/">深圳宝安国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="http://www.sanyaairport.com/">三亚凤凰国际机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="http://www.qdairport.com/">青岛流亭国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="http://csa.hnjcjt.com/">长沙黄花国际机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="http://www.xxia.com/index.jsp">西安咸阳国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="https://www.hongkongairport.com/sc/">香港国际机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 10px"></div>
                            <el-row :gutter="20">
                                <el-col :span="10" :offset="2"><div class="grid-content bg-purple">
                                    <el-link href="https://www.macau-airport.com/">澳门国际机场</el-link>
                                </div></el-col>
                                <el-col :span="10"><div class="grid-content bg-purple">
                                    <el-link href="https://www.taoyuan-airport.com/main_ch/index.aspx">台湾桃园机场</el-link>
                                </div></el-col>
                            </el-row>
                            <div style="height: 20px"></div>
                        </el-tab-pane>
                        <el-tab-pane>
                            <span slot="label"><i class="el-icon-office-building"></i> 目的地酒店</span>
                            <div style="height: 10px"></div>
                            <el-row :gutter="0">
                                <el-col :span="20" :offset="2"><div class="grid-content bg-purple">
                                    <div class="sub-title">目的地</div>
                                    <el-input
                                            placeholder="目的地"
                                            suffix-icon="el-icon-location-outline"
                                            v-model="arr_ct">
                                    </el-input>
                                    <div style="height: 10px"></div>
                                    <div class="sub-title">入住日期</div>
                                    <el-date-picker
                                            v-model="checkin_time"
                                            type="date"
                                            placeholder="选择入住日期"
                                            format="yyyy-MM-dd"
                                            value-format="yyyy-MM-dd">
                                    </el-date-picker>
                                    <div style="height: 10px"></div>
                                    <div class="sub-title">退房日期</div>
                                    <el-date-picker
                                            v-model="checkout_time"
                                            type="date"
                                            placeholder="选择退房日期"
                                            format="yyyy-MM-dd"
                                            value-format="yyyy-MM-dd">
                                    </el-date-picker>
                                    <div style="height: 10px"></div>
                                    <div style="color: brown">即时确认 24小时客服 0手续费</div>
                                    <div style="height: 10px"></div>
                                    <div style="color: darkgrey">订单提交成功后，系统同步需几分钟时间，请稍等片刻再次查询</div>
                                    <div style="height: 10px"></div>
                                </div></el-col>
                            </el-row>
                            <el-row :gutter="10">
                                <el-col :span="14" :offset="2"><div class="grid-content bg-purple">
                                    <el-image
                                            style="width: 130px; height: 35px"
                                            :src="url">
                                    </el-image>
                                </div></el-col>
                                <el-col :span="6"><div class="grid-content bg-purple">
                                    <el-button type="primary" icon="el-icon-search"
                                               @click="handleHotel(arr_ct, checkin_time, checkout_time)"> 查询酒店</el-button>
                                </div></el-col>
                            </el-row>
                        </el-tab-pane>
                    </el-tabs>
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
                arr_ct: '',
                checkin_time: '',
                checkout_time: '',
                url: require('../assets/bookingIMG.png'),
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                },
                activeName: '1'
            };
        },
        methods: {
            handleHotel(ct, checkin, checkout) {
                var hotelURL = "https://www.booking.com/searchresults.html?aid=842219"
                var checkinMonthday = checkin.substr(8,2)
                var checkinYearMonth = checkin.substr(0,7)
                var checkoutMonthday = checkout.substr(8,2)
                var checkoutYearMonth = checkout.substr(0,7)
                hotelURL += ("&checkin_monthday=" + checkinMonthday)
                hotelURL += ("&checkin_year_month=" + checkinYearMonth)
                hotelURL += ("&checkout_monthday=" + checkoutMonthday)
                hotelURL += ("&checkout_year_month=" + checkoutYearMonth)
                hotelURL += "&ctoken=WNSKqe6bLVK49Ejw1A_mgdLocHiyQmLikoiDFBdSDxW6eb4vfQ2U2jxVCLgP3sFxQaXngfYq10vKzVa7zptyK1kqfqYY0ShXEJS2pUcAfLt-bMmFiCZJCV2T-BsyTY-nKFWdPmfcT_73c6Tdhx6EsWGwFWkkBJcWfEWDFdH-HMHU5HwZTxGixr7ydFTSnYi4NgivnVFoev911t3St7NDc3xEa43IdCF5Z8gOjPhcrZ6dP82QIFoLsDhFNimR-VTE_WvS8WlnWKvEl_kQ24Pt-JwoJ6zdRMGuALl_4tSwTBbR6qcKo0uaQLJqxUGyZM4A0hInXfgWDWsOp-ocdGmGY_3Mn81mLw9nfVvXNWDGUEalrOsRnWKFkUl_BdO9A348LIAbQrikxDPNEgp5xZiTUpzYyQNW_06k78nyBQ"
                hotelURL += ("&label=" + ct)
                hotelURL += ("&si=ci&ss=" + ct)
                window.location.href = hotelURL
            }
        }
    }
</script>

<style scoped>

</style>