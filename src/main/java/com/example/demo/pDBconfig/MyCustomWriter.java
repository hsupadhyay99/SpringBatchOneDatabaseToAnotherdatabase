package com.example.demo.pDBconfig;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.secondary.Manager;
import com.example.demo.secondary.ManagerRepository;

@Component
public class MyCustomWriter implements ItemWriter<Manager> {
	
	@Autowired(required=true)
	ManagerRepository managerRepository ;
	
	@Override
	public void write(List<? extends Manager> list) throws Exception {
		for (Manager data : list) {
			System.out.println("MyCustomWriter    : Writing data    : " + data.getId()+" : "+data.getName()+" : "+data.getSalary());
			managerRepository.save(data);
		}
	}
}