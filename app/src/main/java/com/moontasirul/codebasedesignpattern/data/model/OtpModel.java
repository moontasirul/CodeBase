package com.moontasirul.codebasedesignpattern.data.model;

public class OtpModel {

    private String firstDigit;
    private String secondDigit;
    private String thirdDigit;
    private String fourthDigit;
    private String fithDigit;

    public OtpModel(String firstDigit, String secondDigit, String thirdDigit, String fourthDigit, String fithDigit) {
        this.firstDigit = firstDigit;
        this.secondDigit = secondDigit;
        this.thirdDigit = thirdDigit;
        this.fourthDigit = fourthDigit;
        this.fithDigit = fithDigit;
    }

    public String getFirstDigit() {
        return firstDigit;
    }

    public void setFirstDigit(String firstDigit) {
        this.firstDigit = firstDigit;
    }

    public String getSecondDigit() {
        return secondDigit;
    }

    public void setSecondDigit(String secondDigit) {
        this.secondDigit = secondDigit;
    }

    public String getThirdDigit() {
        return thirdDigit;
    }

    public void setThirdDigit(String thirdDigit) {
        this.thirdDigit = thirdDigit;
    }

    public String getFourthDigit() {
        return fourthDigit;
    }

    public void setFourthDigit(String fourthDigit) {
        this.fourthDigit = fourthDigit;
    }

    public String getFithDigit() {
        return fithDigit;
    }

    public void setFithDigit(String fithDigit) {
        this.fithDigit = fithDigit;
    }
}
