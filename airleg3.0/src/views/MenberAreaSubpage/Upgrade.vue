<template>
    <div id="Upgrade">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 230px"></div>
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
                }
            }
        },
        activated () {
            this.mounted();
            this.select();
        },
        created() {
            // this.mounted();
        },
        mounted: function () {
            // this.id = this.$route.query.id;
        },
        methods: {
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