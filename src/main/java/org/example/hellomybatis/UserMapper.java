package org.example.hellomybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(@Param("id") Long id);

    @Update("UPDATE users SET balance = balance - #{amount} WHERE id = #{fromUserId} AND balance >= #{amount}")
    int deductBalance(@Param("fromUserId") Long fromUserId, @Param("amount") BigDecimal amount);

    @Update("UPDATE users SET balance = balance + #{amount} WHERE id = #{toUserId}")
    void addBalance(@Param("toUserId") Long toUserId, @Param("amount") BigDecimal amount);
}
