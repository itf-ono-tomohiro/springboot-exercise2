package com.udemy.spring3item2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.udemy.spring3item2.model.Item;
import com.udemy.spring3item2.repo.ItemRepository;

@SpringBootApplication
@EnableCaching
public class Spring3item2Application implements CommandLineRunner{

	@Autowired
	private ItemRepository itemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Spring3item2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		itemRepository.save(new Item("ネックレス","ジュエリ"));
		itemRepository.save(new Item("パーカー","ファッション"));
		itemRepository.save(new Item("フェイスクリーム","ビューティ"));
		itemRepository.save(new Item("サプリ","ヘルス"));
		itemRepository.save(new Item("ブルーベリー","フード"));
		
	}

}
