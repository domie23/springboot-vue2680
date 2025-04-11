package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 活动宣传
 *
 * @author 
 * @email
 */
@TableName("huodongxuanchuan")
public class HuodongxuanchuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuodongxuanchuanEntity() {

	}

	public HuodongxuanchuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 活动宣传名称
     */
    @TableField(value = "huodongxuanchuan_name")

    private String huodongxuanchuanName;


    /**
     * 活动宣传图片
     */
    @TableField(value = "huodongxuanchuan_photo")

    private String huodongxuanchuanPhoto;


    /**
     * 活动宣传类型
     */
    @TableField(value = "huodongxuanchuan_types")

    private Integer huodongxuanchuanTypes;


    /**
     * 活动宣传发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 活动宣传详情
     */
    @TableField(value = "huodongxuanchuan_content")

    private String huodongxuanchuanContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：活动宣传名称
	 */
    public String getHuodongxuanchuanName() {
        return huodongxuanchuanName;
    }


    /**
	 * 获取：活动宣传名称
	 */

    public void setHuodongxuanchuanName(String huodongxuanchuanName) {
        this.huodongxuanchuanName = huodongxuanchuanName;
    }
    /**
	 * 设置：活动宣传图片
	 */
    public String getHuodongxuanchuanPhoto() {
        return huodongxuanchuanPhoto;
    }


    /**
	 * 获取：活动宣传图片
	 */

    public void setHuodongxuanchuanPhoto(String huodongxuanchuanPhoto) {
        this.huodongxuanchuanPhoto = huodongxuanchuanPhoto;
    }
    /**
	 * 设置：活动宣传类型
	 */
    public Integer getHuodongxuanchuanTypes() {
        return huodongxuanchuanTypes;
    }


    /**
	 * 获取：活动宣传类型
	 */

    public void setHuodongxuanchuanTypes(Integer huodongxuanchuanTypes) {
        this.huodongxuanchuanTypes = huodongxuanchuanTypes;
    }
    /**
	 * 设置：活动宣传发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动宣传发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：活动宣传详情
	 */
    public String getHuodongxuanchuanContent() {
        return huodongxuanchuanContent;
    }


    /**
	 * 获取：活动宣传详情
	 */

    public void setHuodongxuanchuanContent(String huodongxuanchuanContent) {
        this.huodongxuanchuanContent = huodongxuanchuanContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huodongxuanchuan{" +
            "id=" + id +
            ", huodongxuanchuanName=" + huodongxuanchuanName +
            ", huodongxuanchuanPhoto=" + huodongxuanchuanPhoto +
            ", huodongxuanchuanTypes=" + huodongxuanchuanTypes +
            ", insertTime=" + insertTime +
            ", huodongxuanchuanContent=" + huodongxuanchuanContent +
            ", createTime=" + createTime +
        "}";
    }
}
