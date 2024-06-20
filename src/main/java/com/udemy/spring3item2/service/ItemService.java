package com.udemy.spring3item2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Item> getAllItems(){
		List<Item> allItems = new ArrayList<> ();
		itemRepository.findAll().forEach(allItems::add);
		
		return allItems;
	}
	
	public Optional<Item> getItem(Long itemId) {
		return itemRepository.findById(itemId);
	}
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	public void updateItem(Long itemId, Item item) {
		if(itemRepository.findById(itemId).get() != null) {
			itemRepository.save(item);
		}
	}
	
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}

}
