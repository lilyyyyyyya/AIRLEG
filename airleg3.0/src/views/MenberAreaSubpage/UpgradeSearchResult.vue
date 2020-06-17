<template>
    <div id="UpgradeSearchResult">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 160px"></div>
            <el-col :span="10" :offset="7">
                <el-card :body-style="{ padding: '18px' }" style="opacity: 0.95">
                    <div style="padding: 5px">
                        <span style="text-align: left; display:block">选择要升舱的航班</span>
                    </div>
                    <div style="height: 10px"></div>
                    <el-row :gutter="20">
                        <el-col :span="16" :offset="1"><div class="grid-content bg-purple">
                            <el-input placeholder="航班号 例如：550" v-model="flightNumber" class="input-with-select">
                                <el-select v-model="airlineCode" slot="prepend" placeholder="航空公司代码">
                                    <el-option label="CA" value="CA"></el-option>
                                    <el-option label="CZ" value="CZ"></el-option>
                                    <el-option label="MU" value="MU"></el-option>
                                    <el-option label="MF" value="MF"></el-option>
                                    <el-option label="ZH" value="ZH"></el-option>
                                    <el-option label="3U" value="3U"></el-option>
                                    <el-option label="HU" value="HU"></el-option>
                                    <el-option label="JD" value="JD"></el-option>
                                    <el-option label="HO" value="HO"></el-option>
                                    <el-option label="9C" value="9C"></el-option>
                                    <el-option label="NH" value="NH"></el-option>
                                    <el-option label="UA" value="UA"></el-option>
                                    <el-option label="AF" value="AF"></el-option>
                                    <el-option label="BA" value="BA"></el-option>
                                </el-select>
                            </el-input>
                        </div></el-col>
                        <el-col :span="6"><div class="grid-content bg-purple">
                            <el-button type="primary" plain icon="el-icon-search" @click="handleClick(airlineCode,flightNumber)"> 查询航班</el-button>
                        </div></el-col>
                    </el-row>
                    <div style="height: 10px"></div>
                    <el-row :gutter="10">
                        <el-col :span="22" :offset="1"><div class="grid-content bg-purple">
                            <el-table
                                    :data="tableData"
                                    style="width: 100%">
                                <el-table-column
                                        prop="flightNo"
                                        label="航班号"
                                        width="200">
                                </el-table-column>
                                <el-table-column
                                        prop="mileage"
                                        label="所需里程数"
                                        width="200">
                                </el-table-column>
                                <el-table-column
                                        label="操作"
                                        width="140">
                                    <template slot-scope="scope">
                                        <el-button type="primary" plain @click="open(scope.row)"> 确认升舱</el-button>
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
</style>

<script>
    export default {
        data() {
            return {
                id: this.$route.query.id,
                airlineCode: '',
                flightNumber: '',
                flight_no: '',
                backgroundDiv: {
                    backgroundImage:'url(' + require('../../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                },
                tableData: [{
                    flight_no: this.$route.query.airlineCode + this.$route.query.flightNumber,
                    mileage: '2222'
                },{
                    flight_no: this.$route.query.airlineCode + this.$route.query.flightNumber,
                    mileage: '538'
                }]
            }
        },
        activated () {
            this.mounted();
            this.select();
        },
        created() {
            this.airlineCode = this.$route.query.airlineCode;
            this.flightNumber = this.$route.query.flightNumber;
            this.flight_no = this.$route.query.airlineCode + this.$route.query.flightNumber;
            // this.mounted();
            const _this = this
            axios.get("http://localhost:8181/MileageUpgrade/"+_this.$route.query.airlineCode + _this.$route.query.flightNumber).then(function(resp){
                console.log(resp)
                _this.tableData = resp.data
            })
        },
        mounted: function () {
            // this.id = this.$route.query.id;
            // this.airlineCode = this.$route.query.airlineCode;
            // this.flightNumber = this.$route.query.flightNumber;
            // this.flight_no = this.$route.query.airlineCode + this.$route.query.flightNumber;
        },
        methods: {
            open(row) {
                const _this = this
                this.$confirm('是否确认升舱?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.get('http://localhost:8181/MileageUpgrade/upgrade/'+this.id+'/'+row.mileage).then(function(resp) {
                        if (resp.data == "success") {
                            _this.$message({
                                type: 'success',
                                message: '升舱成功!'
                            });
                        } else {
                            _this.$message({
                                type: 'error',
                                message: '升舱失败!'
                            });
                        }
                    })
                }).catch(() => {
                    _this.$message({
                        type: 'info',
                        message: '已取消升舱'
                    });
                });
            },
            handleClick(airlineCode,flightNumber){
                this.$router.push({
                    path: '/MembersArea/UpgradeSearchResult',
                    query: {
                        id: this.id,
                        airlineCode: airlineCode,
                        flightNumber: flightNumber
                    }
                })
            }
        }
    }
</script>