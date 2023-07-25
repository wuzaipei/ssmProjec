package org.example.controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.example.model.fine_conf_xmlentity;
import org.example.service.FineConfXmlentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/login")
public class fineConfXmlentityController {

    @Autowired
    public FineConfXmlentityService fine;

    @RequestMapping(value = "/aml", method = RequestMethod.GET)
    public String getEmployeePage(Model model){
        //获取员工的分页信息
        StringBuffer rsl = fine.findAllListing();
        System.out.println("查询语句select succ----:"+rsl.toString());
        return "index";
    }
    /*
    * 阿里巴巴FastJson是一个Json处理工具包，包括“序列化”和“反序列化”两部分，它具备如下特征：
速度最快，测试表明，fastjson具有极快的性能，超越任其他的Java Json parser。包括自称最快的JackJson；
功能强大，完全支持Java Bean、集合、Map、日期、Enum，支持范型，支持自省；无依赖，能够直接运行在Java SE 5.0以上版本；支持Android；开源 (Apache 2.0)

源码地址：https://github.com/alibaba/fastjson


Fastjson API入口类是com.alibaba.fastjson.JSON，常用的序列化操作都可以在JSON类上的静态方法直接完成。

public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray
public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject
public static final  T parseObject(String text, Class clazz); // 把JSON文本parse为JavaBean
public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray
public static final  List parseArray(String text, Class clazz); //把JSON文本parse成JavaBean集合
public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本
public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本
public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
    * */
    @RequestMapping(value = "/ajax/pos" ,method = RequestMethod.POST)
    @ResponseBody // 定义返回json数据给前台
    public Object repostRespone(@RequestBody JSONObject reqf){

        List<fine_conf_xmlentity> lst = fine.queryAll();
        JSONArray o = (JSONArray) JSON.toJSON(lst);
        //        System.out.println(o);
        System.out.println("测试json数据接收："+reqf);
        //将字符串格式的字段转换为JSon字段
        System.out.println(reqf.get("value"));
        System.out.println(reqf.get("id"));

//        return lst;

        return o;
    }

}

