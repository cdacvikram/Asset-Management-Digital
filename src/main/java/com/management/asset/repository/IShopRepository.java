package com.management.asset.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.management.asset.model.shop.Shop;

/**
 * IShopRepository interface for CRUD operation of shop
 * 
 * @author Vikram
 */
@Transactional
public interface IShopRepository  extends CrudRepository<Shop, String>{

}
