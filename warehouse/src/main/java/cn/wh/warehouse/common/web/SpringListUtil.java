package cn.wh.warehouse.common.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;



public class SpringListUtil {
	
	public static List<Integer> parseIntegerList(String strList, List<Integer> listInt){
		List<String> listStr = Arrays.asList(strList.split(","));
		listInt =new ArrayList<Integer>(listStr.size());
		 CollectionUtils.collect(listStr, 
                 new Transformer(){
                   public java.lang.Object transform(java.lang.Object input){
                     return Integer.parseInt((String)input);
                   }
                 } ,listInt );
       return listInt;
	}
	
//	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		List<Integer> listint = null;
//		
//		listint = parseIntegerList(list, listint);
//		System.out.println(listint.getClass());
//		System.out.println(listint);
//	}

}
