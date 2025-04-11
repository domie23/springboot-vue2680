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
 * 活动报名
 *
 * @author 
 * @email
 */
@TableName("huodong_baoming")
public class HuodongBaomingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuodongBaomingEntity() {

	}

	public HuodongBaomingEntity(T t) {
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
     * 活动
     */
    @TableField(value = "huodong_id")

    private Integer huodongId;


    /**
     * 志愿者
     */
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核状态
     */
    @TableField(value = "huodong_baoming_yesno_types")

    private Integer huodongBaomingYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "huodong_baoming_yesno_text")

    private String huodongBaomingYesnoText;


    /**
     * 服务时数(小时)
     */
    @TableField(value = "fuwu_number")

    private Integer fuwuNumber;


    /**
     * 评定结果
     */
    @TableField(value = "huodong_baoming_pingding_types")

    private Integer huodongBaomingPingdingTypes;


    /**
     * 评定意见
     */
    @TableField(value = "huodong_baoming_pingding_text")

    private String huodongBaomingPingdingText;


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
	 * 设置：活动
	 */
    public Integer getHuodongId() {
        return huodongId;
    }


    /**
	 * 获取：活动
	 */

    public void setHuodongId(Integer huodongId) {
        this.huodongId = huodongId;
    }
    /**
	 * 设置：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 获取：志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 设置：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getHuodongBaomingYesnoTypes() {
        return huodongBaomingYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setHuodongBaomingYesnoTypes(Integer huodongBaomingYesnoTypes) {
        this.huodongBaomingYesnoTypes = huodongBaomingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getHuodongBaomingYesnoText() {
        return huodongBaomingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setHuodongBaomingYesnoText(String huodongBaomingYesnoText) {
        this.huodongBaomingYesnoText = huodongBaomingYesnoText;
    }
    /**
	 * 设置：服务时数(小时)
	 */
    public Integer getFuwuNumber() {
        return fuwuNumber;
    }


    /**
	 * 获取：服务时数(小时)
	 */

    public void setFuwuNumber(Integer fuwuNumber) {
        this.fuwuNumber = fuwuNumber;
    }
    /**
	 * 设置：评定结果
	 */
    public Integer getHuodongBaomingPingdingTypes() {
        return huodongBaomingPingdingTypes;
    }


    /**
	 * 获取：评定结果
	 */

    public void setHuodongBaomingPingdingTypes(Integer huodongBaomingPingdingTypes) {
        this.huodongBaomingPingdingTypes = huodongBaomingPingdingTypes;
    }
    /**
	 * 设置：评定意见
	 */
    public String getHuodongBaomingPingdingText() {
        return huodongBaomingPingdingText;
    }


    /**
	 * 获取：评定意见
	 */

    public void setHuodongBaomingPingdingText(String huodongBaomingPingdingText) {
        this.huodongBaomingPingdingText = huodongBaomingPingdingText;
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
        return "HuodongBaoming{" +
            "id=" + id +
            ", huodongId=" + huodongId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", insertTime=" + insertTime +
            ", huodongBaomingYesnoTypes=" + huodongBaomingYesnoTypes +
            ", huodongBaomingYesnoText=" + huodongBaomingYesnoText +
            ", fuwuNumber=" + fuwuNumber +
            ", huodongBaomingPingdingTypes=" + huodongBaomingPingdingTypes +
            ", huodongBaomingPingdingText=" + huodongBaomingPingdingText +
            ", createTime=" + createTime +
        "}";
    }
}
