<template>
    <div id="PointsExchange">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 230px"></div>
            <el-col :span="14" :offset="5">
                <el-card :body-style="{ padding: '18px' }" style="opacity: 0.95">
                    <div style="padding: 5px">
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
                dep_ct: '',
                arr_ct: '',
                dep_time: '',
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