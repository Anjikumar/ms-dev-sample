package com.techm.ms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample {

	public static void main(String[] args) {
		List<String> bigList = new ArrayList<>();
		bigList.add("Anji1");
		bigList.add("Anji2");
		bigList.add("Anji13");
		bigList.add("Anji4");
		bigList.add("Anji5");
		
		
		List<String> smallList = new ArrayList<>();
		smallList.add("Anji1");
		smallList.add("Anji2");

		
		List<String> filered  = bigList.stream()
	            .filter(e -> smallList.contains(e))
	            .collect(Collectors.toList());
		
		
		filered.forEach(name -> System.out.println(name));
		
		
	}
}
