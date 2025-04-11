package com.entity.view;

import com.entity.HuodongxuanchuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动宣传
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huodongxuanchuan")
public class HuodongxuanchuanView extends HuodongxuanchuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 活动宣传类型的值
		*/
		private String huodongxuanchuanValue;



	public HuodongxuanchuanView() {

	}

	public HuodongxuanchuanView(HuodongxuanchuanEntity huodongxuanchuanEntity) {
		try {
			BeanUtils.copyProperties(this, huodongxuanchuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 活动宣传类型的值
			*/
			public String getHuodongxuanchuanValue() {
				return huodongxuanchuanValue;
			}
			/**
			* 设置： 活动宣传类型的值
			*/
			public void setHuodongxuanchuanValue(String huodongxuanchuanValue) {
				this.huodongxuanchuanValue = huodongxuanchuanValue;
			}












}
