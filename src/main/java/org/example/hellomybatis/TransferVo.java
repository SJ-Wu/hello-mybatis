package org.example.hellomybatis;

import java.math.BigDecimal;

public record TransferVo(Long fromUserId, Long toUserId, BigDecimal amount) {
}
