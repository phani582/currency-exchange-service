package com.test.currencyExchage.currencyexchangeservice;

public class Tset {

	long Walk = 0;
	long Run = 1;
	void Walking(int newValue) {
		Walk = newValue;
	}
	void Running(int inc) {
		Run = Run+inc;
	}
	void Jogging(int inc) {
		Run = Run+inc;
	}
	void status() {
		System.out.println("Run -> "+Run+"\t Walk ->"+Walk);
	}
	public static void main(String[] args) {

		Tset tset1 = new Tset();
		Tset tset2 = new Tset();
		
		tset1.Running(200);
		tset1.Walking(1000);
		tset1.Jogging(350);
		tset1.status();
		
		tset2.Running(750);
		tset2.Walking(200);
		tset2.status();
	}

}
