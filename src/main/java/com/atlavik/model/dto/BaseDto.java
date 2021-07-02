package com.atlavik.model.dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseDto implements Serializable {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int deleted;
    private Long version;
}
