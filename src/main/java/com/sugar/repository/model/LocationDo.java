package com.sugar.repository.model;

import com.sugar.domain.type.Location;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户位置
 */
@javax.persistence.Entity
@Table(name = "sugar.process")
@Data
public class LocationDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String latitude;
    private String longitude;

    public Location map() {
        return Location.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
