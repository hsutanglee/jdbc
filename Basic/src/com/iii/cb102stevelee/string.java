package com.iii.cb102stevelee;
import java.util.*;

public class string {

	public static void main(String[] args) {
		String s = "select  ename,a,b from employee";
		int t;
	
		System.out.println(s.substring(5));
		System.out.println(s.contains(","));
		ArrayList<String> list = new ArrayList<>();
		
		for (String retval: s.split(" ")) {
			if(retval.length()!=0) {
				list.add(retval);
			System.out.println("a  "+retval+" "+retval.length()+" "+s.indexOf(retval));	

			}
		
		}
		
		for (int i=0;i<list.size();i++) {
			if (list.get(i).equals("select")) {
			System.out.println(list.get(i));
			}
			if (list.get(i).equals("from")) {
			System.out.println(list.get(i+1));
			}
		}
		for (int i=0;i<list.size();i++) {
			if (list.get(i).equals("select")) {
				System.out.println(list.get(i+1));
				}
		}
		
	}

}
