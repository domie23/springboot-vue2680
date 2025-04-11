package com.entity.vo;

import com.entity.HuodongchengbanfangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 活动承办方
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huodongchengbanfang")
public class HuodongchengbanfangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
