package org.example.hellomybatis.endpoint;

import lombok.RequiredArgsConstructor;
import org.example.hellomybatis.service.TransferService;
import org.example.hellomybatis.domain.Transaction;
import org.example.hellomybatis.endpoint.vo.TransferVo;
import org.example.hellomybatis.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferVo transferVo) {
        try {
            transferService.transfer(transferVo.fromUserId(), transferVo.toUserId(), transferVo.amount());
            return "轉帳成功";
        } catch (Exception e) {
            return "轉帳失敗" + e.getMessage();
        }
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        transferService.createUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return transferService.getUser(userId);
    }

    @GetMapping("/user/{userId}/transactions")
    public ResponseEntity<User> getUserWithTransactions(@PathVariable Long userId) {
        return ResponseEntity.ok(transferService.getUserWithTransactions(userId));
    }

    @PostMapping("/user/{userId}/transactions")
    public void createTransaction(@PathVariable Long userId, @RequestBody Transaction transaction) {
        transaction.setUserId(userId);
        transferService.createTransaction(transaction);
    }
}
