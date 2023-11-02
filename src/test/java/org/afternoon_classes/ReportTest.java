package org.afternoon_classes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getReportTypeTest() throws Exception {
        String invalidInput = "test";
        String emptyInput = "";
        String validInput = "Employee";
        String longInput = "dfjghkjdhlkjöjköj jasdhfgkusdghfkgas dshfosdhfseöadhf hfgfjdsgjgjhgj dfhvbdfkhgksgfkdjgkfjsdkgfskdjgfkwdsgfkjgksdgfksdjygxfsdjhygxfjsdgyfjhgjshdbgfj";
        assertEquals(ReportType.EMPLOYEE, Report.getReportType(validInput));
        Exception exception1 = assertThrows(Exception.class, () -> {
            Report.getReportType(invalidInput);
        });
        assertEquals(exception1.getMessage(), "Report type is not valid.");
        Exception exception2 = assertThrows(Exception.class, () -> {
            Report.getReportType(emptyInput);
        });
        assertEquals(exception2.getMessage(), "Report type is not valid.");
        Exception exception3 = assertThrows(Exception.class, () -> {
            Report.getReportType(longInput);
        });
        assertEquals(exception3.getMessage(), "Report type is not valid.");
    }
}