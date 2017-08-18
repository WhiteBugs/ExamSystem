package com.gdut.ExamSystem.model;

public class MultipleChoiceQuestion {
    private Integer multipleChoiceQuestionId;

    private String choice1;

    private String choice2;

    private String choice3;

    private String choice4;

    private String answer;

    private String titlt;

    public Integer getMultipleChoiceQuestionId() {
        return multipleChoiceQuestionId;
    }

    public void setMultipleChoiceQuestionId(Integer multipleChoiceQuestionId) {
        this.multipleChoiceQuestionId = multipleChoiceQuestionId;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1 == null ? null : choice1.trim();
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2 == null ? null : choice2.trim();
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3 == null ? null : choice3.trim();
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4 == null ? null : choice4.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getTitlt() {
        return titlt;
    }

    public void setTitlt(String titlt) {
        this.titlt = titlt == null ? null : titlt.trim();
    }
}