package com.entity.vo;

import com.entity.HuodongxuanchuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 活动宣传
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huodongxuanchuan")
public class HuodongxuanchuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 活动宣传详情
     */

    @TableField(value = "huodongxuanchuan_content")
    private String huodongxuanchuanContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
