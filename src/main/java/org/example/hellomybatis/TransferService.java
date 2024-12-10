package org.example.hellomybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class TransferService {
    private final UserMapper userMapper;

    @Transactional
    public void transfer(Long fromUserId, Long toUserId, BigDecimal amount) {
        var updateRows = userMapper.deductBalance(fromUserId, amount);
        if (updateRows == 0) {
            throw new RuntimeException("餘額不足或用戶不存在");
        }
        userMapper.addBalance(toUserId, amount);
    }

    public User getUser(Long userId) {
        return userMapper.findById(userId);
    }
}
