package com.paul.spark.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Statistic implements Serializable {
    private String user_id;
    private String engagement_name;
    private Long consultations_count;
    private Date date;
}
