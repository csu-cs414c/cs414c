package com.example.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class WebMenu {
	static String pizzaquantity = null;
	static String pizzaname = null;
	static Set<String> pizzatoppingsel = new HashSet<String>();
	static String pizzabasename = null;
	static String addonname = null;
	static String addonquantity = null;
	static String drinkname = null;
	static String drinkquantity = null;
	static Set<String> pizzabase = new HashSet<String>(); 
	static Set<String> pizzatoppings = new HashSet<String>();
	static Set<String> pizza = new HashSet<String>();
	//static Map<String, Set<String>> toppingsforpizza = new HashMap<String, Set<String>>();	
	static Multimap<String, String> toppingsforapizza = HashMultimap.create();
}
