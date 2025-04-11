package com.entity.model;

import com.entity.HuodongchengbanfangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动承办方
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuodongchengbanfangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 企业名称
     */
    private String huodongchengbanfangName;


    /**
     * 企业行业
     */
    private Integer huodongchengbanfangTypes;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：企业名称
	 */
    public String getHuodongchengbanfangName() {
        return huodongchengbanfangName;
    }


    /**
	 * 设置：企业名称
	 */
    public void setHuodongchengbanfangName(String huodongchengbanfangName) {
        this.huodongchengbanfangName = huodongchengbanfangName;
    }
    /**
	 * 获取：企业行业
	 */
    public Integer getHuodongchengbanfangTypes() {
        return huodongchengbanfangTypes;
    }


    /**
	 * 设置：企业行业
	 */
    public void setHuodongchengbanfangTypes(Integer huodongchengbanfangTypes) {
        this.huodongchengbanfangTypes = huodongchengbanfangTypes;
    }
    /**
	 * 获取：企业联系方式
	 */
    public String getHuodongchengbanfangPhone() {
        return huodongchengbanfangPhone;
    }


    /**
	 * 设置：企业联系方式
	 */
    public void setHuodongchengbanfangPhone(String huodongchengbanfangPhone) {
        this.huodongchengbanfangPhone = huodongchengbanfangPhone;
    }
    /**
	 * 获取：企业照片
	 */
    public String getHuodongchengbanfangPhoto() {
        return huodongchengbanfangPhoto;
    }


    /**
	 * 设置：企业照片
	 */
    public void setHuodongchengbanfangPhoto(String huodongchengbanfangPhoto) {
        this.huodongchengbanfangPhoto = huodongchengbanfangPhoto;
    }
    /**
	 * 获取：企业详情
	 */
    public String getHuodongchengbanfangContent() {
        return huodongchengbanfangContent;
    }


    /**
	 * 设置：企业详情
	 */
    public void setHuodongchengbanfangContent(String huodongchengbanfangContent) {
        this.huodongchengbanfangContent = huodongchengbanfangContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
