package com.sugar.domain.type;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户位置
 */
@Builder
@Data
public class Location {

    private String latitude;
    private String longitude;
}
