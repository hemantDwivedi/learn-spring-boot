package com.project.webservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "UserDto Model Information"
)
public class UserDto {
    private Long id;
    @Schema(
            description = "User name"
    )
    @NotEmpty(message = "name should not be empty or null")
    private String name;
    @Schema(
            description = "User Email Address"
    )
    @Email(message = "email should be valid {example@gmail.com}")
    @NotEmpty(message = "email should not be empty or null")
    private String email;
}
