package com.internousdev.ecsite2.dto;

public class BuyItemDTO {

//DAOを通してDBから取得した商品のid,name,passを格納しておく。
	public int id;
	public String itemName;
	public String itemPrice;

//ValueStack受け渡しのためのGet/Set
	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}
}
