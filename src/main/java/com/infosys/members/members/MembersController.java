package com.infosys.members.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class MembersController {

    private MembersService membersService;

    @Autowired
    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @PostMapping(value = "saveMember")
    public Members saveMember(@RequestBody Members members){
        System.out.println("Member has been added and persisted to the database");
        membersService.saveMember(members);
        return members;
    }

    @PutMapping(value = "updateMember")
    public Members updateMember(@RequestBody Members members){
        System.out.println("Member has been updated successfully");
        try {
            membersService.updateMember(members);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return members;
    }

@GetMapping(value = "/member/{id}")
public MemberResp memberInfo(@PathVariable int id){
    System.out.println("Member retrieved");
    try {
        MemberResp memberResp = new MemberResp(membersService.findById(id));
        return memberResp;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }



}
}
