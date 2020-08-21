package com.revature.revabooks.models;

import java.util.Arrays;

public enum Role {
	ADMIN("Admin")
	,MANAGER("Manager")
	,PREMIUM_MEMBER("Premium Member")
	,BASIC_MEMBER("Basic Member")
	,LOCKED("Locked")
	;
	//naming convention for constant values is to make them ALL CAPS.
	/**
	 *
	 */
	private String roleName;

	/**
	 *
	 * @param roleName
	 */
	Role(String roleName) {
		this.roleName = roleName;
	}

	public static Role getByName(String name){
//
//		for (Role role : Role.values()) {
//			if(role.roleName.equals(name)){
//				return role;
//			}
//		}
//
//		return LOCKED;

		return Arrays.stream(Role.values())
				.filter(role -> role.roleName.equals(name))
				.findFirst()
				.orElse(LOCKED);
	}

	public static int getOrdinal(Role role){
		for (int i = 0; i < Role.values().length; i++) {
			if(Role.values()[i] == role) return i+1;
		}
		return getOrdinal(Role.LOCKED);
	}

	@Override public String toString(){
		return this.roleName;
	}
}
