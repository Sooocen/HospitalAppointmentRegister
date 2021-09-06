<template>
    <div class="app-container">
        <el-form label-width="120px" :model="hospitalSet" :rules="rules" ref="from">
         <el-form-item label="医院名称" prop="hosname">
            <el-input v-model="hospitalSet.hosname" placeholder="请输入医院名称"/>
         </el-form-item>

         <el-form-item label="医院编号" prop="hoscode">
            <el-input v-model="hospitalSet.hoscode" placeholder="请输入医院编号"/>
         </el-form-item>

         <el-form-item label="api基础路径" prop="apiUrl">
            <el-input v-model="hospitalSet.apiUrl" placeholder="请输入api路径"/>
         </el-form-item>

         <el-form-item label="联系人姓名" prop="contactsName">
            <el-input v-model="hospitalSet.contactsName" placeholder="请输入联系人姓名"/>
         </el-form-item>
         <el-form-item label="联系人手机" prop="contactsPhone">
            <el-input v-model="hospitalSet.contactsPhone" placeholder="请输入联系人手机"/>
         </el-form-item>

         <el-form-item>
            <el-button type="primary" @click="saveOrUpdate('from')">保存</el-button>
         </el-form-item>
      </el-form>
    </div>
</template>

<script>
import hospSet from '@/api/hospSet'
export default{
    data(){
        return{
            hospitalSet:{}
            ,
            rules:{
                hosname: [
                    { required: true, message: '你什么都还填 无法提交喔', trigger: 'change' },
                    { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'change' }
                    ],
                hoscode: [
                    { required: true, message: '请输入医院编号', trigger: 'change' },
                    { min: 6, max: 8, message: '长度有误,请重新输入', trigger: 'change' }
                ],
                apiUrl:[
                    { required: true, message: '请输入医院编号', trigger: 'change' },
                    { min: 1, max: 30, message: '长度有误,请重新输入', trigger: 'change' }
                ],
                contactsName:[
                    { required: true, message: '请输入联系人姓名', trigger: "change" },
                    { min: 1, max: 10, message: '长度有误,请重新输入', trigger: 'change' }
                ],
                contactsPhone: [
                    { required: true, message: '请输入联系人电话', trigger: "change" },
                    { min: 1, max: 10, message: '长度有误,请重新输入', trigger: 'change' }
                ]
            }
        }
    },
    created(){
        //获取路由id值
      //调用接口得到医院设置信息
      if(this.$route.params && this.$route.params.id) {
         const id = this.$route.params.id
         this.getHostSet(id)
      } else {
         //表单数据清空
         this.hospitalSet = {}
      }
    },
    methods:{
        //根据id查询
        getHostSet(id) {
            hospSet.getHospitalSetByID(id) 
            .then(response => {
               this.hospitalSet = response.data
            })
      },
        saveOrUpdate(formName){
            this.$refs[formName].validate((valid) => {
            if (valid) {
                if(!this.hospitalSet.id){//没有ID值
                    this.save()
                }else{
                    this.update()
                }
            }else {
                this.$message({
                showClose: true,
                type: 'error',
                message: '提交失败,请检查信息后重新提交!'
                })
            }
            })
        },
        //添加医院设置
        save(){
            hospSet.addHospitalSet(this.hospitalSet)
            .then((resp)=>{
                //提示成功
                this.$message({
                type: 'success',
                message: '添加成功!'
                })
                //跳转回列表
                this.$router.push({path:'/hospSet/list'})
            })
            .catch((error)=>{
                console.log(error)
            })
        },
        //修改医院设置
        update(){
            hospSet.updateHospitalSet(this.hospitalSet)
            .then((resp)=>{
                //提示成功
                this.$message({
                type: 'success',
                message: '修改成功!'
                })
                //跳转回列表
                this.$router.push({path:'/hospSet/list'})
            })
            .catch((error)=>{
                console.log(error)
            })
        }
    }
}

</script>

<style scoped>

</style>