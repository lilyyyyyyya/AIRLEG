<template>
    <div id="Place">
        <div  style="height: 600px" :style="backgroundDiv">
            <div style="height: 30px"></div>
            <el-row :gutter="30">
                <el-col :span="20" :offset="2">
                    <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95">
                        <div style="padding-left: 20px">
                            <i class="el-icon-location-outline"> 推荐目的地</i>
                        </div>
                    </el-card>
                    <div style="height: 10px"></div>
                    <el-row :gutter="30">
                        <el-col :span="6" v-for="place in placeData" :key="place" style="padding: 15px">
                            <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95" shadow="hover">
                                <el-image
                                        style="height: 151px; width: 268px"
                                        :src="getImageURL(place.placeURL)"
                                        fit = 'fill'></el-image>

                                <div style="text-align: center; padding:8px">
                                    <el-link :underline="false" :href="place.jumpPage">{{place.placeName}} </el-link>
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

<script>
    export default {
        data() {
            return {
                id: this.$route.query.id,
                cluster: 'test',
                placeData: [{
                    place_name: '杭州',
                    place_url: require('../../assets/hangzhou.jpg')
                }, {
                    place_name: '张家界',
                    place_url: require('../../assets/zhangjiajie.jpg')
                }, {
                    place_name: 'test',
                    place_url: require('../../assets/mountain.jpeg')
                }, {
                    place_name: 'test',
                    place_url: require('../../assets/mountain.jpeg')
                }, {
                    place_name: 'test',
                    place_url: require('../../assets/mountain.jpeg')
                }, {
                    place_name: 'test',
                    place_url: require('../../assets/mountain.jpeg')
                }, {
                    place_name: 'test',
                    place_url: require('../../assets/mountain.jpeg')
                }, {
                    place_name: 'test',
                    place_url: require('../../assets/mountain.jpeg')
                }
                ],
                backgroundDiv: {
                    backgroundImage:'url(' + require('../../assets/mountain.jpeg') + ')',
                    backgroundRepeat:'non-repeat',
                    backgroundSize:'100% 100%'
                }
            }
        },
        methods: {
            getImageURL(taskImg){
                return require('@/assets/Place/'+taskImg);
            }
        },
        activated () {
            this.mounted();
            this.select();
        },
        created() {
            const _this = this
            // this.mounted();
            axios.get("http://localhost:8181/Place/getAll").then(function(resp){
                console.log(resp)
                _this.placeData = resp.data
            })
        },
        mounted: function () {
            // this.id = this.$route.query.id;
        }
    }
</script>

<style scoped>

</style>