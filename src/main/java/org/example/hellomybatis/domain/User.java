package org.example.hellomybatis.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@TableName("users")
@Data
public class User {
    @TableId(type = AUTO)
    private Long id;
    private String name;
    private BigDecimal balance;

    @TableField(exist = false)
    private List<Transaction> transactions;
}
