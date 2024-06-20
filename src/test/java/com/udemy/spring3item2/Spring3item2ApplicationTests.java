package com.udemy.spring3item2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udemy.spring3item2.Controller.ItemController;
import com.udemy.spring3item2.repo.ItemRepository;
import com.udemy.spring3item2.service.ItemService;

@SpringBootTest
class Spring3item2ApplicationTests {

	@Autowired
	private ItemController itemController;
	
	@Autowired
	private ItemService itemService; 
	
	@Autowired
	private ItemRepository itemRepository; 
	
	// アプリケーションがSpring コンテキストを正常にロードできたかどうかを検証する。
	@Test
	void contextLoads() {
	// AssertJを利用した検証を実装する。
	// assertThatの引数に検証の値を入れる
	// 続けてメソッドにて期待値を指定。この場合はNullでないこと。
	assertThat(itemController).isNotNull();
	assertThat(itemService).isNotNull();
	assertThat(itemRepository).isNotNull();
	
	}
}
