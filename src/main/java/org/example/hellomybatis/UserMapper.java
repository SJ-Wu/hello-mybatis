package org.example.hellomybatis;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface UserMapper {
    User findById(Long id);
    int deductBalance(Long fromUserId, BigDecimal amount);
    void addBalance(Long toUserId, BigDecimal amount);

    User findUserWithTransactions(Long id);
}
