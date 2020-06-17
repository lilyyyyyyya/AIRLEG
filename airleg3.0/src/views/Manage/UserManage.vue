<template>
    <div id="UserManage">
        <div style="height: 540px">
            <div>
                <el-row :gutter="20">
                    <el-col :span="6" >
                        <el-input placeholder="用户ID" v-model="input1" class="input-with-select">
                            <el-button slot="append" icon="el-icon-search" @click="handleID(input1)"></el-button>
                        </el-input>
                    </el-col>
                </el-row>
            </div>
            <div style="height: 20px"></div>
            <el-table
                    :data="tableData"
                    border
                    style="width: 100%">
                <el-table-column
                        fixed
                        prop="id"
                        label="用户卡号"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="ffp_date"
                        label="入会日期"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="ffp_tier"
                        label="会员卡级别"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="age"
                        label="年龄"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="flight_count"
                        label="飞行次数"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="cluster"
                        label="客户分类"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="avg_discount"
                        label="平均折扣率"
                        width="140">
                </el-table-column>
                <el-table-column
                        fixed="right"
                        label="操作"
                        width="140">
                    <template slot-scope="scope">
                        <el-button @click="handleClick(scope.row)" type="text" size="small">修改</el-button>
                        <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div style="height: 20px"></div>
            <el-pagination
                    background
                    layout="prev, pager, next"
                    page-size="7"
                    :total="total"
                    @current-change="page">
            </el-pagination>
        </div>
    </div>
</template>




<script>
    export default {
        methods: {
            del(row){
                const _this=this
                axios.delete('http://localhost:8181/Manage/deleteById/'+row.id).then(function (res) {
                    _this.$alert('id：'+row.id+'删除成功', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                           window.location.reload()
                        }
                    });

                })

            },
            handleClick(row) {
                console.log(row);
                this.$router.push({
                    path:'/Manage/UpdateUser',
                    query:{
                        id:row.id
                    }
                })
            },
            page(currentPage){
                const _this=this
                axios.get('http://localhost:8181/Manage/findAll/'+(currentPage-1)+'/7').then(function (resp) {
                    _this.tableData=resp.data.content
                    _this.total=resp.data.totalElements
                })
            },
            handleID(id){
                const _this=this
                console.log(id);
                axios.get('http://localhost:8181/Manage/findById/'+id).then(function (resp) {
                    _this.tableData=resp.data
                })
            },
        },
        // 当页面加载时就触发
        created() {
            const _this=this
            axios.get('http://localhost:8181/Manage/findAll/0/7').then(function (resp) {
                _this.tableData=resp.data.content
                _this.total=resp.data.totalElements
                console.log(resp)
            })
        },

        data() {
            return {
                input1: '',
                input2: '',
                total:10,
                tableData: [{
                    id: '0091',
                    ffp_date: '2016-05-02',
                    ffp_tier: '高级',
                    age: '33',
                    flight_count: '32',
                    cluster: '高价值',
                    avg_discount:'10%'
                },{
                    id: '0092',
                    ffp_date: '2016-05-02',
                    ffp_tier: '高级',
                    age: '33',
                    flight_count: '32',
                    cluster: '高价值',
                    avg_discount:'10%'
                },{
                    id: '0093',
                    ffp_date: '2016-05-02',
                    ffp_tier: '高级',
                    age: '33',
                    flight_count: '32',
                    cluster: '高价值',
                    avg_discount:'10%'
                },{
                    id: '0094',
                    ffp_date: '2016-05-02',
                    ffp_tier: '高级',
                    age: '33',
                    flight_count: '32',
                    cluster: '高价值',
                    avg_discount:'10%'
                },
                ]
            }
        }
    }
</script>