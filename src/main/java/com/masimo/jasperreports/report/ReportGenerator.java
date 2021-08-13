package com.masimo.jasperreports.report;

import com.masimo.jasperreports.model.Compliance;
import com.masimo.jasperreports.model.Employee;
import com.masimo.jasperreports.services.EmployeeService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReportGenerator {
    @Value("${pdfReport.dir}")
    private String pdfDir;

    @Value("${pdfReport.fileName}")
    private String reportFileName;

    @Value("${pdfReport.fileNameDateFormat}")
    private String reportFileNameDateFormat;

    @Autowired
    EmployeeService employeeService;

    public String employeeReport() throws FileNotFoundException, JRException {
        List<Employee> employeeList = employeeService.getEmployees();
        List<Compliance> complianceList = employeeService.getCompliance();

        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(reportFileNameDateFormat));

        //Load jrxml file and compile it
        File file = ResourceUtils.getFile("classpath:blank_A4.jrxml");
        //Compile report
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        //Get the data and map it to the report
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(complianceList);

        //Fill and print
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("patientName", "Rahul Ganta");
        parameters.put("domain", "South Hall, Floor 2");
        parameters.put("duration", "April 2, 2017 22:43:23");
        parameters.put("admit", "April 2, 2017 7:11:21 PM");

        parameters.put("numOfFalls", 2);
        parameters.put("timeOutOfCompliance", "14.5%");
        parameters.put("totalTurns", 16);

        parameters.put("employeeDataSource", new JRBeanCollectionDataSource(employeeList));
        parameters.put("pieChartDataSource", new JRBeanCollectionDataSource(complianceList));


        //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfDir+reportFileName+"-"+localDateString+".pdf");

        return "PDF report generated successfully!!";
    }


}
