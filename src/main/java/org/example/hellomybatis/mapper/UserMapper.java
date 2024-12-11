package org.example.hellomybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.hellomybatis.domain.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
