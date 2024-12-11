package org.example.hellomybatis.endpoint.vo;

import java.math.BigDecimal;

public record TransferVo(Long fromUserId, Long toUserId, BigDecimal amount) {
}
