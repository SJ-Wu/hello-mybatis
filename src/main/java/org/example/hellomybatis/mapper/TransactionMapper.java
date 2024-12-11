package org.example.hellomybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.hellomybatis.domain.Transaction;

@Mapper
public interface TransactionMapper extends BaseMapper<Transaction> {
}
