package com.example.dio.dto.response;

import com.example.dio.enums.TableStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableResponse {

    private long id;

    private long tableNo;

    private long tableCapacity;

    private TableStatus status;
}
