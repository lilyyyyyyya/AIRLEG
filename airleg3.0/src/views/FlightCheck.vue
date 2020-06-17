<template>
    <div id="FlightCheck">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 250px"></div>
            <el-row :gutter="40">
                <el-col :span="8" :offset="4"><div class="grid-content bg-purple">
                    <el-input placeholder="航班号 例如：550" v-model="input1" class="input-with-select">
                        <el-select v-model="select" slot="prepend" placeholder="航空公司代码">
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
                <el-col :span="4"><div class="grid-content bg-purple">
                    <div class="block">
                        <el-date-picker
                                v-model="flightDate"
                                type="date"
                                placeholder="选择日期"
                                format="yyyy-MM-dd"
                                value-format="yyyy-MM-dd">
                        </el-date-picker>
                        <div style="margin: 10px"></div>
                        <el-alert
                                title="日期为出发地的当地时间"
                                type="info"
                                show-icon
                                style="height: 50px; text-align: center; opacity: 0.8"
                                :closable="false">
                        </el-alert>
                    </div>
                </div></el-col>
                <el-col :span="3" :offset="1"><div class="grid-content bg-purple">
                    <el-button type="primary" plain icon="el-icon-search" @click="handleClick(select,input1,flightDate)"> 航班查询</el-button>
                </div></el-col>
            </el-row>

        </div>
    </div>
</template>

<style>
    .el-select .el-input {
        width: 160px;
    }
    .input-with-select .el-input-group__prepend {
        background-color: #fff;
    }
</style>

<script>
    export default {
        data() {
            return {
                input1: '',
                select: '',
                flightDate: '',
                id: this.$route.query.id,
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'no-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        methods: {
            handleClick(select, input1, flightDate){
                this.$router.push({
                    path: '/FlightCheck/FlightCheckResult',
                    query: {
                        id: this.id,
                        flightNo: select + input1,
                        flightDate: flightDate
                    }
                })
            }
        }
    }
</script>
