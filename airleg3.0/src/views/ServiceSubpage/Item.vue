<template>
    <div id="Service">
        <div  style="height: 600px" :style="backgroundDiv">
            <div style="height: 30px"></div>
            <el-row :gutter="30">
                <el-col :span="20" :offset="2">
                    <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95">
                        <div style="padding-left: 20px">
                            <i class="el-icon-goods"> 推荐商品</i>
                        </div>
                    </el-card>
                    <div style="height: 10px"></div>
                    <el-row :gutter="30">
                        <el-col :span="6" v-for="item in itemData" :key="item" style="padding-left: 15px; padding-top: 15px">
                            <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95" shadow="hover">
                                <el-image
                                        style="height: 145px; width: 268px"
                                        :src="getImageURL(item.picURL)"
                                        fit = 'fill'></el-image>
                                <div style="text-align: center; padding:8px">
                                    <div>{{ item.itemName}}</div>
                                    <div>{{'商品价格:' + item.itemPrice}}</div>
                                </div>

                            </el-card>
                        </el-col>
                    </el-row>
                    <div style="height: 10px"></div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>


<style>

</style>

<script>
    export default {
        data() {
            return {
                id: this.$route.query.id,
                itemData: [{
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }, {
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }, {
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }, {
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }, {
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }, {
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }, {
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }, {
                    item_id: 'test',
                    item_name: 'test',
                    item_price: 'test',
                    cluster: 'test',
                    pic_url: require('../../assets/mountain.jpeg')
                }],
                backgroundDiv: {
                    backgroundImage:'url(' + require('../../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'non-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        methods: {
            getImageURL(taskImg){
                return require('@/assets/Product/'+taskImg);
            }
        },
        activated () {
            this.mounted();
            this.select();
        },
        created() {
            // this.mounted();
            const _this = this
            // this.mounted();
            axios.get("http://localhost:8181/Product/getAll/"+_this.$route.query.id).then(function(resp){
                console.log(resp)
                _this.itemData = resp.data
                // _this.itemData.pic_url = require(resp.data.picURL)
            })
        },
        mounted: function () {
            // this.id = this.$route.query.id;
        }
    }
</script>