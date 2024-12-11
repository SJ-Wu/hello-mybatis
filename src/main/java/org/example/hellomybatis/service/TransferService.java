package org.example.hellomybatis.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hellomybatis.domain.Transaction;
import org.example.hellomybatis.domain.User;
import org.example.hellomybatis.mapper.TransactionMapper;
import org.example.hellomybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransferService {
    private final UserMapper userMapper;
    private final TransactionMapper transactionMapper;

    @Transactional
    public void transfer(Long fromUserId, Long toUserId, BigDecimal amount) {
        var fromUser = userMapper.selectById(fromUserId);
        if (fromUser == null || fromUser.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("餘額不足或用戶不存在");
        }
        fromUser.setBalance(fromUser.getBalance().subtract(amount));
        userMapper.updateById(fromUser);

        var toUser = userMapper.selectById(toUserId);
        if (toUser == null) {
            throw new RuntimeException("收款人不存在");
        }
        toUser.setBalance(toUser.getBalance().add(amount));
        userMapper.updateById(toUser);

        Transaction debitTransaction = new Transaction();
        debitTransaction.setUserId(fromUserId);
        debitTransaction.setAmount(amount.negate());
        debitTransaction.setDescription("Transfer to user " + toUserId);
        debitTransaction.setTransactionDate(LocalDateTime.now());
        transactionMapper.insert(debitTransaction);

        Transaction creditTransaction = new Transaction();
        creditTransaction.setUserId(toUserId);
        creditTransaction.setAmount(amount);
        creditTransaction.setDescription("Transfer from user " + fromUserId);
        creditTransaction.setTransactionDate(LocalDateTime.now());
        transactionMapper.insert(creditTransaction);
    }

    public User getUser(Long userId) {
        return userMapper.selectById(userId);
    }

    public void createUser(User user) {
        userMapper.insert(user);
        log.info("Create user {}", user);
    }

    public void createTransaction(Transaction transaction) {
        transactionMapper.insert(transaction);
        log.info("Create transaction {}", transaction);
    }

    public User getUserWithTransactions(Long userId) {
        var user = userMapper.selectById(userId);
        if (user != null) {
            var queryWrapper = new QueryWrapper<Transaction>();
            queryWrapper.eq("user_id", userId);
            user.setTransactions(transactionMapper.selectList(queryWrapper));
        }
        return user;
    }
}
