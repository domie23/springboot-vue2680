
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
 * 活动承办方
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huodongchengbanfang")
public class HuodongchengbanfangController {
    private static final Logger logger = LoggerFactory.getLogger(HuodongchengbanfangController.class);

    @Autowired
    private HuodongchengbanfangService huodongchengbanfangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private ZhiyuanzheService zhiyuanzheService;
    @Autowired
    private TuanweiService tuanweiService;


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
        PageUtils page = huodongchengbanfangService.queryPage(params);

        //字典表数据转换
        List<HuodongchengbanfangView> list =(List<HuodongchengbanfangView>)page.getList();
        for(HuodongchengbanfangView c:list){
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
        HuodongchengbanfangEntity huodongchengbanfang = huodongchengbanfangService.selectById(id);
        if(huodongchengbanfang !=null){
            //entity转view
            HuodongchengbanfangView view = new HuodongchengbanfangView();
            BeanUtils.copyProperties( huodongchengbanfang , view );//把实体数据重构到view中

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
    public R save(@RequestBody HuodongchengbanfangEntity huodongchengbanfang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huodongchengbanfang:{}",this.getClass().getName(),huodongchengbanfang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuodongchengbanfangEntity> queryWrapper = new EntityWrapper<HuodongchengbanfangEntity>()
            .eq("username", huodongchengbanfang.getUsername())
            .or()
            .eq("huodongchengbanfang_phone", huodongchengbanfang.getHuodongchengbanfangPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongchengbanfangEntity huodongchengbanfangEntity = huodongchengbanfangService.selectOne(queryWrapper);
        if(huodongchengbanfangEntity==null){
            huodongchengbanfang.setCreateTime(new Date());
            huodongchengbanfang.setPassword("123456");
            huodongchengbanfangService.insert(huodongchengbanfang);
            return R.ok();
        }else {
            return R.error(511,"账户或者企业联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuodongchengbanfangEntity huodongchengbanfang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huodongchengbanfang:{}",this.getClass().getName(),huodongchengbanfang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HuodongchengbanfangEntity> queryWrapper = new EntityWrapper<HuodongchengbanfangEntity>()
            .notIn("id",huodongchengbanfang.getId())
            .andNew()
            .eq("username", huodongchengbanfang.getUsername())
            .or()
            .eq("huodongchengbanfang_phone", huodongchengbanfang.getHuodongchengbanfangPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongchengbanfangEntity huodongchengbanfangEntity = huodongchengbanfangService.selectOne(queryWrapper);
        if("".equals(huodongchengbanfang.getHuodongchengbanfangPhoto()) || "null".equals(huodongchengbanfang.getHuodongchengbanfangPhoto())){
                huodongchengbanfang.setHuodongchengbanfangPhoto(null);
        }
        if(huodongchengbanfangEntity==null){
            huodongchengbanfangService.updateById(huodongchengbanfang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者企业联系方式已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huodongchengbanfangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<HuodongchengbanfangEntity> huodongchengbanfangList = new ArrayList<>();//上传的东西
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
                            HuodongchengbanfangEntity huodongchengbanfangEntity = new HuodongchengbanfangEntity();
//                            huodongchengbanfangEntity.setUsername(data.get(0));                    //账户 要改的
//                            //huodongchengbanfangEntity.setPassword("123456");//密码
//                            huodongchengbanfangEntity.setHuodongchengbanfangName(data.get(0));                    //企业名称 要改的
//                            huodongchengbanfangEntity.setHuodongchengbanfangTypes(Integer.valueOf(data.get(0)));   //企业行业 要改的
//                            huodongchengbanfangEntity.setHuodongchengbanfangPhone(data.get(0));                    //企业联系方式 要改的
//                            huodongchengbanfangEntity.setHuodongchengbanfangPhoto("");//照片
//                            huodongchengbanfangEntity.setHuodongchengbanfangContent("");//照片
//                            huodongchengbanfangEntity.setCreateTime(date);//时间
                            huodongchengbanfangList.add(huodongchengbanfangEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //企业联系方式
                                if(seachFields.containsKey("huodongchengbanfangPhone")){
                                    List<String> huodongchengbanfangPhone = seachFields.get("huodongchengbanfangPhone");
                                    huodongchengbanfangPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> huodongchengbanfangPhone = new ArrayList<>();
                                    huodongchengbanfangPhone.add(data.get(0));//要改的
                                    seachFields.put("huodongchengbanfangPhone",huodongchengbanfangPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<HuodongchengbanfangEntity> huodongchengbanfangEntities_username = huodongchengbanfangService.selectList(new EntityWrapper<HuodongchengbanfangEntity>().in("username", seachFields.get("username")));
                        if(huodongchengbanfangEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongchengbanfangEntity s:huodongchengbanfangEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //企业联系方式
                        List<HuodongchengbanfangEntity> huodongchengbanfangEntities_huodongchengbanfangPhone = huodongchengbanfangService.selectList(new EntityWrapper<HuodongchengbanfangEntity>().in("huodongchengbanfang_phone", seachFields.get("huodongchengbanfangPhone")));
                        if(huodongchengbanfangEntities_huodongchengbanfangPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongchengbanfangEntity s:huodongchengbanfangEntities_huodongchengbanfangPhone){
                                repeatFields.add(s.getHuodongchengbanfangPhone());
                            }
                            return R.error(511,"数据库的该表中的 [企业联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huodongchengbanfangService.insertBatch(huodongchengbanfangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        HuodongchengbanfangEntity huodongchengbanfang = huodongchengbanfangService.selectOne(new EntityWrapper<HuodongchengbanfangEntity>().eq("username", username));
        if(huodongchengbanfang==null || !huodongchengbanfang.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(huodongchengbanfang.getId(),username, "huodongchengbanfang", "活动承办方");
        R r = R.ok();
        r.put("token", token);
        r.put("role","活动承办方");
        r.put("username",huodongchengbanfang.getHuodongchengbanfangName());
        r.put("tableName","huodongchengbanfang");
        r.put("userId",huodongchengbanfang.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HuodongchengbanfangEntity huodongchengbanfang){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<HuodongchengbanfangEntity> queryWrapper = new EntityWrapper<HuodongchengbanfangEntity>()
            .eq("username", huodongchengbanfang.getUsername())
            .or()
            .eq("huodongchengbanfang_phone", huodongchengbanfang.getHuodongchengbanfangPhone())
            ;
        HuodongchengbanfangEntity huodongchengbanfangEntity = huodongchengbanfangService.selectOne(queryWrapper);
        if(huodongchengbanfangEntity != null)
            return R.error("账户或者企业联系方式已经被使用");
        huodongchengbanfang.setCreateTime(new Date());
        huodongchengbanfangService.insert(huodongchengbanfang);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HuodongchengbanfangEntity huodongchengbanfang = new HuodongchengbanfangEntity();
        huodongchengbanfang.setPassword("123456");
        huodongchengbanfang.setId(id);
        huodongchengbanfangService.updateById(huodongchengbanfang);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        HuodongchengbanfangEntity huodongchengbanfang = huodongchengbanfangService.selectOne(new EntityWrapper<HuodongchengbanfangEntity>().eq("username", username));
        if(huodongchengbanfang!=null){
            huodongchengbanfang.setPassword("123456");
            boolean b = huodongchengbanfangService.updateById(huodongchengbanfang);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrHuodongchengbanfang(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HuodongchengbanfangEntity huodongchengbanfang = huodongchengbanfangService.selectById(id);
        if(huodongchengbanfang !=null){
            //entity转view
            HuodongchengbanfangView view = new HuodongchengbanfangView();
            BeanUtils.copyProperties( huodongchengbanfang , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
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
        PageUtils page = huodongchengbanfangService.queryPage(params);

        //字典表数据转换
        List<HuodongchengbanfangView> list =(List<HuodongchengbanfangView>)page.getList();
        for(HuodongchengbanfangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongchengbanfangEntity huodongchengbanfang = huodongchengbanfangService.selectById(id);
            if(huodongchengbanfang !=null){


                //entity转view
                HuodongchengbanfangView view = new HuodongchengbanfangView();
                BeanUtils.copyProperties( huodongchengbanfang , view );//把实体数据重构到view中

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
    public R add(@RequestBody HuodongchengbanfangEntity huodongchengbanfang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huodongchengbanfang:{}",this.getClass().getName(),huodongchengbanfang.toString());
        Wrapper<HuodongchengbanfangEntity> queryWrapper = new EntityWrapper<HuodongchengbanfangEntity>()
            .eq("username", huodongchengbanfang.getUsername())
            .or()
            .eq("huodongchengbanfang_phone", huodongchengbanfang.getHuodongchengbanfangPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongchengbanfangEntity huodongchengbanfangEntity = huodongchengbanfangService.selectOne(queryWrapper);
        if(huodongchengbanfangEntity==null){
            huodongchengbanfang.setCreateTime(new Date());
        huodongchengbanfang.setPassword("123456");
        huodongchengbanfangService.insert(huodongchengbanfang);
            return R.ok();
        }else {
            return R.error(511,"账户或者企业联系方式已经被使用");
        }
    }


}
