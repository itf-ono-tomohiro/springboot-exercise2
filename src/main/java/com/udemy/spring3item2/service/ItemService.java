package com.udemy.spring3item2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.udemy.spring3item2.model.Item;
import com.udemy.spring3item2.repo.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	/*
	private List<Item> allItems = new ArrayList<> (Arrays.asList(
			new Item("1001","ネックレス","ジュエリ"),
			new Item("1002","パーカー","ファッション"),
			new Item("1003","フェイスクリーム","ビューティ"),
			new Item("1004","サプリメント","ヘルス"),
			new Item("1005","ブルーベリー","フード")));
	*/
	@Cacheable("getItems")
	public List<Item> getAllItems(){
		List<Item> allItems = new ArrayList<> ();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		itemRepository.findAll().forEach(allItems::add);
		
		return allItems;
	}
	
	@Cacheable(value="getItem", key="#p0")
	public Optional<Item> getItem(Long itemId) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return itemRepository.findById(itemId);
	}
	
	
	@CacheEvict(value="getItems",allEntries=true)
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	@Caching(evict = {
			@CacheEvict(value="getItem",key="#p0"),
			@CacheEvict(value="getItems",allEntries=true)
	})
	public void updateItem(Long itemId, Item item) {
		if(itemRepository.findById(itemId).get() != null) {
			itemRepository.save(item);
		}
	}
	
	
	@Caching(evict = {
			@CacheEvict(value="getItem",key="#p0"),
			@CacheEvict(value="getItems",allEntries=true)
	})
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}

}
