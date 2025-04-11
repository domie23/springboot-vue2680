
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 活动报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huodongBaoming")
public class HuodongBaomingController {
    private static final Logger logger = LoggerFactory.getLogger(HuodongBaomingController.class);

    @Autowired
    private HuodongBaomingService huodongBaomingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuodongService huodongService;
    @Autowired
    private ZhiyuanzheService zhiyuanzheService;

    @Autowired
    private TuanweiService tuanweiService;
    @Autowired
    private HuodongchengbanfangService huodongchengbanfangService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("志愿者".equals(role))
            params.put("zhiyuanzheId",request.getSession().getAttribute("userId"));
        else if("团委".equals(role))
            params.put("tuanweiId",request.getSession().getAttribute("userId"));
        else if("活动承办方".equals(role))
            params.put("huodongchengbanfangId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huodongBaomingService.queryPage(params);

        //字典表数据转换
        List<HuodongBaomingView> list =(List<HuodongBaomingView>)page.getList();
        for(HuodongBaomingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongBaomingEntity huodongBaoming = huodongBaomingService.selectById(id);
        if(huodongBaoming !=null){
            //entity转view
            HuodongBaomingView view = new HuodongBaomingView();
            BeanUtils.copyProperties( huodongBaoming , view );//把实体数据重构到view中

                //级联表
                HuodongEntity huodong = huodongService.selectById(huodongBaoming.getHuodongId());
                if(huodong != null){
                    BeanUtils.copyProperties( huodong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuodongId(huodong.getId());
                }
                //级联表
                ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(huodongBaoming.getZhiyuanzheId());
                if(zhiyuanzhe != null){
                    BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhiyuanzheId(zhiyuanzhe.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongBaomingEntity huodongBaoming, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huodongBaoming:{}",this.getClass().getName(),huodongBaoming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("活动".equals(role))
            huodongBaoming.setHuodongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("志愿者".equals(role))
            huodongBaoming.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HuodongBaomingEntity> queryWrapper = new EntityWrapper<HuodongBaomingEntity>()
            .eq("huodong_id", huodongBaoming.getHuodongId())
            .eq("zhiyuanzhe_id", huodongBaoming.getZhiyuanzheId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongBaomingEntity huodongBaomingEntity = huodongBaomingService.selectOne(queryWrapper);
        if(huodongBaomingEntity==null){
            huodongBaoming.setInsertTime(new Date());
            huodongBaoming.setHuodongBaomingYesnoTypes(1);
            huodongBaoming.setCreateTime(new Date());
            huodongBaomingService.insert(huodongBaoming);
            return R.ok();
        }else {
            return R.error(511,"该志愿者已经报名过该项目");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuodongBaomingEntity huodongBaoming, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huodongBaoming:{}",this.getClass().getName(),huodongBaoming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("活动".equals(role))
//            huodongBaoming.setHuodongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("志愿者".equals(role))
//            huodongBaoming.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<HuodongBaomingEntity> queryWrapper = new EntityWrapper<HuodongBaomingEntity>()
            .notIn("id",huodongBaoming.getId())
            .andNew()
            .eq("huodong_id", huodongBaoming.getHuodongId())
            .eq("zhiyuanzhe_id", huodongBaoming.getZhiyuanzheId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongBaomingEntity huodongBaomingEntity = huodongBaomingService.selectOne(queryWrapper);
        if(huodongBaomingEntity==null){
            huodongBaomingService.updateById(huodongBaoming);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该志愿者已经报名过该项目");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huodongBaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<HuodongBaomingEntity> huodongBaomingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuodongBaomingEntity huodongBaomingEntity = new HuodongBaomingEntity();
//                            huodongBaomingEntity.setHuodongId(Integer.valueOf(data.get(0)));   //活动 要改的
//                            huodongBaomingEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            huodongBaomingEntity.setInsertTime(date);//时间
//                            huodongBaomingEntity.setHuodongBaomingYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            huodongBaomingEntity.setHuodongBaomingYesnoText(data.get(0));                    //审核意见 要改的
//                            huodongBaomingEntity.setFuwuNumber(Integer.valueOf(data.get(0)));   //服务时数(小时) 要改的
//                            huodongBaomingEntity.setHuodongBaomingPingdingTypes(Integer.valueOf(data.get(0)));   //评定结果 要改的
//                            huodongBaomingEntity.setHuodongBaomingPingdingText(data.get(0));                    //评定意见 要改的
//                            huodongBaomingEntity.setCreateTime(date);//时间
                            huodongBaomingList.add(huodongBaomingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        huodongBaomingService.insertBatch(huodongBaomingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = huodongBaomingService.queryPage(params);

        //字典表数据转换
        List<HuodongBaomingView> list =(List<HuodongBaomingView>)page.getList();
        for(HuodongBaomingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongBaomingEntity huodongBaoming = huodongBaomingService.selectById(id);
            if(huodongBaoming !=null){


                //entity转view
                HuodongBaomingView view = new HuodongBaomingView();
                BeanUtils.copyProperties( huodongBaoming , view );//把实体数据重构到view中

                //级联表
                    HuodongEntity huodong = huodongService.selectById(huodongBaoming.getHuodongId());
                if(huodong != null){
                    BeanUtils.copyProperties( huodong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuodongId(huodong.getId());
                }
                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(huodongBaoming.getZhiyuanzheId());
                if(zhiyuanzhe != null){
                    BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhiyuanzheId(zhiyuanzhe.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongBaomingEntity huodongBaoming, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huodongBaoming:{}",this.getClass().getName(),huodongBaoming.toString());
        Wrapper<HuodongBaomingEntity> queryWrapper = new EntityWrapper<HuodongBaomingEntity>()
            .eq("huodong_id", huodongBaoming.getHuodongId())
            .eq("zhiyuanzhe_id", huodongBaoming.getZhiyuanzheId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongBaomingEntity huodongBaomingEntity = huodongBaomingService.selectOne(queryWrapper);
        if(huodongBaomingEntity==null){
            huodongBaoming.setInsertTime(new Date());
            huodongBaoming.setHuodongBaomingYesnoTypes(1);
            huodongBaoming.setCreateTime(new Date());
        huodongBaomingService.insert(huodongBaoming);
            return R.ok();
        }else {
            return R.error(511,"该志愿者已经报名过该项目");
        }
    }


}
