package com.entity.model;

import com.entity.HuodongxuanchuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动宣传
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuodongxuanchuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 活动宣传名称
     */
    private String huodongxuanchuanName;


    /**
     * 活动宣传图片
     */
    private String huodongxuanchuanPhoto;


    /**
     * 活动宣传类型
     */
    private Integer huodongxuanchuanTypes;


    /**
     * 活动宣传发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 活动宣传详情
     */
    private String huodongxuanchuanContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 获取：活动宣传名称
	 */
    public String getHuodongxuanchuanName() {
        return huodongxuanchuanName;
    }


    /**
	 * 设置：活动宣传名称
	 */
    public void setHuodongxuanchuanName(String huodongxuanchuanName) {
        this.huodongxuanchuanName = huodongxuanchuanName;
    }
    /**
	 * 获取：活动宣传图片
	 */
    public String getHuodongxuanchuanPhoto() {
        return huodongxuanchuanPhoto;
    }


    /**
	 * 设置：活动宣传图片
	 */
    public void setHuodongxuanchuanPhoto(String huodongxuanchuanPhoto) {
        this.huodongxuanchuanPhoto = huodongxuanchuanPhoto;
    }
    /**
	 * 获取：活动宣传类型
	 */
    public Integer getHuodongxuanchuanTypes() {
        return huodongxuanchuanTypes;
    }


    /**
	 * 设置：活动宣传类型
	 */
    public void setHuodongxuanchuanTypes(Integer huodongxuanchuanTypes) {
        this.huodongxuanchuanTypes = huodongxuanchuanTypes;
    }
    /**
	 * 获取：活动宣传发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：活动宣传发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：活动宣传详情
	 */
    public String getHuodongxuanchuanContent() {
        return huodongxuanchuanContent;
    }


    /**
	 * 设置：活动宣传详情
	 */
    public void setHuodongxuanchuanContent(String huodongxuanchuanContent) {
        this.huodongxuanchuanContent = huodongxuanchuanContent;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
