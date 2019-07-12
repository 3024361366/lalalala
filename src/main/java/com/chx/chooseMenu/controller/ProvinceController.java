package com.chx.chooseMenu.controller;

import com.chx.chooseMenu.pojo.Area;
import com.chx.chooseMenu.service.ProvinceService;
import com.chx.chooseMenu.utils.JedisClientPool;
import com.chx.chooseMenu.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;
    @Autowired
    JedisClientPool jedisClientPool;

    @RequestMapping("/provinceServlet")
    @ResponseBody
    public List<Area> showProvince() {
        String province = jedisClientPool.get("province");
        List<Area> areaList = null;
        if (province == null || province.equals("")) {
            areaList = provinceService.findAllProvince();
            String areaJson = JsonUtils.objectToJson(areaList);
            jedisClientPool.set("province", areaJson);
            System.out.println("从MySQL数据库中查找的");
        } else {
            areaList = JsonUtils.jsonToList(province,Area.class);
            System.out.println("从缓存中查的");
        }
        return areaList;
    }

    @RequestMapping("/cityServlet")
    @ResponseBody
    public List<Area> showCity(int id) {
        String city = jedisClientPool.get("city");
        List<Area> cityList = null;
        if (city == null || city.equals("")) {
            cityList = provinceService.findAllCity(id);
            String cityJson = JsonUtils.objectToJson(cityList);
            jedisClientPool.set("city",cityJson);
            System.out.println("这是从数据库中查的");
        } else {
            cityList = JsonUtils.jsonToList(city,Area.class);
            System.out.println("这是从缓存来的");
        }
        return cityList;
//        return provinceService.findAllCity(id);
    }

    @RequestMapping("/countryServlet")
    @ResponseBody
    public List<Area> showContury(int id) {
        String contury = jedisClientPool.get("contury");
        List<Area> conturyList = null;
        if (contury == null || contury.equals("")) {
            conturyList = provinceService.findAllContury(id);
            String conturyJson = JsonUtils.objectToJson(conturyList);
            jedisClientPool.set("contury",conturyJson);
            System.out.println("县这是从数据库中查的");
        } else {
            conturyList = JsonUtils.jsonToList(contury,Area.class);
            System.out.println("县这是从缓存来的");
        }
        return conturyList;
    }
}
