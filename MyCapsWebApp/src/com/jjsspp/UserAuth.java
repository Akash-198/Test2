package com.jjsspp;

import java.util.Date;

public class UserAuth {
	private  int attemps=1;
	private boolean lock=false;
	private Date locktime;
	
	private static UserAuth ref=null;
	private static String x;
	
	private UserAuth() {
		
	}
	/*private  String getX() {
		return x;
	}
	private void setX(String x) {
		this.x=x;
	}*/
	
	public int getAttemps() {
		return attemps;
	}
	public void increAttempts() {
		attemps++;
		
	}
	public boolean isLock() {
		return lock;
	}
	public void setLock(boolean lock) {
		this.lock = lock;
	}
	public Date getLocktime() {
		return locktime;
	}
	public void setLocktime() {
		this.locktime = new Date();
	}
	
	public static UserAuth getUserAuth(String y) {
		if(x==null) {
			x=y;
			ref=new UserAuth();
		}else if(x==y) {
			return ref;
		}else {
			x=y;
			ref=new UserAuth();
			return ref;
		}
		return null;
		
	
	}
	public static void main(String[] args) {
		UserAutherization u=new UserAutherization();
		System.out.println(u.getAttempts());
	}
	
	

}
