package com.sjw.v2.service;

import java.util.Comparator;

import com.sjw.v2.entity.Customer;



/**
 * @Author Kulen
 * @CreateTime 2010-5-12下午03:26:02
 * @Version 1.0
 * @Explanation 
 */
public class CustomerComparator implements Comparator<Customer>{	
	
	public int compare(Customer customer1, Customer customer2) {
		if (customer1.getId().longValue() < customer2.getId().longValue()) {
			return -1;
		} else if (customer1.getId().longValue() == customer2.getId().longValue()) {
			return 0;
		}
		return 1;
	}
	
}
