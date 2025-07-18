package com.example.hr.managment.Service;

import com.example.hr.managment.Model.EmployeeRepostDetailModel;
import java.util.List;

public interface  EmployeeRepostDetailService {
  
  Long addReport(EmployeeRepostDetailModel report);
    List<EmployeeRepostDetailModel> getAllReports();
    EmployeeRepostDetailModel getReportById(Long resourceId);
    String updateReport(EmployeeRepostDetailModel report);
    String deleteReportById(Long resourceId);
}
