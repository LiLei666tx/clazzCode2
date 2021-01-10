package com.jsonLee.javaSpringBoot.modules.test.repository;

import com.jsonLee.javaSpringBoot.modules.test.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//jpa都要继承这个，参数是要继承的类，后面是id
public interface CardRepository extends JpaRepository<Card, Integer> {

}
