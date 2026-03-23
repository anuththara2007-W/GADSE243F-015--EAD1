package controller;

import dao.MemberDAO;
import model.Member;

import java.util.List;

public class MemberController {
    private MemberDAO dao = new MemberDAO();

    public boolean addMember(Member m) {
        return dao.addMember(m);
    }

    public boolean updateMember(Member m) {
        return dao.updateMember(m);
    }

    public boolean deleteMember(int id) {
        return dao.deleteMember(id);
    }

    public List<Member> getAllMembers() {
        return dao.getAllMembers();
    }
}