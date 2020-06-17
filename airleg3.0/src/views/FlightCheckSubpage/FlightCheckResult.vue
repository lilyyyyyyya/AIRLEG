<template>
    <div id="FlightCheckResult">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 10px"></div>
            <el-col :span="8" :offset="8">
                <el-card :body-style="{ padding: '20px' }" style="opacity: 0.95">
                    <div class="text item">
                        <el-form label-position="left" inline class="demo-table-expand" >
                            <el-form-item label="航班号">
                                <span>{{Flight.flightno}}</span>
                            </el-form-item>
                            <el-form-item label="飞行状态">
                                <span>{{Flight.flight_state}}</span>
                            </el-form-item>
                            <el-form-item label="日期">
                                <span>{{Flight.date}}</span>
                            </el-form-item>
                            <el-form-item label="预计起飞时间">
                                <span>{{Flight.depscheduled}}</span>
                            </el-form-item>
                            <el-form-item label="实际起飞时间">
                                <span>{{Flight.dep_actual}}</span>
                            </el-form-item>
                            <el-form-item label="预计到达时间">
                                <span>{{Flight.arr_scheduled}}</span>
                            </el-form-item>
                            <el-form-item label="实际到达时间">
                                <span>{{Flight.arr_actual}}</span>
                            </el-form-item>
                            <el-form-item label="起飞城市">
                                <span>{{Flight.dep_ct}}</span>
                            </el-form-item>
                            <el-form-item label="起飞航站楼">
                                <span>{{Flight.dep_terminal}}</span>
                            </el-form-item>
                            <el-form-item label="到达城市">
                                <span>{{Flight.arr_ct}}</span>
                            </el-form-item>
                            <el-form-item label="到达航站楼">
                                <span>{{Flight.arr_terminal}}</span>
                            </el-form-item>

                        </el-form>
                        <el-row>
                            <el-col :span="4" :offset="10">
                                <template>
                                    <el-button type="primary"  @click="open(Flight.flightno, Flight.price)"> 购买</el-button>
                                </template>
                            </el-col>
                        </el-row>
                    </div>
                </el-card>
            </el-col>
        </div>
    </div>
</template>

<style>
    .demo-table-expand {
        font-size: 0;
    }
    .demo-table-expand label {
        width: 100px;
        color: #69758b;
    }
    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 100%;
    }

    .text {
        font-size: 14px;
    }
    .item {
        padding: 10px 0;
    }

</style>

<script>
    export default {
        data() {
            return {
                id: this.$route.query.id,
                Flight: {
                    flightno: '',
                    flight_state: '',
                    depscheduled: '',
                    dep_actual: '',
                    arr_scheduled: '',
                    arr_actual: '',
                    dep_ct: '',
                    dep_terminal: '',
                    arr_ct: '',
                    date: '',
                    arr_terminal: '',
                    price: ''
                },
                backgroundDiv: {
                    backgroundImage:'url(' + require('../../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        activated () {
            this.mounted();
            this.select();
        },
        created() {
            // this.mounted();
            this.id = this.$route.query.id
            const _this = this
            axios.get('http://localhost:8181/FlightQuery/'+this.$route.query.flightNo + "/"+ this.$route.query.flightDate).then(function(resp){
                if (resp.data == ""){
                    _this.$alert('该航班不存在！', '提示', {
                        confirmButtonText: '确定'
                    });
                    _this.$router.push("/FlightCheck")
                } else{
                    _this.Flight = resp.data
                }
                console.log(resp)
            })
        },
        mounted: function () {
            // this.id = this.$route.query.id;
            // this.Flight.flight_no = this.$route.query.flightNo;
            // this.Flight.flight_date = this.$route.query.flightDate;
        },
        methods: {
            open(flightno,price) {
                if(this.id == "undefined"){
                    this.$router.push({
                        path: '/Login'
                    })
                } else {
                    this.$router.push({
                        path: '/Buy',
                        query: {
                            id: this.id,
                            flightno: flightno,
                            price: price
                        }
                    })
                }
            }
        }
    }
</script>

