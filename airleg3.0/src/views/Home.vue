<template>
  <div id="Home">
    <div style="height: 600px" :style="backgroundDiv">
      <div style="height: 50px"></div>
      <el-row >
        <el-col :span="8" :offset="8"><div class="grid-content bg-purple">
          <el-card :body-style="{ padding: '10px' }" style="opacity: 0.95">
            <div style="padding-left: 10px">
              <i class="el-icon-discover"> 旅客须知</i>
            </div>
          </el-card>
          <div style="height: 15px"></div>
          <el-card :body-style="{ padding: '18px' }" style="opacity: 0.95">
            <div class="information">
              尊敬的旅客：
            </div>
            <div class="information">
              欢迎您乘坐薛定谔的大腿航空股份有限公司（简称“我们”）航班。我们竭诚为您的旅行提供温馨提示，请您在旅行定座前阅读以下须知。
            </div>
            <el-collapse v-model="activeName" accordion>
              <el-collapse-item title="税款和费用" name="1">
                <div>政府或其他有关当局或机场经营人，因向旅客提供服务设施而按规定征收的税款或收取的费用不包括在适用票价之内，该项税款或费用应由您支付。</div>
              </el-collapse-item>
              <el-collapse-item title="免费托运行李额" name="2">
                <div>您的托运行李重量每件不能超过 50 千克，体积不应小于5 ×15 × 20厘米（cm），不得超过40 × 60 × 100厘米（cm），超过上述规定的行李，须事先征得我们同意后方能托运。</div>
              </el-collapse-item>
              <el-collapse-item title="逾重行李费" name="3">
                <div>逾重行李收费标准为每千克按当日所适用航线的单程直达成人经济舱公布票价的1.5%， 收费总金额以人民币元为单位，小数点保留至个位，尾数四舍五入。</div>
              </el-collapse-item>
              <el-collapse-item title="安全检查" name="4">
                <div>根据政府部门规定，乘机前，您以及您的托运行李和非托运行李必须经过安全检查。</div>
              </el-collapse-item>
              <el-collapse-item title="客票变更" name="5">
                <div>您购票后，如果要求变更航班、日期、舱位等级，请尽早通知我们，我们会按您所购客票的票价使用条件予以办理。如果您以折扣价格购买的客票，在办理变更手续时，您要求变更的航班可能没有与您所持客票相同折扣价格的座位，您除支付变更费外还应支付票价差额。</div>
              </el-collapse-item>
            </el-collapse>
          </el-card>
        </div></el-col>
      </el-row>
    </div>
  </div>
</template>

<style scoped>
  .information {
    margin: 2px;
    padding-bottom: 5px;
    text-align: justify;
    font-family: 微軟正黑體;
    font-size: 14px;
  }
</style>

<script>
  export default {
    data() {
      return {
        id: this.$route.query.id,
        backgroundDiv: {
          backgroundImage:'url(' + require('../assets/mountain.jpeg') + ')',
          backgroundRepeat:'no-repeat',
          backgroundSize:'100% 100%'
        },
        activeName: '1'
      };
    },
    activated () {
      this.mounted();
      this.select();
    },
    created() {
      //this.mounted();
      //window.location.reload();
      this.id = this.$route.query.id;
    },
    mounted: function () {
      //this.id = this.$route.query.id;
    }
  }
</script>

