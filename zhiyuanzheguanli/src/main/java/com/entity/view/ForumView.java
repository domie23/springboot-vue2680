package com.entity.view;

import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 论坛
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 帖子类型的值
		*/
		private String forumValue;
		/**
		* 帖子状态的值
		*/
		private String forumStateValue;



		//级联表 huodongchengbanfang
			/**
			* 企业名称
			*/
			private String huodongchengbanfangName;
			/**
			* 企业行业
			*/
			private Integer huodongchengbanfangTypes;
				/**
				* 企业行业的值
				*/
				private String huodongchengbanfangValue;
			/**
			* 企业联系方式
			*/
			private String huodongchengbanfangPhone;
			/**
			* 企业照片
			*/
			private String huodongchengbanfangPhoto;
			/**
			* 企业详情
			*/
			private String huodongchengbanfangContent;

		//级联表 tuanwei
			/**
			* 团委名称
			*/
			private String tuanweiName;

		//级联表 zhiyuanzhe
			/**
			* 志愿者姓名
			*/
			private String zhiyuanzheName;
			/**
			* 志愿者手机号
			*/
			private String zhiyuanzhePhone;
			/**
			* 志愿者身份证号
			*/
			private String zhiyuanzheIdNumber;
			/**
			* 志愿者头像
			*/
			private String zhiyuanzhePhoto;
			/**
			* 电子邮箱
			*/
			private String zhiyuanzheEmail;

		//级联表 users
			/**
			* 用户名
			*/
			private String uusername;
			/**
			* 密码
			*/
			private String upassword;
			/**
			* 角色
			*/
			private String urole;
			/**
			* 新增时间
			*/
			private Date uaddtime;

	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 帖子类型的值
			*/
			public String getForumValue() {
				return forumValue;
			}
			/**
			* 设置： 帖子类型的值
			*/
			public void setForumValue(String forumValue) {
				this.forumValue = forumValue;
			}
			/**
			* 获取： 帖子状态的值
			*/
			public String getForumStateValue() {
				return forumStateValue;
			}
			/**
			* 设置： 帖子状态的值
			*/
			public void setForumStateValue(String forumStateValue) {
				this.forumStateValue = forumStateValue;
			}






























				//级联表的get和set huodongchengbanfang
					/**
					* 获取： 企业名称
					*/
					public String getHuodongchengbanfangName() {
						return huodongchengbanfangName;
					}
					/**
					* 设置： 企业名称
					*/
					public void setHuodongchengbanfangName(String huodongchengbanfangName) {
						this.huodongchengbanfangName = huodongchengbanfangName;
					}
					/**
					* 获取： 企业行业
					*/
					public Integer getHuodongchengbanfangTypes() {
						return huodongchengbanfangTypes;
					}
					/**
					* 设置： 企业行业
					*/
					public void setHuodongchengbanfangTypes(Integer huodongchengbanfangTypes) {
						this.huodongchengbanfangTypes = huodongchengbanfangTypes;
					}


						/**
						* 获取： 企业行业的值
						*/
						public String getHuodongchengbanfangValue() {
							return huodongchengbanfangValue;
						}
						/**
						* 设置： 企业行业的值
						*/
						public void setHuodongchengbanfangValue(String huodongchengbanfangValue) {
							this.huodongchengbanfangValue = huodongchengbanfangValue;
						}
					/**
					* 获取： 企业联系方式
					*/
					public String getHuodongchengbanfangPhone() {
						return huodongchengbanfangPhone;
					}
					/**
					* 设置： 企业联系方式
					*/
					public void setHuodongchengbanfangPhone(String huodongchengbanfangPhone) {
						this.huodongchengbanfangPhone = huodongchengbanfangPhone;
					}
					/**
					* 获取： 企业照片
					*/
					public String getHuodongchengbanfangPhoto() {
						return huodongchengbanfangPhoto;
					}
					/**
					* 设置： 企业照片
					*/
					public void setHuodongchengbanfangPhoto(String huodongchengbanfangPhoto) {
						this.huodongchengbanfangPhoto = huodongchengbanfangPhoto;
					}
					/**
					* 获取： 企业详情
					*/
					public String getHuodongchengbanfangContent() {
						return huodongchengbanfangContent;
					}
					/**
					* 设置： 企业详情
					*/
					public void setHuodongchengbanfangContent(String huodongchengbanfangContent) {
						this.huodongchengbanfangContent = huodongchengbanfangContent;
					}











				//级联表的get和set tuanwei
					/**
					* 获取： 团委名称
					*/
					public String getTuanweiName() {
						return tuanweiName;
					}
					/**
					* 设置： 团委名称
					*/
					public void setTuanweiName(String tuanweiName) {
						this.tuanweiName = tuanweiName;
					}



				//级联表的get和set zhiyuanzhe
					/**
					* 获取： 志愿者姓名
					*/
					public String getZhiyuanzheName() {
						return zhiyuanzheName;
					}
					/**
					* 设置： 志愿者姓名
					*/
					public void setZhiyuanzheName(String zhiyuanzheName) {
						this.zhiyuanzheName = zhiyuanzheName;
					}
					/**
					* 获取： 志愿者手机号
					*/
					public String getZhiyuanzhePhone() {
						return zhiyuanzhePhone;
					}
					/**
					* 设置： 志愿者手机号
					*/
					public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
						this.zhiyuanzhePhone = zhiyuanzhePhone;
					}
					/**
					* 获取： 志愿者身份证号
					*/
					public String getZhiyuanzheIdNumber() {
						return zhiyuanzheIdNumber;
					}
					/**
					* 设置： 志愿者身份证号
					*/
					public void setZhiyuanzheIdNumber(String zhiyuanzheIdNumber) {
						this.zhiyuanzheIdNumber = zhiyuanzheIdNumber;
					}
					/**
					* 获取： 志愿者头像
					*/
					public String getZhiyuanzhePhoto() {
						return zhiyuanzhePhoto;
					}
					/**
					* 设置： 志愿者头像
					*/
					public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
						this.zhiyuanzhePhoto = zhiyuanzhePhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getZhiyuanzheEmail() {
						return zhiyuanzheEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
						this.zhiyuanzheEmail = zhiyuanzheEmail;
					}








			//级联表的get和set users
					/**
					* 获取： 用户名
					*/
					public String getUusername() {
						return uusername;
					}
					/**
					* 设置： 用户名
					*/
					public void setUusername(String uusername) {
						this.uusername = uusername;
					}
					/**
					* 获取： 密码
					*/
					public String getUpassword() {
						return upassword;
					}
					/**
					* 设置： 密码
					*/
					public void setUpassword(String upassword) {
						this.upassword = upassword;
					}
					/**
					* 获取： 角色
					*/
					public String getUrole() {
						return urole;
					}
					/**
					* 设置： 角色
					*/
					public void setUrole(String urole) {
						this.urole = urole;
					}
					/**
					* 获取： 新增时间
					*/
					public Date getUaddtime() {
						return uaddtime;
					}
					/**
					* 设置： 新增时间
					*/
					public void setUaddtime(Date uaddtime) {
						this.uaddtime = uaddtime;
					}
}
