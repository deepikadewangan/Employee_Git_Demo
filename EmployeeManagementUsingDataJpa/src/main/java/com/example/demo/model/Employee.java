package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cts_emp_info")
@Data //@Setter @Getter @Required @EqualsAndhashCode @ToString @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@Column(name="empno")
	@Min(value = 1, message = "Employee Id connnot be negative")
	private int empId;
	@NotBlank(message = "Name cannot be empty/blanl/null")
	@Column(name="ename", nullable = false, length = 10)
	@Size(min = 6, max = 15, message = "name length must be 6-15")
	private String empName;
	@Min(value = 10000, message = "salary cannot be below 10000")
	@Max(value = 100000, message = "salary cannot be abovr 100000")
	private int empSal;
	@NotEmpty(message = "Designation cannot null/empty")
	private String empDesg;
	

}

