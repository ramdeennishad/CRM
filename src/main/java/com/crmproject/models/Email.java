package com.crmproject.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @NotEmpty(message = "Required")
    @NotNull
    @jakarta.validation.constraints.Email(message="Invalid email")
    private String to;
    @NotNull
    @NotEmpty(message = "Required")
    private String subject;

    @NotNull
    @NotEmpty(message = "Required")
    private String body;
}