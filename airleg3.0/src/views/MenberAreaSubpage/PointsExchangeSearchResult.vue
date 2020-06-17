<template>
    <div id="PointsExchangeSearchResult">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 30px"></div>
            <el-col :span="14" :offset="5">
                <el-card :body-style="{ padding: '18px' }" style="opacity: 0.95">
                    <div style="padding: 10px">
                        <span style="text-align: left; display:block">选择兑换的航班（仅限单程）</span>
                    </div>
                    <div style="height: 10px"></div>
                    <el-row :gutter="10">
                        <el-col :span="6" :offset="1"><div class="grid-content bg-purple">
                            <el-input
                                    placeholder="出发城市"
                                    suffix-icon="el-icon-location-outline"
                                    v-model="dep_ct">
                            </el-input>
                        </div></el-col>
                        <el-col :span="6"><div class="grid-content bg-purple">
                            <el-input
                                    placeholder="到达城市"
                                    suffix-icon="el-icon-location-outline"
                                    v-model="arr_ct">
                            </el-input>
                        </div></el-col>
                        <el-col :span="7"><div class="grid-content bg-purple">
                            <el-date-picker
                                    v-model="dep_time"
                                    type="date"
                                    placeholder="选择日期"
                                    format="yyyy-MM-dd"
                                    value-format="yyyy-MM-dd">
                            </el-date-picker>
                        </div></el-col>
                        <el-col :span="3"><div class="grid-content bg-purple">
                            <el-button type="primary" plain icon="el-icon-search"
                                       @click="handleClick(dep_ct,arr_ct,dep_time)"> 查询机票</el-button>
                        </div></el-col>
                    </el-row>
                    <div style="height: 10px"></div>
                    <el-row :gutter="10">
                        <el-col :span="22" :offset="1"><div class="grid-content bg-purple">
                            <el-table
                                    :data="tableData"
                                    style="width: 100%">
                                <el-table-column
                                        prop="flight_no"
                                        label="航班号"
                                        width="260">
                                </el-table-column>
                                <el-table-column
                                        prop="points_need"
                                        label="所需积分"
                                        width="260">
                                </el-table-column>
                                <el-table-column
                                        label="操作"
                                        width="250">
                                    <template slot-scope="scope">
                                        <el-button type="primary" plain @click="open(scope.row)"> 确认兑换</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </div></el-col>
                    </el-row>
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
        width: 180px;
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
                dep_ct: '',
                arr_ct: '',
                dep_time: '',
                backgroundDiv: {
                    backgroundImage:'url(' + require('../../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                },
                tableData: [{
                    flight_no: '1',
                    points_need: '11'
                }, {
                    flight_no: '2',
                    points_need: '22'
                }, {
                    flight_no: '3',
                    points_need: '33'
                }]
            }
        },
        activated () {
            this.mounted();
            this.select();
        },
        created() {
            // this.mounted();
            this.dep_ct = this.$route.query.depCity;
            this.arr_ct = this.$route.query.arrCity;
            this.dep_time = this.$route.query.dateValue;
            const _this = this
            axios.get("http://localhost:8181/ExchangePoints/"+this.$route.query.depCity+"/"+this.$route.query.arrCity+"/"+this.$route.query.dateValue).then(function(resp){
                console.log(resp)
                _this.tableData = resp.data
            })
        },
        mounted: function () {
            // this.id = this.$route.query.id;
            // this.dep_ct = this.$route.query.depCity;
            // this.arr_ct = this.$route.query.arrCity;
            // this.dep_time = this.$route.query.flightDate;
        },
        methods: {
            open(row) {
                const _this = this
                this.$confirm('是否确认兑换?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.get('http://localhost:8181/ExchangePoints/deductPoints/'+this.id+'/'+row.points_need).then(function(resp) {
                        if (resp.data == "success") {
                            _this.$message({
                                type: 'success',
                                message: '兑换成功!'
                            });
                        } else {
                            _this.$message({
                                type: 'error',
                                message: '兑换失败!'
                            });
                        }
                    })
                }).catch(() => {
                    _this.$message({
                        type: 'info',
                        message: '已取消兑换'
                    });
                });
            },
            handleClick(dep_ct, arr_ct, dep_time){
                this.$router.push({
                    path: '/MembersArea/PointsExchangeSearchResult',
                    query: {
                        id: this.id,
                        depCity: dep_ct,
                        arrCity: arr_ct,
                        dateValue: dep_time
                    }
                })
            }
        }

    }
</script>