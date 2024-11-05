package org.example.service;

import java.util.*;

public class DepartmentSortService {

    public static Set<String> addDepartmentsInSet(String[] departments) {
        Set<String> departmentsSet = new HashSet<>(Arrays.asList(departments));
        for (String department : departments) {
            String[] allPartsOneDepartment = department.split("\\\\");
            StringBuilder departmentPath = new StringBuilder();

            for (int i = 0; i < allPartsOneDepartment.length; i++) {
                if (i > 0) departmentPath.append("\\");
                departmentPath.append(allPartsOneDepartment[i]);
                departmentsSet.add(departmentPath.toString());
            }
        }
        return departmentsSet;
    }

    public static List<String> sortDepartments(Set<String> departmentsSet) {
        List<String> departmentsSorted = new ArrayList<>(departmentsSet);

        departmentsSorted.sort((dep1, dep2) -> {
            String[] dep1Levels  = dep1.split("\\\\");
            String[] dep2Levels  = dep2.split("\\\\");

            int topLevelComparison = dep2Levels [0].compareTo(dep1Levels [0]);
            if (topLevelComparison  != 0) {
                return topLevelComparison ;
            }

            if (dep1Levels .length != dep2Levels .length) {
                return Integer.compare(dep1Levels .length, dep2Levels .length);
            }

            return dep1.compareTo(dep2);
        });

        return departmentsSorted;
    }
}
