package com.faa.services;

import com.faa.models.Member;
import com.faa.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;
    public Member addMember(Member member){
        return memberRepo.save(member);
    }

    public List<Member> getAllMembers() {
        return  memberRepo.findAll();
    }

    public Member getMember(Integer id) {
        return memberRepo.findById(id).get();
    }

    public Member updateMember(Member memberToUpdate, Integer id) {
        Member foundMember = memberRepo.findById(id).get();
        try {
            foundMember.setMember_program_id(foundMember.getMember_program_id());
            foundMember.setMember_id(memberToUpdate.getMember_id());
            foundMember.setMember_first_name(memberToUpdate.getMember_first_name());
            foundMember.setMember_last_name(memberToUpdate.getMember_last_name());
            return memberRepo.save(foundMember);
        } catch (Exception e) {

        }
        return foundMember;
    }

    public void deleteMember(Integer id) {
        memberRepo.deleteById(id);
    }
}
