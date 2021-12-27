package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tv {
    private int id;
    private Integer pno;
    private String brand;
    private BigDecimal price;
    private Double size;
    private Date sell;


}
