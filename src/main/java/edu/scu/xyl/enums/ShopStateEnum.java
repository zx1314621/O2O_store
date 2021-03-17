package edu.scu.xyl.enums;

public enum ShopStateEnum {
	CHECK(0, "In the review"), OFFLINE(-1, "Illegal"), SUCCESS(1, "Suceess"), PASS(2, "Pass"),
	INNER_ERROR(-1001, "Inner error"), NULL_SHOPID(-1002, "Empty shopId"), NULL_SHOP(-1003, "shop is null");

	private int state;
	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

}
