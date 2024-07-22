package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value7", "value8", "value9"));
        //the second filed here is password filed and we used JsonIgnore for it, so it will not be part of response
    }

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue dynamicFiltering(){
        //dynamic filter is used here, so it will be applicable only for /dynamic-filtering and not others like it used to in above
        SomeBeanDynamicFiltering someBeanDynamicFiltering = new SomeBeanDynamicFiltering("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanDynamicFiltering);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanDynamicFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue dynamicFilteringList(){
        //dynamic filter is used here, so it will be applicable only for //dynamic-filtering-list and not others like it used to in above
        List<SomeBeanDynamicFiltering> list = Arrays.asList(
                new SomeBeanDynamicFiltering("value1", "value2", "value3"),
                new SomeBeanDynamicFiltering("value4", "value5", "value6"),
                new SomeBeanDynamicFiltering("value7", "value8", "value9"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","password");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanDynamicFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;

    }
}
