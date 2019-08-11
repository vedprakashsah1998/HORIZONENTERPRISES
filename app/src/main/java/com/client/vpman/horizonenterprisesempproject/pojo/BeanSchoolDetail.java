package com.client.vpman.horizonenterprisesempproject.pojo;

public class BeanSchoolDetail
{
    int image;
    String schoolName;

    public BeanSchoolDetail(int image, String schoolName) {
        this.image = image;
        this.schoolName = schoolName;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


}
