package org.example.hellomybatis.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@TableName("transactions")
@Data
public class Transaction {
    @TableId(type = AUTO)
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;
}
