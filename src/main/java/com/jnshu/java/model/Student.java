package com.jnshu.java.model;

public class Student {

    private long id;
    private String username;
    private String name;
    private String qq;
    private String profession;
    private long createAt;
    private long updateAt;
    private String school;
    private String studentId;
    private String url;
    private String declaration;
    private String matchmaker;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getMatchmaker() {
        return matchmaker;
    }

    public void setMatchmaker(String matchmaker) {
        this.matchmaker = matchmaker;
    }

    @Override
    public String toString() {
        return "Students [id=" + id + ", username=" + username + ", name=" + name + ", qq=" + qq + ", profession="
                + profession + ", school=" + school + ", studentId=" + studentId + ", url=" + url + ", declaration="
                + declaration + ", matchmaker=" + matchmaker + "]";
    }

}
