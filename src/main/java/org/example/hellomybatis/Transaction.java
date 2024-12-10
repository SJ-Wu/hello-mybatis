package org.example.hellomybatis;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;
}
