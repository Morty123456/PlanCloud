package org.hg.commons;

/**
 * @author: wzh
 * @time: 2020/10/7 23:22
 * @description:
 */
public class ThreeAxisType {
    private String fileType;
    private ThreeAxis numOfAxis;

    public ThreeAxisType() {
    }

    public ThreeAxisType(String fileType, ThreeAxis threeAxis) {
        this.fileType = fileType;
        this.numOfAxis = threeAxis;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public ThreeAxis getNumOfAxis() {
        return numOfAxis;
    }

    public void setNumOfAxis(ThreeAxis numOfAxis) {
        this.numOfAxis = numOfAxis;
    }

    @Override
    public String toString() {
        return "ThreeAxisType{" +
                "unmType='" + fileType + '\'' +
                ", numOfAxis=" + numOfAxis.toString() +
                '}';
    }
}
