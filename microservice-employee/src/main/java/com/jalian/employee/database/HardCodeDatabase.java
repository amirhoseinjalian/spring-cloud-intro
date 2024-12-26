package com.jalian.employee.database;

import com.jalian.employee.entity.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HardCodeDatabase {

    @Getter
    private static final List<Employee> employees = List.of(
            new Employee("aj 1", "1234", "FE 1", "LE 1", "e1@gmail.com", 1L),
            new Employee("aj 2", "1234", "FE 2", "LE 2", "e2@gmail.com", 2L),
            new Employee("aj 3", "1234", "FE 3", "LE 3", "e3@gmail.com", 3L),
            new Employee("aj 4", "1234", "FE 4", "LE 4", "e4@gmail.com", 4L),
            new Employee("aj 5", "1234", "FE 5", "LE 5", "e5@gmail.com", 5L),
            new Employee("aj 6", "1234", "FE 6", "LE 6", "e6@gmail.com", 6L),
            new Employee("aj 7", "1234", "FE 7", "LE 7", "e7@gmail.com", 7L),
            new Employee("aj 8", "1234", "FE 8", "LE 8", "e8@gmail.com", 8L),
            new Employee("aj 9", "1234", "FE 9", "LE 9", "e9@gmail.com", 9L),
            new Employee("aj 10", "1234", "FE 10", "LE 10", "e10@gmail.com", 10L),
            new Employee("aj 11", "1234", "FE 11", "LE 11", "e11@gmail.com", 11L),
            new Employee("aj 12", "1234", "FE 12", "LE 12", "e12@gmail.com", 12L)
    );
}
