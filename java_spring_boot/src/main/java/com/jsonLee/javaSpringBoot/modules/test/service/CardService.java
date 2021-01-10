package com.jsonLee.javaSpringBoot.modules.test.service;

import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.test.entity.Card;

public interface CardService {

    //插入Card
    Result<Card> insertCard(Card card);
}
