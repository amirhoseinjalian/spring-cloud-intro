package com.jalian.dpartment.database;

import com.jalian.dpartment.entity.Department;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HardCodeDatabase {

    @Getter
    private static final List<Department> departments = List.of(
            new Department(1L, "department 1", "department 1", "1"),
            new Department(2L, "department 2", "department 2", "2"),
            new Department(3L, "department 3", "department 3", "3"),
            new Department(4L, "department 4", "department 4", "4"),
            new Department(5L, "department 5", "department 5", "5"),
            new Department(6L, "department 6", "department 6", "6"),
            new Department(7L, "department 7", "department 7", "7"),
            new Department(8L, "department 8", "department 8", "8"),
            new Department(9L, "department 9", "department 9", "9"),
            new Department(10L, "department 10", "department 10", "10"),
            new Department(11L, "department 11", "department 11", "11"),
            new Department(12L, "department 12", "department 12", "12")
    );
}
