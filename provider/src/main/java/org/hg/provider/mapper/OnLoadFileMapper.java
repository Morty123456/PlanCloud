package org.hg.provider.mapper;

import org.apache.ibatis.annotations.Param;
import org.hg.commons.SixAxis;
import org.hg.commons.ThreeAxis;


public interface OnLoadFileMapper {
    void addSixAxis(@Param("sixAxis") SixAxis sixAxis, @Param("fileType") String fileType);
    void addThreeAxis(@Param("sixAxis") ThreeAxis threeAxis, @Param("fileType") String fileType);
}
