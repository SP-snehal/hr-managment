package com.example.hr.managment.Service;

import com.example.hr.managment.Entity.EmployeeRepostDetailEntity;
import com.example.hr.managment.Model.EmployeeRepostDetailModel;
import com.example.hr.managment.Repository.EmployeeRepostDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRepostDetailImplService implements EmployeeRepostDetailService {

    @Autowired
    private EmployeeRepostDetailRepository repository;

    // 1️⃣ Add Employee Report
    @Override
    public Long addReport(EmployeeRepostDetailModel report) {
        EmployeeRepostDetailEntity entity = new EmployeeRepostDetailEntity();

        if (report != null && report.getId() == null) {
            entity.setId(0L);
            entity.setEmployee_name(report.getEmployee_name() != null ? report.getEmployee_name() : "");
            entity.setReport_date(report.getReport_date());
            entity.setOne_month_repost(report.getOne_month_repost() != null ? report.getOne_month_repost() : 0.0);
            entity.setThree_month_repost(report.getThree_month_repost() != null ? report.getThree_month_repost() : 0.0);
            entity.setSix_month_repost(report.getSix_month_repost() != null ? report.getSix_month_repost() : 0.0);
            entity.setTwelve_month_repost(report.getTwelve_month_repost() != null ? report.getTwelve_month_repost() : 0.0);
            entity.setYears_repost(report.getYears_repost() != null ? report.getYears_repost() : 0.0);
        }

        return repository.save(entity).getId();
    }

    // 2️⃣ Get All Employee Reports
    @Override
    public List<EmployeeRepostDetailModel> getAllReports() {
        List<EmployeeRepostDetailModel> response = new ArrayList<>();
        List<EmployeeRepostDetailEntity> entityList = repository.findAll();

        if (!entityList.isEmpty()) {
            for (EmployeeRepostDetailEntity entity : entityList) {
                EmployeeRepostDetailModel report = new EmployeeRepostDetailModel();
                report.setId(entity.getId());
                report.setEmployee_name(entity.getEmployee_name());
                report.setReport_date(entity.getReport_date());
                report.setOne_month_repost(entity.getOne_month_repost());
                report.setThree_month_repost(entity.getThree_month_repost());
                report.setSix_month_repost(entity.getSix_month_repost());
                report.setTwelve_month_repost(entity.getTwelve_month_repost());
                report.setYears_repost(entity.getYears_repost());

                response.add(report);
            }
        }
        return response;
    }

    // 3️⃣ Get Report by ID
    @Override
    public EmployeeRepostDetailModel getReportById(Long resourceId) {
        Optional<EmployeeRepostDetailEntity> request = repository.findById(resourceId);
        
        if (request.isPresent()) {
            EmployeeRepostDetailEntity entity = request.get();
            EmployeeRepostDetailModel response = new EmployeeRepostDetailModel();
            
            response.setId(entity.getId());
            response.setEmployee_name(entity.getEmployee_name());
            response.setReport_date(entity.getReport_date());
            response.setOne_month_repost(entity.getOne_month_repost());
            response.setThree_month_repost(entity.getThree_month_repost());
            response.setSix_month_repost(entity.getSix_month_repost());
            response.setTwelve_month_repost(entity.getTwelve_month_repost());
            response.setYears_repost(entity.getYears_repost());

            return response;
        }
        return null; // If not found, return null or handle with exception
    }

    // 4️⃣ Update Report
    @Override
    public String updateReport(EmployeeRepostDetailModel report) {
        if (report != null) {
            Optional<EmployeeRepostDetailEntity> request = repository.findById(report.getId());

            if (request.isPresent()) {
                EmployeeRepostDetailEntity entity = request.get();

                entity.setEmployee_name(report.getEmployee_name());
                entity.setReport_date(report.getReport_date());
                entity.setOne_month_repost(report.getOne_month_repost());
                entity.setThree_month_repost(report.getThree_month_repost());
                entity.setSix_month_repost(report.getSix_month_repost());
                entity.setTwelve_month_repost(report.getTwelve_month_repost());
                entity.setYears_repost(report.getYears_repost());

                repository.save(entity);
                return "Report updated successfully";
            }
        }
        return "Update failed: Report not found";
    }

    // 5️⃣ Delete Report by ID
    @Override
    public String deleteReportById(Long resourceId) {
        if (repository.existsById(resourceId)) {
            repository.deleteById(resourceId);
            return "Report with ID " + resourceId + " deleted successfully.";
        }
        return "Report with ID " + resourceId + " does not exist.";
    }
}
