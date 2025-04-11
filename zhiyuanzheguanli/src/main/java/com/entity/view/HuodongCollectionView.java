package com.entity.view;

import com.entity.HuodongCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huodong_collection")
public class HuodongCollectionView extends HuodongCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String huodongCollectionValue;



		//级联表 huodong
			/**
			* 活动 的 活动承办方
			*/
			private Integer huodongHuodongchengbanfangId;
			/**
			* 活动名称
			*/
			private String huodongName;
			/**
			* 活动照片
			*/
			private String huodongPhoto;
			/**
			* 活动类型
			*/
			private Integer huodongTypes;
				/**
				* 活动类型的值
				*/
				private String huodongValue;
			/**
			* 点击次数
			*/
			private Integer huodongClicknum;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer huodongDelete;
			/**
			* 活动介绍
			*/
			private String huodongContent;

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

	public HuodongCollectionView() {

	}

	public HuodongCollectionView(HuodongCollectionEntity huodongCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, huodongCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getHuodongCollectionValue() {
				return huodongCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setHuodongCollectionValue(String huodongCollectionValue) {
				this.huodongCollectionValue = huodongCollectionValue;
			}










				//级联表的get和set huodong
					/**
					* 获取：活动 的 活动承办方
					*/
					public Integer getHuodongHuodongchengbanfangId() {
						return huodongHuodongchengbanfangId;
					}
					/**
					* 设置：活动 的 活动承办方
					*/
					public void setHuodongHuodongchengbanfangId(Integer huodongHuodongchengbanfangId) {
						this.huodongHuodongchengbanfangId = huodongHuodongchengbanfangId;
					}

					/**
					* 获取： 活动名称
					*/
					public String getHuodongName() {
						return huodongName;
					}
					/**
					* 设置： 活动名称
					*/
					public void setHuodongName(String huodongName) {
						this.huodongName = huodongName;
					}
					/**
					* 获取： 活动照片
					*/
					public String getHuodongPhoto() {
						return huodongPhoto;
					}
					/**
					* 设置： 活动照片
					*/
					public void setHuodongPhoto(String huodongPhoto) {
						this.huodongPhoto = huodongPhoto;
					}
					/**
					* 获取： 活动类型
					*/
					public Integer getHuodongTypes() {
						return huodongTypes;
					}
					/**
					* 设置： 活动类型
					*/
					public void setHuodongTypes(Integer huodongTypes) {
						this.huodongTypes = huodongTypes;
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
					* 获取： 点击次数
					*/
					public Integer getHuodongClicknum() {
						return huodongClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setHuodongClicknum(Integer huodongClicknum) {
						this.huodongClicknum = huodongClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
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
					/**
					* 获取： 逻辑删除
					*/
					public Integer getHuodongDelete() {
						return huodongDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setHuodongDelete(Integer huodongDelete) {
						this.huodongDelete = huodongDelete;
					}
					/**
					* 获取： 活动介绍
					*/
					public String getHuodongContent() {
						return huodongContent;
					}
					/**
					* 设置： 活动介绍
					*/
					public void setHuodongContent(String huodongContent) {
						this.huodongContent = huodongContent;
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



}
