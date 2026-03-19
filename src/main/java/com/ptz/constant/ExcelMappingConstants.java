package com.ptz.constant;

import java.util.Map;

public class ExcelMappingConstants {

    public static final Map<String, String> EMPLOYEE_FIELD_MAPPING = Map.of(
        "EMP_1", "id",
        "EMP_2", "name",
        "EMP_3", "age",
        "EMP_4", "position"
    );

    public static final Map<String, String> TIME_FIELD_MAPPING = Map.of(
            "Current Time", "currentTime"
    );
}
