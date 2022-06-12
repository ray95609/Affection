package uuu.Affection.entity;

public enum PaymentType {
	ATM("ATM"),
	CARD("Credit Card");
	
	private final String description;

	
	private PaymentType(String description) {
		this.description = description;
		}
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
	
	
}
