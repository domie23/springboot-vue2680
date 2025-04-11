package com.entity.model;

import com.entity.HuodongBaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuodongBaomingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 活动
     */
    private Integer huodongId;


    /**
     * 志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer huodongBaomingYesnoTypes;


    /**
     * 审核意见
     */
    private String huodongBaomingYesnoText;


    /**
     * 服务时数(小时)
     */
    private Integer fuwuNumber;


    /**
     * 评定结果
     */
    private Integer huodongBaomingPingdingTypes;


    /**
     * 评定意见
     */
    private String huodongBaomingPingdingText;


    /**
     * 创建时间 show3 photoShow
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
	 * 获取：活动
	 */
    public Integer getHuodongId() {
        return huodongId;
    }


    /**
	 * 设置：活动
	 */
    public void setHuodongId(Integer huodongId) {
        this.huodongId = huodongId;
    }
    /**
	 * 获取：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 设置：志愿者
	 */
    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 获取：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：报名时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getHuodongBaomingYesnoTypes() {
        return huodongBaomingYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setHuodongBaomingYesnoTypes(Integer huodongBaomingYesnoTypes) {
        this.huodongBaomingYesnoTypes = huodongBaomingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getHuodongBaomingYesnoText() {
        return huodongBaomingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setHuodongBaomingYesnoText(String huodongBaomingYesnoText) {
        this.huodongBaomingYesnoText = huodongBaomingYesnoText;
    }
    /**
	 * 获取：服务时数(小时)
	 */
    public Integer getFuwuNumber() {
        return fuwuNumber;
    }


    /**
	 * 设置：服务时数(小时)
	 */
    public void setFuwuNumber(Integer fuwuNumber) {
        this.fuwuNumber = fuwuNumber;
    }
    /**
	 * 获取：评定结果
	 */
    public Integer getHuodongBaomingPingdingTypes() {
        return huodongBaomingPingdingTypes;
    }


    /**
	 * 设置：评定结果
	 */
    public void setHuodongBaomingPingdingTypes(Integer huodongBaomingPingdingTypes) {
        this.huodongBaomingPingdingTypes = huodongBaomingPingdingTypes;
    }
    /**
	 * 获取：评定意见
	 */
    public String getHuodongBaomingPingdingText() {
        return huodongBaomingPingdingText;
    }


    /**
	 * 设置：评定意见
	 */
    public void setHuodongBaomingPingdingText(String huodongBaomingPingdingText) {
        this.huodongBaomingPingdingText = huodongBaomingPingdingText;
    }
    /**
	 * 获取：创建时间 show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
