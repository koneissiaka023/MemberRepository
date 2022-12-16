package com.infosys.members.members;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberResp {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private String phoneNumber;

    private String address;

    public MemberResp(Members members){
        this.id = members.getId();
        this.firstName = members.getFirstName();
        this.lastName = members.getLastName();
        this.email = members.getEmail();
        this.age = members.getAge();
        this.phoneNumber = members.getPhoneNumber();
        this.address = members.getAddress();
    }
}
