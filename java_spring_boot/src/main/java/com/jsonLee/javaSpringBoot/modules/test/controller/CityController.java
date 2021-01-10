package com.jsonLee.javaSpringBoot.modules.test.controller;

import com.github.pagehelper.PageInfo;
import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.common.vo.SearchVo;
import com.jsonLee.javaSpringBoot.modules.test.entity.City;
import com.jsonLee.javaSpringBoot.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 127.0.0.1/api/city/522
     * @param countryId
     * @return
     */
    @GetMapping("/city/{countryId}")
    public List<City> getCitiesByCountryId(@PathVariable int countryId){
        return cityService.getCitiesByCountryId(countryId);
    }

    /**
     * 127.0.0.1/api/city/522   ----   post
     * {"currentPage":"1","pageSize":"5"}
     * @param searchVo
     * @param countryId
     * @return
     */
    //countryId用@PathVariable方式，searchVo用数据的消费consumes，这里采用的是json字符串，产出的话用produce
    @PostMapping(value = "/city/{countryId}", consumes = "application/json")     //对于单个参数的话用的get，但是我们对于多个的参数一般用post
    public PageInfo<City> getCitiesBySearchVo(@RequestBody SearchVo searchVo, @PathVariable int countryId) {
        return cityService.getCitiesBySearchVo(searchVo,countryId);
    }

    //脚本的多条件查询
    /**
     * 127.0.0.1/api/city  ---  post
     * {"currentPage":"1","pageSize":"5","keyWord":"Sh","orderBy":"city_name","sort":"desc"}
     * @param searchVo
     * @return
     */
    @PostMapping(value = "/city" ,consumes = "application/json")
    public PageInfo<City> getCitiesBySearchVo(@RequestBody SearchVo searchVo) {
        return cityService.getCitiesBySearchVo(searchVo);
    }

    /**
     * 127.0.0.1/api/city2  ----  post
     * {"cityName":"ChangAn","localCityName":"bestCity","countryId":"522"}
     * 为什么不加创建时间，系统给，怎么设置，在service层，controller只负责页面的渲染和数据的传递
     * @param city
     * @return
     */
    @PostMapping(value = "/city2", consumes = "application/json")    //插入操作一般是post请求，和多个参数也是post请求
    public Result<City> insertCity(@RequestBody City city) {
        return cityService.insertCity(city);
    }

    /**
     * 127.0.0.1/api/city2  --- put
     * "cityName"="LiLeiCity"  "cityId"="2259"
     * @param city
     * @return
     */
    //1、form表单接收  "cityName"="LiLeiCity"  "cityId"="2259"
    @PutMapping(value = "/city2" ,consumes = "application/x-www-form-urlencoded")
    public Result<City> updateCity(@ModelAttribute City city) {
       return cityService.updateCity(city);
    }
 /*
    //2、json接收  {"cityName":"aaaaa","cityId":"2262"}
    @PutMapping(value = "/city2" ,consumes = "application/json")  //form表单接收
    public Result<City> updateCity(@RequestBody City city) {
        return cityService.updateCity(city);
    }
 */

    /**
     * 127.0.0.1/api/city2   ---  delete
     * {"cityId":"2264"}
     * ram city
     * @return
     */
    //1、json接收
    @DeleteMapping(value = "/city2" ,consumes = "application/json")
    public Result<City> deleteCity(@RequestBody City city) {
        return cityService.deleteCity(city);
    }

/*
     // 2、form表单接收 "cityId"="2264"
     @DeleteMapping(value = "/city2",consumes = "x-www-form-urlencoded")
     public Result<City> deleteCity(@ModelAttribute City city){
        return cityService.deleteCity(city);
     }
*/

     // 3、单个参数直接path拼接  127.0.0.1/api/city2/2263  ---  delete
     @DeleteMapping(value = "/city2/{cityId}")
     public Result<City> deleteCity2(@PathVariable int cityId){
        return cityService.deleteCity2(cityId);
     }

}
