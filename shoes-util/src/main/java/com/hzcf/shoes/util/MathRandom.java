package com.hzcf.shoes.util;

import java.util.Random;

public class MathRandom {
	/**
	 * 返回6位随机数
	 * @return
	 */
	public static int getRandomOfSixDigit(){
		Random random = new Random();
		return random.nextInt(899999)+100000;
	}
	
	//	
	//	public static void main(String[] args) {
	//		MathRandom dd=new MathRandom();
	//		dd.index();
	//	}
}
