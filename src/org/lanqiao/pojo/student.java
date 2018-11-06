package org.lanqiao.pojo;

import java.util.Objects;

public class student {
    private int sid;
    private String sname;
    private int sage;
    private String sprovince;
    private int stuition;

    public student(){

    }

    public student(String sname, int sage, String sprovince, int stuition) {
        this.sname = sname;
        this.sage = sage;
        this.sprovince = sprovince;
        this.stuition = stuition;
    }

    public student(int sid, String sname, int sage, String sprovince, int stuition) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.sprovince = sprovince;
        this.stuition = stuition;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSprovince() {
        return sprovince;
    }

    public void setSprovince(String sprovince) {
        this.sprovince = sprovince;
    }

    public int getStuition() {
        return stuition;
    }

    public void setStuition(int stuition) {
        this.stuition = stuition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return sid == student.sid &&
                sage == student.sage &&
                stuition == student.stuition &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(sprovince, student.sprovince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, sage, sprovince, stuition);
    }

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sprovince='" + sprovince + '\'' +
                ", stuition=" + stuition +
                '}';
    }
}
