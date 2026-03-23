package model;

public class Member {
    private int memberId;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String joinDate;
    private String status;

    public Member() {
    }

    public Member(int memberId, String fullName, String phone, String email, String address, String joinDate, String status) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.joinDate = joinDate;
        this.status = status;
    }

    public int getMemberId() {

        return memberId;
    }

    public void setMemberId(int memberId) {

        this.memberId = memberId;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}