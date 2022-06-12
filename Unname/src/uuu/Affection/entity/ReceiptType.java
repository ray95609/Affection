package uuu.Affection.entity;

public enum ReceiptType {
	ELECTRONIC("Electronic Receipt"),
	PAPER("Paper Receipt");
	
	
	private final String description;

	private ReceiptType(String description) {
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
