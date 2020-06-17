<template>
    <div id="FlightRealTime">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 70px"></div>
            <el-row>
                <el-col :span="18" :offset="3"><div class="grid-content bg-purple">
                    <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95">
                        <el-table
                                :data="tableData"
                                style="width: 100%">
                            <el-table-column
                                    align="center"
                                    fixed
                                    prop="FLIGHT_NO"
                                    label="航班号"
                                    width="120">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="DEP_CT"
                                    label="起飞城市"
                                    width="120">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="ARR_CT"
                                    label="到达城市"
                                    width="120">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="DEP_SCHEDULED"
                                    label="起飞时间"
                                    width="120">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="ARR_SCHEDULED"
                                    label="到达时间"
                                    width="120">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="FLIGHT_STATE"
                                    label="航班状态"
                                    width="120">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="PRICE"
                                    label="机票价格"
                                    width="120">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="DATE"
                                    label="起飞日期"
                                    width="140">
                            </el-table-column>
                            <el-table-column
                                    align="center"
                                    prop="sendTime"
                                    label="刷新时间">
                            </el-table-column>
                        </el-table>
                    </el-card>
                </div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>


<script>
    export default {
        // 当页面加载时就触发
        created() {
            const _this=this
            axios.get('http://localhost:8089/SendMsg').then(function (resp) {
                var vArray = new Array(8);
                for (var i = 0; i< 8; i++){
                    vArray[i] = JSON.parse(resp.data[i])
                    console.log(JSON.parse(resp.data[i]))
                }
                // var tmp = JSON.parse(resp.data)
                _this.tableData=vArray
                //_this.total=resp.data.totalElements
                // console.log(resp)

            })
        },
        data() {
            return {
                id: this.$route.query.id,
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                },
                tableData: [{
                    FLIGHT_NO: 'QZ1111',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },{
                    FLIGHT_NO: 'QZ2222',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },{
                    FLIGHT_NO: 'QZ3333',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },{
                    FLIGHT_NO: 'QZ4444',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },{
                    FLIGHT_NO: 'QZ5555',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },{
                    FLIGHT_NO: 'QZ6666',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },{
                    FLIGHT_NO: 'QZ7777',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },{
                    FLIGHT_NO: 'QZ8888',
                    DEP_CT: '北京',
                    ARR_CT: '深圳',
                    DEP_SCHEDULED: '1:22',
                    ARR_SCHEDULED: '21:52',
                    FLIGHT_STATE: '起飞',
                    PRICE:'2011',
                    DATE: '2020-05-06',
                    SendTime: '06:12:35'
                },
                ]
            };
        },
    }
</script>

<style scoped>

</style>