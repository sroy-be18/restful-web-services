package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return List.of(new SomeBean("value4", "value5", "value6"), new SomeBean("value1","value2","value3"));
    }

    @GetMapping("/filtering-dynamic")
    public String filteringDynamic() throws JsonProcessingException {

        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider  filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        ObjectMapper obMapper = new ObjectMapper();
        obMapper.setFilterProvider(filters);
        return obMapper.writeValueAsString(someBean);
    }

    @GetMapping("/filtering-list-dynamic")
    @SuppressWarnings("removal")
    public MappingJacksonValue filteringListDynamic(){
        List<SomeBean> someBeans = List.of(new SomeBean("value4", "value5", "value6"), new SomeBean("value1", "value2", "value3"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeans);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
