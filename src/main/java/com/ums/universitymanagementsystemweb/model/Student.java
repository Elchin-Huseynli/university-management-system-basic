package com.ums.universitymanagementsystemweb.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    Long id;
    String name;
    String email;
    String subject;
    Integer status;
}
