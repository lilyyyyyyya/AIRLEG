<template>
  <div id="ShowUser">
    <el-container style="height: 540px">
      <el-main style="width: 1240px">
        <el-row :gutter="30">
          <el-col :span="12">
            <div id="myChart1" :style="{width: '590px', height: '500px'}"></div>
          </el-col>
          <el-col :span="12">
            <div id="myChart2" :style="{width: '590px', height: '500px'}"></div>
          </el-col>
        </el-row>
        <div style="height: 30px"></div>
        <el-row :gutter="30">
          <el-col :span="12">
            <div id="myChart3" :style="{width: '590px', height: '500px'}"></div>
          </el-col>
          <el-col :span="12">
            <div id="myChart4" :style="{width: '590px', height: '500px'}"></div>
          </el-col>
        </el-row>
        <el-row :gutter="30">
          <el-col :span="12">
            <div id="myChart5" :style="{width: '590px', height: '500px'}"></div>
          </el-col>
          <el-col :span="12">
            <div id="myChart6" :style="{width: '590px', height: '500px'}"></div>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </div>
</template>

<style scoped>
</style>

<script>
  export default {
    mounted(){
      this.drawLine();
    },
    methods: {
      drawLine(){
        // 基于准备好的dom，初始化echarts实例
        let myChart1 = this.$echarts.init(document.getElementById('myChart1'))
        // 绘制图表（饼图）
        myChart1.setOption({
          title: {
            text: '各类用户分布占比',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
          },
          legend: {
            orient: 'vertical',
            left: 'left',
            data: ['低价值客户', '一般客户', '重要挽留客户', '重要发展客户', '重要保持客户']
          },
          series: [
            {
              name: '访问来源',
              type: 'pie',
              radius: '60%',
              center: ['50%', '60%'],
              data: [
                {value: 24659, name: '低价值客户'},
                {value: 15740, name: '一般客户'},
                {value: 12125, name: '重要挽留客户'},
                {value: 4184, name: '重要发展客户'},
                {value: 5336, name: '重要保持客户'}
              ],
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        });

        // 基于准备好的dom，初始化echarts实例
        let myChart2 = this.$echarts.init(document.getElementById('myChart2'))
        // 绘制图表（雷达图）
        myChart2.setOption({
          title: {
            text: '客户大数据分类特征值分析',
            left: 'center'
          },
          tooltip: {},
          legend: {
            orient: 'vertical',
            left: 'left',
            data: ['低价值客户', '一般客户', '重要挽留客户', '重要发展客户', '重要保持客户']
          },
          radar: {
            // shape: 'circle',
            name: {
              textStyle: {
                color: '#fff',
                backgroundColor: '#999',
                borderRadius: 3,
                padding: [3, 5]
              }
            },
            indicator: [
              { name: '会员入会月数', max: 3, min:-2},
              { name: '客户最近一次乘坐公司飞机月数', max: 3, min:-2},
              { name: '客户乘坐公司飞机次数', max: 3, min:-2},
              { name: '客户累计飞行里程', max: 3, min:-2},
              { name: '客户折扣系数平均值', max: 3, min:-2}
            ]
          },
          series: [{
            name: '客户大数据分类特征值分析',
            type: 'radar',
            // areaStyle: {normal: {}},
            data: [
              {
                value: [-0.70021, -0.41489, -0.16114, -0.16096, -0.25513],
                name: '低价值客户'
              },
              {
                value: [1.160667, -0.37722, -0.08692, -0.09484, -0.1559],
                name: '一般客户'
              },
              {
                value: [-0.31368, 1.686258, -0.57402, -0.53682, -0.17333],
                name: '重要挽留客户'
              },
              {
                value: [0.051843, -0.00267, -0.2268, -0.23125, 2.191347],
                name: '重要发展客户'
              },
              {
                value: [0.483328, -0.79938, 2.483202, 2.424724, 0.30863],
                name: '重要保持客户'
              }
            ]
          }]
        });

        // 基于准备好的dom，初始化echarts实例
        let myChart3 = this.$echarts.init(document.getElementById('myChart3'))
        // 绘制图表（条形图）
        myChart3.setOption({
          title: {
            text: '各类客户平均里程数及积分',
            left: 'center'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              crossStyle: {
                color: '#999'
              }
            }
          },
          legend: {
            data: ['平均里程数', '平均积分'],
            left: 'left'
          },
          xAxis: [
            {
              type: 'category',
              data: ['低价值客户', '一般客户', '重要挽留客户', '重要发展客户', '重要保持客户'],
              axisPointer: {
                type: 'shadow'
              }
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '里程数',
              min: 0,
              max: 70000,
              interval: 7000,
              axisLabel: {
                formatter: '{value} km'
              }
            },
            {
              type: 'value',
              name: '积分',
              min: 0,
              max: 60000,
              interval: 6000,
              axisLabel: {
                formatter: '{value}'
              }
            }
          ],
          series: [
            {
              name: '平均里程数',
              type: 'bar',
              data: [13931.46944, 15325.02853, 6020.158515, 12461.78633, 68368.74794]
            },
            {
              name: '平均积分',
              type: 'bar',
              data: [8960.853117, 10201.0608, 3905.011794, 15269.69168, 55259.68909]
            }
          ]
        });

        // 基于准备好的dom，初始化echarts实例
        let myChart4 = this.$echarts.init(document.getElementById('myChart4'))
        // 绘制图表
        myChart4.setOption({
          title: {
            text: '各类客户平均折扣率',
            left: 'center'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              crossStyle: {
                color: '#999'
              }
            }
          },
          legend: {
            data: ['平均折扣率'],
            left: 'left'
          },
          xAxis: [
            {
              type: 'category',
              data: ['低价值客户', '一般客户', '重要挽留客户', '重要发展客户', '重要保持客户'],
              axisPointer: {
                type: 'shadow'
              }
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '里程数',
              min: 0.6,
              max: 1.2,
              interval: 0.06,
              axisLabel: {
                formatter: '{value}'
              }
            }
          ],
          series: [
            {
              name: '平均折扣率',
              type: 'line',
              data: [0.675100775, 0.693394282, 0.690214268, 1.127823614, 0.779217204]
            }
          ]
        });

        // 基于准备好的dom，初始化echarts实例
        let myChart5 = this.$echarts.init(document.getElementById('myChart5'))
        // 绘制图表
        myChart5.setOption({
          title: {
            text: '各类客户年龄分布',
            left: 'center'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
              type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          legend: {
            orient: 'vertical',
            left: 'right',
            data: ['0-20', '20-30', '30-40', '40-50', '50-60', '60-70', '70+']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: {
            type: 'category',
            data: ['低价值客户', '一般客户', '重要挽留客户', '重要发展客户', '重要保持客户']
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name: '0-20',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [65, 3, 38, 10, 1]
            },
            {
              name: '20-30',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [3548, 233, 1456, 219, 179]
            },
            {
              name: '30-40',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [10397, 4917, 4832, 1146, 1822]
            },
            {
              name: '40-50',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [7122, 6327, 3482, 1436, 2155]
            },
            {
              name: '50-60',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [2708, 3027, 1634, 1001, 920]
            },
            {
              name: '60-70',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [627, 833, 448, 273, 213]
            },
            {
              name: '70+',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [123, 202, 149, 59, 27]
            }
          ]
        });

        // 基于准备好的dom，初始化echarts实例
        let myChart6 = this.$echarts.init(document.getElementById('myChart6'))
        // 绘制图表
        myChart6.setOption({
          title: {
            text: '各类客户性别分布',
            left: 'center'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
              type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          legend: {
            orient: 'vertical',
            left: 'right',
            data: ['男', '女']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: {
            type: 'category',
            data: ['低价值客户', '一般客户', '重要挽留客户', '重要发展客户', '重要保持客户']
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name: '男',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [18327, 12620, 8629, 3362, 4546]
            },
            {
              name: '女',
              type: 'bar',
              stack: '总量',
              label: {
                show: true,
                position: 'insideRight'
              },
              data: [6332, 3120, 3495, 821, 789]
            }
          ]
        });
      }
    }
  }
</script>

