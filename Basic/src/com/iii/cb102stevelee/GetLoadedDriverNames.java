package com.iii.cb102stevelee;


import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;





public class GetLoadedDriverNames {

	public static void main(String[] args) {
		// TODO Auto-generaDriverthod stub
		Enumeration<Driver>drivers=DriverManager.getDrivers();
		while(drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			System.out.println(driver.getClass().getName());
		}
	}

}
