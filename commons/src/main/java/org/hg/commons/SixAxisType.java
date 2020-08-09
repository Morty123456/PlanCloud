package org.hg.commons;

/**
 * @author: wzh
 * @time: 2020/8/9 11:08
 * @description:
 */
public class SixAxisType {
    private String fileType;
    private SixAxis numOfAxis;

    public SixAxisType() {
    }

    public SixAxisType(String fileType, SixAxis numOfAxis) {
        this.fileType = fileType;
        this.numOfAxis = numOfAxis;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public SixAxis getNumOfAxis() {
        return numOfAxis;
    }

    public void setNumOfAxis(SixAxis numOfAxis) {
        this.numOfAxis = numOfAxis;
    }

    @Override
    public String toString() {
        return "SixAxisType{" +
                "unmType='" + fileType + '\'' +
                ", numOfAxis=" + numOfAxis.toString() +
                '}';
    }
}
