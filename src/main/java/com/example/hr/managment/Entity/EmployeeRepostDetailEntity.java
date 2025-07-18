package com.example.hr.managment.Entity;

import com.example.hr.managment.Model.EmployeeRepostDetailModel;
import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee_repost_detail")
@Data
@NoArgsConstructor // ✅ Ensures a no-argument constructor is present
public class EmployeeRepostDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employee_name;
    private Date report_date;
    private Double one_month_repost;
    private Double three_month_repost;
    private Double six_month_repost;
    private Double twelve_month_repost;
    private Double years_repost;

   
    public EmployeeRepostDetailEntity(EmployeeRepostDetailModel model) {
        this.id = model.getId();  
        this.employee_name = model.getEmployee_name();
        this.report_date = model.getReport_date();
        this.one_month_repost = model.getOne_month_repost() != null ? model.getOne_month_repost() : 0.0;
        this.three_month_repost = model.getThree_month_repost() != null ? model.getThree_month_repost() : 0.0;
        this.six_month_repost = model.getSix_month_repost() != null ? model.getSix_month_repost() : 0.0;
        this.twelve_month_repost = model.getTwelve_month_repost() != null ? model.getTwelve_month_repost() : 0.0;
        this.years_repost = model.getYears_repost() != null ? model.getYears_repost() : 0.0;
    }
}
