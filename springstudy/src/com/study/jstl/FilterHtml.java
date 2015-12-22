package com.study.jstl;

public class FilterHtml {
	
	public static String filter(String message){
		if(message==null)
			return null;
		
		char [] contents=new char[message.length()];
		
		message.getChars(0,message.length(),contents,0);
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<message.length();i++){
			switch(contents[i]){
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			default:
				sb.append(contents[i]);
			
			}
		}
		
		return sb.toString();
		
	}
}
