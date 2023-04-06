package com.example.fynotify.domains;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    Long id;
    String name;
    Instant createdAt = Instant.now();
}
