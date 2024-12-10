package org.example.hellomybatis;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private BigDecimal balance;
    private List<Transaction> transactions;
}
