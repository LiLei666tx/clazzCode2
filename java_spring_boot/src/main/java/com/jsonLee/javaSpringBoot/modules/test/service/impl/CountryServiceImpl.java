package com.jsonLee.javaSpringBoot.modules.test.service.impl;

import com.jsonLee.javaSpringBoot.modules.test.dao.CountryDao;
import com.jsonLee.javaSpringBoot.modules.test.entity.Country;
import com.jsonLee.javaSpringBoot.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //service层的注解
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    //根据国家id查询国家信息
    @Override
    public Country getCountryByCountryId(int countryId) {
        return countryDao.getCountryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryId2(int countryId) {
        return countryDao.getCountryByCountryId2(countryId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return countryDao.getCountryByCountryName(countryName);
    }
}
