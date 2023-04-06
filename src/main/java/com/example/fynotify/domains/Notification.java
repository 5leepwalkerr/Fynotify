package com.example.fynotify.domains;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {
    Long id;
    String notification;
    Instant createdAt = Instant.now();
}
