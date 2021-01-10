package com.jsonLee.javaSpringBoot.modules.test.controller;

import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.test.entity.Card;
import com.jsonLee.javaSpringBoot.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    private CardService cardService;

    //插入Card
    /**
     * 127.0.0.1/api/card  --- post
     * {"cardNo":"fhiewhfueh22"}
     * @param card
     * @return
     */
    @PostMapping(value = "/card",consumes = "application/json")
    public Result<Card> insertCard(@RequestBody Card card){
        return cardService.insertCard(card);
    }
}
