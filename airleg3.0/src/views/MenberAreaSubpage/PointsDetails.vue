<template>
    <div id="PointsDetails">
        <div style="height: 600px" :style="backgroundDiv">
            <div style="height: 30px"></div>
            <el-col :span="8" :offset="8">
                <el-card :body-style="{ padding: '18px' }" style="opacity: 0.95">
                    <div style="text-align: center; padding: 20px">
                        <el-avatar
                                :size="150"
                                src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                    </div>
                    <div style="padding: 10px">
                        <span style="text-align: center; display:block">尊贵的会员，您好</span>
                    </div>
                    <div class="text item">
                        <el-form label-position="left" inline class="demo-table-expand" >
                            <el-form-item label="会员卡号">
                                <span>{{member.id}}</span>
                            </el-form-item>
                            <el-form-item label="总飞行公里数（里程数）">
                                <span>{{member.seg_km_sum}}</span>
                            </el-form-item>
                            <el-form-item label="积分兑换次数">
                                <span>{{member.exchange_count}}</span>
                            </el-form-item>
                            <el-form-item label="总精英积分">
                                <span>{{member.ep_sum}}</span>
                            </el-form-item>
                            <el-form-item label="其他积分">
                                <span>{{member.add_point_sum}}</span>
                            </el-form-item>
                            <el-form-item label="总累计积分">
                                <span>{{member.points_sum}}</span>
                            </el-form-item>
                        </el-form>
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
                member: {
                    id: this.$route.query.id,
                    seg_km_sum: '',
                    exchange_count: '',
                    ep_sum: '',
                    add_point_sum: '',
                    points_sum: '',
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
            const _this = this
            axios.get('http://localhost:8181/MemberPoints/findById/'+this.$route.query.id).then(function(resp){
                _this.member = resp.data
            })
        },
        mounted: function () {
            // this.member.id = this.$route.query.id;
        }
    }
</script>