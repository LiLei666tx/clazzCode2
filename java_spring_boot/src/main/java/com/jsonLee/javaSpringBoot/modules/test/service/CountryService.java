package com.jsonLee.javaSpringBoot.modules.test.service;

import com.jsonLee.javaSpringBoot.modules.test.entity.Country;

public interface CountryService {
    //根据国家id查询国家信息
     Country getCountryByCountryId(int countryId);

    //根据国家id查询国家信息，并展示所有的城市，使用组合查询
     Country getCountryByCountryId2(int countryId);

    //根据country_name 查询 country
     Country getCountryByCountryName(String countryName);
}
