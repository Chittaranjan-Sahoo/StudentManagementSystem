package com.crs.www.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Student {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "stdno_seq1",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy=GenerationType.SEQUENCE)
	private Integer stdNo;
	private String stdNmae;
	private String course;
	private Double fees;
}
