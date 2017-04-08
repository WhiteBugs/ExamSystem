package com.gdut.ExamSystem.model;

public class AdminstratorWithBLOBs extends Adminstrator {
    private byte[] safequestion;

    private byte[] safeanswer;

    public byte[] getSafequestion() {
        return safequestion;
    }

    public void setSafequestion(byte[] safequestion) {
        this.safequestion = safequestion;
    }

    public byte[] getSafeanswer() {
        return safeanswer;
    }

    public void setSafeanswer(byte[] safeanswer) {
        this.safeanswer = safeanswer;
    }
}