package com.baizhi.dangdang.util;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入密码");
		String password =sc.next();
		
		String salt = Md5Util.getSalt();
		
		String encryp1 = Md5Util.encryption(password+salt);
		
		String encryp2 = Md5Util.encryption(password);
		
		System.out.println(encryp1);
		System.out.println(encryp2);
		
		System.out.println( Md5Util.checkPassword( password+salt , encryp1));

	}

}
