package com.entity.view;

import com.entity.HuodongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huodong")
public class HuodongView extends HuodongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 活动类型的值
		*/
		private String huodongValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



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

	public HuodongView() {

	}

	public HuodongView(HuodongEntity huodongEntity) {
		try {
			BeanUtils.copyProperties(this, huodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 活动类型的值
			*/
			public String getHuodongValue() {
				return huodongValue;
			}
			/**
			* 设置： 活动类型的值
			*/
			public void setHuodongValue(String huodongValue) {
				this.huodongValue = huodongValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
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








}
