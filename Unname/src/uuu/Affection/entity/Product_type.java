package uuu.Affection.entity;

public class Product_type {

	
	private String type_name ;
	private int type_id;
	
	public String getType_name() {
		return type_name;
	}
	
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	public int getType_id() {
		return type_id;
	}
	
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()
				+"Product_type "
				+ "\n種類名稱:" + type_name 
				+ "\n種類ID:" + type_id ;
	}
	
	
	
	
	
}
