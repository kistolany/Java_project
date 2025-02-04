package com.tolany.java.Java_project.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tolany.java.Java_project.utils.GeneralUtils;

public class GeneralUtilsTest {
	
	private List<Integer> integerList;

	//@Test
	public void testToint() {
		List<String> names=List.of("dara","Thai","cheata");
		 List<Integer> list = GeneralUtils.toIntegerList(names);
		 
		 assertEquals(3, list.size());
		 assertEquals(4, list.get(0));
		 assertEquals(4, list.get(1));
		 assertEquals(6, list.get(2));
		
	}
	//@Test
	public void testgetEvenNumber() {
		//giving
		List<Integer> list = List.of(4,5,3,22);
		//when
		List<Integer> number = GeneralUtils.getEvenNumber(list);
		//then
		assertEquals(2, number.size());
		 assertEquals(4, number.get(0));
//		 assertEquals(22, list.get(1));
//		 assertEquals(3, list.get(2));
		 assertEquals(22, list.get(3));
	}

}
