package org.example;

import java.util.Set;

import static org.example.service.DepartmentSortService.addDepartmentsInSet;
import static org.example.service.DepartmentSortService.sortDepartments;

public class App 
{
    public static void main( String[] args )
    {
        String[] departments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };

        Set<String> allDepartments = addDepartmentsInSet(departments);

        sortDepartments(allDepartments).forEach(System.out::println);
    }
}
