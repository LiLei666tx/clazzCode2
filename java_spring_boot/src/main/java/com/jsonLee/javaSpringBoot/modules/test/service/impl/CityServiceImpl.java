package com.jsonLee.javaSpringBoot.modules.test.service.impl;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.common.vo.SearchVo;
import com.jsonLee.javaSpringBoot.modules.test.dao.CityDao;
import com.jsonLee.javaSpringBoot.modules.test.entity.City;
import com.jsonLee.javaSpringBoot.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    //根据国家id查询城市
    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        return Optional           //链式写法，代表可选的
                .ofNullable(cityDao.getCitiesByCountryId(countryId))   //如果不为空
                .orElse(Collections.emptyList());    //如果为空，返回空集合，而不是返回null
    }

    @Override
    public PageInfo<City> getCitiesBySearchVo(SearchVo searchVo,int countryId) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());  //设置开始页
        return new PageInfo<City>(Optional         //这里返回一个PageInfo对象,查询的还是所有的city
                                   .ofNullable(cityDao.getCitiesByCountryId(countryId))
                                   .orElse(Collections.emptyList())
        );
    }

    @Override
    public PageInfo<City> getCitiesBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<City>(Optional
                .ofNullable(cityDao.getCitiesBySearchVo(searchVo))
                .orElse(Collections.emptyList())
        );
    }

    @Override
    @Transactional     //对于增删改，在serviceimpl上要加上事务注解
    public Result<City> insertCity(City city) {
        city.setDateCreated(new Date());   //在service层给创建时间由系统给定
        cityDao.insertCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,
                "Insert success!",city);
    }

    @Override
    public Result<City> updateCity(City city) {
        city.setDateModified(new Date());
        cityDao.updateCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,
                "Update success",city);
    }

    @Override
    public Result<City> deleteCity(City city) {
        cityDao.deleteCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,
                "Delete success",city);
    }

    @Override
    public Result<City> deleteCity2(int cityId) {
        cityDao.deleteCity2(cityId);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,
                "Delete success");
    }
}
