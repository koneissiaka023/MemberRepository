package com.infosys.members.members;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member", catalog = "memberschema")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Cannot not be empty")
    @NotNull(message = "Cannot not be null")
    private String firstName;

    @NotEmpty(message = "Cannot not be empty")
    @NotNull(message = "Cannot not be null")
    private String lastName;

    @NotEmpty(message = "Cannot not be empty")
    @NotNull(message = "Cannot not be null")
    private String email;


    private int age;

    @NotEmpty(message = "Cannot not be empty")
    @NotNull(message = "Cannot not be null")
    private String phoneNumber;

    @NotEmpty(message = "Cannot not be empty")
    @NotNull(message = "Cannot not be null")
    private String address;


}
