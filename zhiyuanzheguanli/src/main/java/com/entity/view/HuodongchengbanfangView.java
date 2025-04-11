package com.entity.view;

import com.entity.HuodongchengbanfangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动承办方
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huodongchengbanfang")
public class HuodongchengbanfangView extends HuodongchengbanfangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 企业行业的值
		*/
		private String huodongchengbanfangValue;



	public HuodongchengbanfangView() {

	}

	public HuodongchengbanfangView(HuodongchengbanfangEntity huodongchengbanfangEntity) {
		try {
			BeanUtils.copyProperties(this, huodongchengbanfangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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












}
