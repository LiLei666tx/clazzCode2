package com.jsonLee.javaSpringBoot.modules.test.dao;

import com.jsonLee.javaSpringBoot.modules.common.vo.SearchVo;
import com.jsonLee.javaSpringBoot.modules.test.entity.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CityDao {

    //根据国家id查询城市
    @Select("select * from m_city where country_id = #{countryId}")
    List<City> getCitiesByCountryId(int countryId);

    //脚本的多条件查询
    @Select("<script>" +
            "select * from m_city "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"    /*为空，下一句不拼接，非空，拼接*/
            + " and (city_name like '%${keyWord}%' or local_city_name like '%${keyWord}%') "  /*关键字*/
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"                    /*排序*/
            + "</when>"
            + "<otherwise>"
            + " order by city_id desc"      /*若没有排序，指定默认排序方式为 city_id 降序desc*/
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<City> getCitiesBySearchVo(SearchVo searchVo);

    //mybatis的插入，给m_city表插入城市
    @Insert("insert into m_city (city_name, local_city_name, country_id, date_created) " +
            "values (#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
    @Options(useGeneratedKeys = true, keyColumn = "city_id", keyProperty = "cityName")         //可选项，沿用主键递增
    void insertCity(City city);

    //修改城市
    @Update("update m_city set city_name = #{cityName} where city_id = #{cityId}")
    void updateCity(City city);

    //删除城市
    @Delete("delete from m_city where city_id = #{cityId}")
    void deleteCity(City city);

    //删除城市2
    @Delete("delete from m_city where city_id = #{cityId}")
    void deleteCity2(int cityId);
}
