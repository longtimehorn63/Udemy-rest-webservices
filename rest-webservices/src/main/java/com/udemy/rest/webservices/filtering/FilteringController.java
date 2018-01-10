package com.udemy.rest.webservices.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean(){
		return new SomeBean("value1", "Value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListSomeBean(){
		List<SomeBean> result = new ArrayList<>();
		result.add(new SomeBean("valueA", "ValueB","valueC"));
		result.add(new SomeBean("value1", "Value2","value3"));
		result.add(new SomeBean("value4", "Value5","value6"));
		return result;
	}
	
	@GetMapping("/dynamic-filtering")
	// only return field1 and field2
	public MappingJacksonValue retrieveSomeBean2(){
		SomeBean2 bean =  new SomeBean2("value1", "Value2","value3");
//		MappingJacksonValue mapping = new MappingJacksonValue(bean);
//		
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
//		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean2Filter", filter );
//		mapping.setFilters(filters);
		

		String[] filterfields = {"field2","field3"};
		MappingJacksonValue mapping = createFilter(bean, filterfields);
		return mapping;
	}
	
	@GetMapping("/dynamic-filtering-list")
	// only return field1
	public MappingJacksonValue retrieveListSomeBean2(){
		List<SomeBean2> result =  Arrays.asList(
				new SomeBean2("valueA", "ValueB","valueC"),
				new SomeBean2("value1", "Value2","value3"),
				new SomeBean2("value4", "Value5","value6"));
//		MappingJacksonValue mapping = new MappingJacksonValue(result);
//		
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
//		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean2Filter", filter );
//		mapping.setFilters(filters);
		
		String[] filterfields = {"field1"};
		MappingJacksonValue mapping = createFilter(result, filterfields);
		return mapping;
	}
	
	private MappingJacksonValue createFilter(Object object, String... fields){
		MappingJacksonValue mapping = new MappingJacksonValue(object);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean2Filter", filter );
		mapping.setFilters(filters);
		return mapping;
	}
}
