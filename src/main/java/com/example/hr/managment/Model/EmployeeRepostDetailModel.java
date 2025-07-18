package com.example.hr.managment.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;


import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Data
@NoArgsConstructor
public class EmployeeRepostDetailModel {
  private Long id;
  private String employee_name;
    private Date report_date;
    private Double one_month_repost;
    private Double three_month_repost;
    private Double six_month_repost;
    private Double twelve_month_repost;
    private Double years_repost;
}
