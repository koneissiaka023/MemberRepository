package com.infosys.members.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Predicate;


@Service
public class MembersService{

    private MemberRepository memberRepository;

    @Autowired
    public MembersService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Members saveMember(Members member){
        return memberRepository.save(member);
    }

    @Transactional
    public void updateMember(Members members) throws Exception{
        Members member = memberRepository.findById(members.getId()).orElseThrow(Exception::new);
        Predicate<String> notNullOrEmpty = (str) -> str != null && !str.trim().equals("");

        if(notNullOrEmpty.test(members.getFirstName()))
            member.setFirstName(members.getFirstName());

        if(notNullOrEmpty.test(members.getLastName()))
            member.setLastName(members.getLastName());

        if(notNullOrEmpty.test(members.getEmail()))
            member.setEmail(members.getEmail());

        if(notNullOrEmpty.test(members.getAddress()))
            member.setAddress(members.getAddress());

        if(notNullOrEmpty.test(members.getPhoneNumber()))
            member.setPhoneNumber(members.getPhoneNumber());


    }

    @Transactional(readOnly = true)
    public Members findById(int id) throws Exception{
        Members member = memberRepository.findById(id).orElseThrow(Exception::new);
        return member;
    }
}
