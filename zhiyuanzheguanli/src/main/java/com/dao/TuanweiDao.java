package com.dao;

import com.entity.TuanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TuanweiView;

/**
 * 团委 Dao 接口
 *
 * @author 
 */
public interface TuanweiDao extends BaseMapper<TuanweiEntity> {

   List<TuanweiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
