package uuu.Affection.entity;

import java.time.LocalDateTime;

public class OrderStatusLog {

	private int orderId;
	private int oldStatus;
	private int newStatus;
	private LocalDateTime updateTime;
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the oldStatus
	 */
	public int getOldStatus() {
		return oldStatus;
	}
	/**
	 * @param oldStatus the oldStatus to set
	 */
	public void setOldStatus(int oldStatus) {
		this.oldStatus = oldStatus;
	}
	/**
	 * @return the newStatus
	 */
	public int getNewStatus() {
		return newStatus;
	}
	/**
	 * @param newStatus the newStatus to set
	 */
	public void setNewStatus(int newStatus) {
		this.newStatus = newStatus;
	}
	/**
	 * @return the updateTime
	 */
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
}
