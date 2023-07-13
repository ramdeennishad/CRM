package com.crmproject.Dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private Long id;
    @NotNull
    @NotEmpty(message = "Required")
    private String firstName;
    @NotNull
    @NotEmpty(message = "Required")
    private String lastName;
    @NotNull
    @NotEmpty(message = "Required")
    @Email(message = "Invalid email")
    private String email;
    @NotNull
    @NotEmpty(message = "Required")
    @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
    private String mobile;
    @NotNull
    @NotEmpty(message = "Required")
    private String source;
}
