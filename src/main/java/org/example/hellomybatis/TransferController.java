package org.example.hellomybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    public String transfer(@RequestBody TransferVo transferVo) {
        try {
            transferService.transfer(transferVo.fromUserId(), transferVo.toUserId(), transferVo.amount());
            return "轉帳成功";
        } catch (Exception e) {
            return "轉帳失敗" + e.getMessage();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(transferService.getUser(userId));
    }

    @GetMapping("/user/{userId}/transactions")
    public ResponseEntity<User> getUserWithTransactions(@PathVariable Long userId) {
        return ResponseEntity.ok(transferService.getUserWithTransactions(userId));
    }
}
