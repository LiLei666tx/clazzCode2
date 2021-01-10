package com.jsonLee.javaSpringBoot.modules.test.dao;

import com.jsonLee.javaSpringBoot.modules.test.entity.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*mybatis查询有两种方式，
1、通过mapper.xml
2、或者直接用注解
*/

@Repository     //dao层的注解
@Mapper    //mybatis独特的注解
public interface CountryDao {

    //通过国家id获取国家信息
    @Select("select * from m_country where country_id = #{countryId}")
    Country getCountryByCountryId(int countryId);

    //根据国家id查询国家信息，并展示所有的城市，使用组合查询
    @Select("select * from m_country where country_id = #{countryId}")
    //通过上面查询到的country_id,赋值给CityDao里的方法getCitiesByCountryId查询城市群，
    //然后赋给实体类country中的cities属性，类型为List ，这就是下面的代码的基本含义
    @Results(id = "cityResults", value = {
            @Result(column = "country_id", property = "countryId"),   //防止查到6的国家属性country_id为0
            @Result(column = "country_id", property = "cities",
            javaType = List.class,
            many = @Many(select =
                    "com.jsonLee.javaSpringBoot.modules.test.dao.CityDao.getCitiesByCountryId"))
    })
    Country getCountryByCountryId2(int countryId);

    //根据country_name 查询 country
    @Select("select * from m_country where country_name = #{countryName}")
    //本来直接复制下面的也可以查询到cities，
    // 但是修改的话，要修改两处，很不好，不方便，所以我们采用加id的方式
    @ResultMap(value = "cityResults")
//    @Results(value = {
//            @Result(column = "country_id", property = "countryId"),   //防止查到6的国家属性country_id为0
//            @Result(column = "country_id", property = "cities",
//                    javaType = List.class,
//                    many = @Many(select =
//                            "com.jsonLee.javaSpringBoot.modules.test.dao.CityDao.getCitiesByCountryId"))
//    })
    Country getCountryByCountryName(String countryName);
}
