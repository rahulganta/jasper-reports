package com.masimo.jasperreports.controller;

import com.masimo.jasperreports.report.ReportGenerator;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "/api/reports")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ReportsController {
    @Autowired
    ReportGenerator reportGenerator;

    @GetMapping("/")
    public String getEmployeeReport() throws FileNotFoundException, JRException {
        String msg = reportGenerator.employeeReport();
        return msg;
    }

    @GetMapping("/jfree")
    public void getJfreeChartReport() {
    }
}
