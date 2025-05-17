package com.saladbar.rinx.model.dto;

public class RinkDto {
    private int rinkNumber;
    private String rinkName;

    public int getRinkNumber() {
        return rinkNumber;
    }

    public void setRinkNumber(int rinkNumber) {
        this.rinkNumber = rinkNumber;
    }

    public String getRinkName() {
        return rinkName;
    }

    public void setRinkName(String rinkName) {
        this.rinkName = rinkName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RinkDto{");
        sb.append("rinkNumber=").append(rinkNumber);
        sb.append(", rinkName='").append(rinkName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
