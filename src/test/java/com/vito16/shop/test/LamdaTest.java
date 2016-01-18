/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * muyu@yiji.com 2016-01-11 11:02 创建
 */
package com.vito16.shop.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/1/11
 */
public class LamdaTest {
    public static void main(String[] args) {
        List<Employee> employees = Lists.newArrayList(new Employee(),new Employee());
        Map<String, List<Employee>> employeesByCity =
                employees.stream().collect(groupingBy(Employee::getCity));
    }

    private static class Employee {
        String city;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
