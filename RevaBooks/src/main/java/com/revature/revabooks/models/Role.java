package com.revature.revabooks.models;

public enum Role {
	ADMIN("Admin")
	,MANAGER("Manager")
	,PREMIUM_MEMBER("Premium Member")
	,BASIC_MEMBER("Member")
	,LOCKED("Locked")
	;
	//naming convention for constant values is to make them ALL CAPS.

	private String roleName;

	Role(String roleName) {
		this.roleName = roleName;
	}

	@Override public String toString(){
		return this.roleName;
	}
}
