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
 * 活动承办方
 *
 * @author 
 * @email
 */
@TableName("huodongchengbanfang")
public class HuodongchengbanfangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuodongchengbanfangEntity() {

	}

	public HuodongchengbanfangEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 企业名称
     */
    @TableField(value = "huodongchengbanfang_name")

    private String huodongchengbanfangName;


    /**
     * 企业行业
     */
    @TableField(value = "huodongchengbanfang_types")

    private Integer huodongchengbanfangTypes;


    /**
     * 企业联系方式
     */
    @TableField(value = "huodongchengbanfang_phone")

    private String huodongchengbanfangPhone;


    /**
     * 企业照片
     */
    @TableField(value = "huodongchengbanfang_photo")

    private String huodongchengbanfangPhoto;


    /**
     * 企业详情
     */
    @TableField(value = "huodongchengbanfang_content")

    private String huodongchengbanfangContent;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：企业名称
	 */
    public String getHuodongchengbanfangName() {
        return huodongchengbanfangName;
    }


    /**
	 * 获取：企业名称
	 */

    public void setHuodongchengbanfangName(String huodongchengbanfangName) {
        this.huodongchengbanfangName = huodongchengbanfangName;
    }
    /**
	 * 设置：企业行业
	 */
    public Integer getHuodongchengbanfangTypes() {
        return huodongchengbanfangTypes;
    }


    /**
	 * 获取：企业行业
	 */

    public void setHuodongchengbanfangTypes(Integer huodongchengbanfangTypes) {
        this.huodongchengbanfangTypes = huodongchengbanfangTypes;
    }
    /**
	 * 设置：企业联系方式
	 */
    public String getHuodongchengbanfangPhone() {
        return huodongchengbanfangPhone;
    }


    /**
	 * 获取：企业联系方式
	 */

    public void setHuodongchengbanfangPhone(String huodongchengbanfangPhone) {
        this.huodongchengbanfangPhone = huodongchengbanfangPhone;
    }
    /**
	 * 设置：企业照片
	 */
    public String getHuodongchengbanfangPhoto() {
        return huodongchengbanfangPhoto;
    }


    /**
	 * 获取：企业照片
	 */

    public void setHuodongchengbanfangPhoto(String huodongchengbanfangPhoto) {
        this.huodongchengbanfangPhoto = huodongchengbanfangPhoto;
    }
    /**
	 * 设置：企业详情
	 */
    public String getHuodongchengbanfangContent() {
        return huodongchengbanfangContent;
    }


    /**
	 * 获取：企业详情
	 */

    public void setHuodongchengbanfangContent(String huodongchengbanfangContent) {
        this.huodongchengbanfangContent = huodongchengbanfangContent;
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
        return "Huodongchengbanfang{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", huodongchengbanfangName=" + huodongchengbanfangName +
            ", huodongchengbanfangTypes=" + huodongchengbanfangTypes +
            ", huodongchengbanfangPhone=" + huodongchengbanfangPhone +
            ", huodongchengbanfangPhoto=" + huodongchengbanfangPhoto +
            ", huodongchengbanfangContent=" + huodongchengbanfangContent +
            ", createTime=" + createTime +
        "}";
    }
}
