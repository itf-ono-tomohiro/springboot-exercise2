package com.udemy.spring3item2.exception;

public class ItemNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(Long itemId) {
		super("商品コードは：" + itemId + "は見つかりません");
	}

}
