package com.study.javabean;

import java.math.BigDecimal;

public class Calculater {
	public int num1;
	
	public int num2;
	
	public String operator="+";
	
	public double result;

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public void calculate(){
		switch(this.operator){
			case "+":{
				this.result=num1+num2;
				break;
			}
			case "-":{
				this.result=num1-num2;
				break;
			}
			case "*":{
				this.result=num1*num2;
				break;
			}
			case "/":{
				this.result=num1/num2;
				this.result=new BigDecimal(this.result).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				break;
			}
			default:{
				throw new RuntimeException("传入的运算符不合法。");
			}		
		}	
	}
}
