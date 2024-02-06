package com.kitri.springbasicboot.project.login;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginService {
    static HashMap<String, Member> members = new HashMap<>();
    static {
        members.put("kitri@naver.com", new Member("kitri@naver.com", "키트리", "kitri01!"));
    }

    public boolean isDuplicated(SignUpFormDto form) {
        return members.get(form.getEmail()) != null ? true : false;
    }

    public boolean isPasswordsSame(SignUpFormDto form) {
        return form.getPassword().equals(form.getPassword2());
    }

    public void joinMember(SignUpFormDto form) {
        members.put(form.getEmail(), new Member(form.getEmail(), form.getName(), form.password));
    }

    public Member getMember(String member) {
        return members.get(member);
    }

    public Member getMember(SignUpFormDto form) {
        return members.get(form.getEmail());
    }

    public boolean login(LoginDto loginDto) {
        Member member = members.get(loginDto.getEmail());
        if (member == null) return false;
        if (member.getPassword().equals(loginDto.getPassword())) return true;
        return false;
    }
}
