	package com.internousdev.ecsite2.dto;

	public class MyPageDTO {

//DAOで取得したデータを格納していく。
		public String itemName;
		public String totalPrice;
		public String totalCount;
		public String payment;
		public String id;
		public String insert_date;

//userNameは使ってない？？？？
		public String userName;

		public String getItemName(){
			return itemName;
		}

		public void setItemName(String itemName){
			this.itemName = itemName;
		}

		public String getTotalPrice(){
			return totalPrice;
		}

		public void setTotalPrice(String totalPrice){
			this.totalPrice = totalPrice;
		}

		public String getTotalCount(){
			return totalCount;
		}

		public void setTotalCount(String totalCount){
			this.totalCount = totalCount;
		}

		public String getPayment(){
			return payment;
		}

		public void setPayment(String payment){
			this.payment = payment;
		}

		public String getUserName(){
			return userName;
		}

		public void setUserName(String userName){
			this.userName = userName;
		}

		public String getId(){
			return id;
		}

		public void setId(String id){
			this.id = id;
		}

		public String getInsert_date(){
			return insert_date;
		}

		public void setInsert_date(String insert_date){
			this.insert_date = insert_date;
		}

	}
