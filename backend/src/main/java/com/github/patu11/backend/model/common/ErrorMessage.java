package com.github.patu11.backend.model.common;

import java.time.LocalDateTime;

public record ErrorMessage(int status, String message, LocalDateTime timestamp) {
}
