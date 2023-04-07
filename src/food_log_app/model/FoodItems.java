package food_log_app.model;

public class FoodItems {
	private String foodItem;
	private float itemValue;
	public FoodItems(String foodItem, float itemValue) {
		super();
		this.foodItem = foodItem;
		this.itemValue = itemValue;
	}
	public FoodItems(String foodItem) {
		super();
		this.foodItem = foodItem;
	}
	public FoodItems() {
		super();
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public float getItemValue() {
		return itemValue;
	}
	public void setItemValue(float itemValue) {
		this.itemValue = itemValue;
	}
	
}
