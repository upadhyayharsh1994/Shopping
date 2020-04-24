package VO;

public class orderDetailsVO {
	private int orderId;
	private String productName;
	private int price;
	private loginVO userIdd;
	private cardDetailsVO cardId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public loginVO getUserIdd() {
		return userIdd;
	}
	public void setUserIdd(loginVO userIdd) {
		this.userIdd = userIdd;
	}
	public cardDetailsVO getCardId() {
		return cardId;
	}
	public void setCardId(cardDetailsVO cardId) {
		this.cardId = cardId;
	}
	
	
	
}
