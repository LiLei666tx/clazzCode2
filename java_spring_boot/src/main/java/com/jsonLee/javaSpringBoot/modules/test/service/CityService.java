package com.jsonLee.javaSpringBoot.modules.test.service;

import com.github.pagehelper.PageInfo;
import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.common.vo.SearchVo;
import com.jsonLee.javaSpringBoot.modules.test.entity.City;

import java.util.List;

public interface CityService {
    //根据国家id查询城市
     List<City> getCitiesByCountryId(int countryId);

    //分页，使用PageHelper插件 ,排序的参数SearchVo 封装好了
     PageInfo<City> getCitiesBySearchVo(SearchVo searchVo,int countryId);

    //脚本的多条件查询  根据关键字，排序查询城市 ，也可以做一个分页或者不做都OK
     PageInfo<City> getCitiesBySearchVo(SearchVo searchVo);

     ////mybatis的插入，给m_city表插入城市 ,为什么不用void呢，
     // 因为插入等情况可能要返回插入错误等信息，所以这里用到返回Result对象，而不是什么都不返回，int返回的是影响数据的条目数
     // 放在common.vo包下
     Result<City> insertCity(City city);

     //修改城市
     Result<City> updateCity(City city);

     //删除城市
     Result<City> deleteCity(City city);

     Result<City> deleteCity2(int cityId);
}
