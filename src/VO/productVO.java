package VO;

import java.io.Serializable;

public class productVO implements Serializable {
	
	private int productId;
	private String productName;
	private String productDescription;
	private int price;
	private String imagePath;
	private int quantity;
	private categoryVO categoryId;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public categoryVO getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(categoryVO categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
}
