package com.ssafy.debug.model.dto;

public class FruitDto {
	private int fruitId;
	private String fruitName;
	private String taste;
	private int price;
	private int quantity;

	public FruitDto() {
	}

	public FruitDto(int fruitId, String fruitName, String taste, int price, int quantity) {
		this.fruitId = fruitId;
		this.fruitName = fruitName;
		this.taste = taste;
		this.price = price;
		this.quantity = quantity;
	}

	public int getFruitId() {
		return fruitId;
	}

	public void setFruitId(int fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
