package im.conversations.app.controller;

import java.util.ArrayList;

public class TestMain {
public static void main(String[] args) {
	String aa = "asda ~heart~ asdas ~smily~ varundani ~s";
	
	ArrayList<String> ar = new ArrayList<String>();
	
	//System.out.println(aa.split(":-\\)")[0]);
	//System.out.println(aa.split(":-D")[0]);
	//System.out.println(aa.split("<3")[0]);
	
	char[] ch = aa.toCharArray();
	
	int j = -1;
	for(int i = 0; i<ch.length;i++){
		
		if(ch[i]== '~'){
			
			ar.add(aa.substring(j+1,i));
			j = i+1;
			while(ch[j]!='~' && j<ch.length-1)
			{
				++j;
			}
			ar.add(aa.substring(i+1,j));
			i=j;
		}
	}
	ar.add(aa.substring(j+1));
	
	for(String aaa : ar)
	{
		System.out.println(aaa);
	}
}
}
