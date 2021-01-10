package com.jsonLee.javaSpringBoot.modules.test.controller;

import com.jsonLee.javaSpringBoot.modules.test.entity.Country;
import com.jsonLee.javaSpringBoot.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController   //@RestController 相当于是@ ResponseBody+@Controller ,
                  // 因为我们这里只有数据，没有页面，所以用@ResponseBody,下面就不用加ResponseBody了
@RequestMapping("/api")   //加上统一的路径
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * 127.0.0.1/api/country/522   ----   get
     * @param countryId
     * @return
     */
    @GetMapping("/country/{countryId}")
    public Country getCountryByCountryId(@PathVariable int countryId) {  //@PathVariable用于读路径上的值
        return countryService.getCountryByCountryId(countryId);
    }

    /**
     * 127.0.0.1/api/country1/522   ----   get   //int 类型的话，用path方式传
     * @param countryId
     * @return
     */
    @GetMapping("/country1/{countryId}")   //int 类型的话，用path方式传
    public Country getCountryByCountryId2(@PathVariable int countryId) {  //@PathVariable用于读路径上的值
        return countryService.getCountryByCountryId2(countryId);
    }

    /**
     * 127.0.0.1/api/country?countryName=China  ----  get   // String类型的话，用？拼接的方式传
     * @param countryName
     * @return
     */
    @GetMapping("/country")    // String类型的话，用？拼接的方式传
    public Country getCountryByCountryName(@RequestParam String countryName){
        return countryService.getCountryByCountryName(countryName);
    }
}
