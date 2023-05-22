package com.faa.controller;
import com.faa.models.Member;
import com.faa.services.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(path = "/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @PostMapping(path = "/addMember")
    public Member addMember(@RequestBody Member member){
        return memberService.addMember(member);
    }

    @PutMapping(path = "{id}")
    public Member updateProduct(@RequestBody Member memberToUpdate, @PathVariable(name = "id") Integer id) {
        return memberService.updateMember(memberToUpdate, id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMember(@PathVariable(name = "id") Integer id) {
        memberService.deleteMember(id);
    }
    @PostMapping(path = "/getAllMembers")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }
    @GetMapping(path = "{id}")
    public Member getMember(@PathVariable(name = "id") Integer id) {
        return memberService.getMember(id);
    }



    @GetMapping(path = "/test")
    public@ResponseBody String tester(@RequestParam String name){
        return "Test Complete";
    }
}
