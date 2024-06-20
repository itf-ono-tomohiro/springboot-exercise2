package com.udemy.spring3item2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udemy.spring3item2.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

}
