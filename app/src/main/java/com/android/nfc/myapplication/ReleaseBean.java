package com.android.nfc.myapplication;

/**
 * @ClassName: ReleaseBean
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/13
 */
public class ReleaseBean {
    private String admin;
    private String license;
    private String idCard;
    private String phone;
    private int persons;
    private String checkPoint;
    private String entryTime;
    private float delayTime;
    private boolean isRelease;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(String checkPoint) {
        this.checkPoint = checkPoint;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public float getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(float delayTime) {
        this.delayTime = delayTime;
    }

    public boolean isRelease() {
        return isRelease;
    }

    public void setRelease(boolean release) {
        isRelease = release;
    }
}
