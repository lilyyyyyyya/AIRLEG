<template>
    <div id="Service">
        <div  style="height: 600px" :style="backgroundDiv">
            <div style="height: 100px"></div>
            <el-row>
                <el-col :span="4" :offset="16">
                    <el-card :body-style="{ padding: '20px' }" style="opacity: 0.95">
                        <div style="text-align: center; padding: 10px">
                            <el-avatar
                                    :size="150"
                                    src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                        </div>
                        <div style="padding: 10px">
                            <span style="text-align: center; display:block">尊贵的会员，您好</span>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
            <div style="height: 100px"></div>
            <el-row :gutter="20">
                <el-col :span="7" :offset="5"><div class="grid-content bg-purple" style="text-align: center">
                    <el-button  icon="el-icon-location-outline" circle @click="handleClick_Place(id)"></el-button>
                    <div style="color: #FFFFFF; padding: 10px">目的地推荐</div>
                </div></el-col>
                <el-col :span="7"><div class="grid-content bg-purple" style="text-align: center">
                    <el-button icon="el-icon-goods" circle @click="handleClick_Item(id)"></el-button>
                    <div style="color: #FFFFFF; padding: 10px">商品推荐</div>
                </div></el-col>
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
                cluster: 'test',
                placeData: [{
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }, {
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }, {
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }, {
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }, {
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }, {
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }, {
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }, {
                    placeName: 'test',
                    placeUrl: require('../assets/mountain.jpeg')
                }
                ],
                itemData: [{
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }, {
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }, {
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }, {
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }, {
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }, {
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }, {
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }, {
                    itemID: 'test',
                    itemName: 'test',
                    itemPrice: 'test',
                    picUrl: require('../assets/mountain.jpeg')
                }],
                backgroundDiv: {
                    backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'non-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        methods: {
            handleClick_Place(id) {
                this.$router.push({
                    path: '/Service/Place',
                    query: {
                        id: this.id
                    }
                })
            },
            handleClick_Item(id) {
                this.$router.push({
                    path: '/Service/Item',
                    query: {
                        id: this.id
                    }
                })
            },
        },
        created() {
            if(this.$route.query.id == "undefined") {
                this.$router.push('/LogIn')
            }
        }
    }
</script>