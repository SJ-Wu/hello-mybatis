package org.example.hellomybatis;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class User {
    private Integer id;
    private String name;
    private BigDecimal balance;
}
