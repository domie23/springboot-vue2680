<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='huodongchengbanfang'"  label='企业名称' prop="huodongchengbanfangName">
               <el-input v-model="ruleForm.huodongchengbanfangName"  placeholder='企业名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='huodongchengbanfang'"  label='企业行业' prop="huodongchengbanfangTypes">
                 <el-select v-model="ruleForm.huodongchengbanfangTypes"  placeholder='请选择企业行业'>
                     <el-option
                             v-for="(item,index) in huodongchengbanfangTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='huodongchengbanfang'"  label='企业联系方式' prop="huodongchengbanfangPhone">
               <el-input v-model="ruleForm.huodongchengbanfangPhone"  placeholder='企业联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='huodongchengbanfang'" label='企业照片' prop="huodongchengbanfangPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.huodongchengbanfangPhoto?ruleForm.huodongchengbanfangPhoto:''"
                         @change="huodongchengbanfangPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item v-if="flag=='huodongchengbanfang'"  label="企业详情" prop="huodongchengbanfangContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.huodongchengbanfangContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='tuanwei'"  label='团委名称' prop="tuanweiName">
               <el-input v-model="ruleForm.tuanweiName"  placeholder='团委名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='志愿者姓名' prop="zhiyuanzheName">
               <el-input v-model="ruleForm.zhiyuanzheName"  placeholder='志愿者姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='志愿者手机号' prop="zhiyuanzhePhone">
               <el-input v-model="ruleForm.zhiyuanzhePhone"  placeholder='志愿者手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='志愿者身份证号' prop="zhiyuanzheIdNumber">
               <el-input v-model="ruleForm.zhiyuanzheIdNumber"  placeholder='志愿者身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='zhiyuanzhe'" label='志愿者头像' prop="zhiyuanzhePhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.zhiyuanzhePhoto?ruleForm.zhiyuanzhePhoto:''"
                         @change="zhiyuanzhePhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='电子邮箱' prop="zhiyuanzheEmail">
               <el-input v-model="ruleForm.zhiyuanzheEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag =='zhiyuanzhe'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      sexTypesOptions : [],
     huodongchengbanfangTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
          this.sexTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
  });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=huodongchengbanfang_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.huodongchengbanfangTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    huodongchengbanfangPhotoUploadChange(fileUrls) {
        this.ruleForm.huodongchengbanfangPhoto = fileUrls;
    },
    zhiyuanzhePhotoUploadChange(fileUrls) {
        this.ruleForm.zhiyuanzhePhoto = fileUrls;
    },

    onUpdateHandler() {
                         if((!this.ruleForm.huodongchengbanfangName)&& 'huodongchengbanfang'==this.flag){
                             this.$message.error('企业名称不能为空');
                             return
                         }

                         if((!this.ruleForm.huodongchengbanfangTypes)&& 'huodongchengbanfang'==this.flag){
                             this.$message.error('企业行业不能为空');
                             return
                         }

                         if((!this.ruleForm.huodongchengbanfangPhone)&& 'huodongchengbanfang'==this.flag){
                             this.$message.error('企业联系方式不能为空');
                             return
                         }

                         if((!this.ruleForm.huodongchengbanfangPhoto)&& 'huodongchengbanfang'==this.flag){
                             this.$message.error('企业照片不能为空');
                             return
                         }

                         if((!this.ruleForm.huodongchengbanfangContent)&& 'huodongchengbanfang'==this.flag){
                             this.$message.error('企业详情不能为空');
                             return
                         }

                         if((!this.ruleForm.tuanweiName)&& 'tuanwei'==this.flag){
                             this.$message.error('团委名称不能为空');
                             return
                         }

                         if((!this.ruleForm.zhiyuanzheName)&& 'zhiyuanzhe'==this.flag){
                             this.$message.error('志愿者姓名不能为空');
                             return
                         }

                             if( 'zhiyuanzhe' ==this.flag && this.ruleForm.zhiyuanzhePhone&&(!isMobile(this.ruleForm.zhiyuanzhePhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.zhiyuanzheIdNumber)&& 'zhiyuanzhe'==this.flag){
                             this.$message.error('志愿者身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.zhiyuanzhePhoto)&& 'zhiyuanzhe'==this.flag){
                             this.$message.error('志愿者头像不能为空');
                             return
                         }

                             if( 'zhiyuanzhe' ==this.flag && this.ruleForm.zhiyuanzheEmail&&(!isEmail(this.ruleForm.zhiyuanzheEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes)&& this.flag =='zhiyuanzhe'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
