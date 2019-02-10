package com.alu.scaffold.web;

import com.alibaba.fastjson.serializer.ValueFilter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseValueFilter implements ValueFilter {
    public static final List<ValueFilter> VALUE_FILTERS = new ArrayList<>();

    @PostConstruct
    public void init() {
        VALUE_FILTERS.add(this);
    }
}