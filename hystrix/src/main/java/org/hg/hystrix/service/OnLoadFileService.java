package org.hg.hystrix.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hg.commons.SixAxis;
import org.hg.commons.SixAxisType;
import org.hg.commons.ThreeAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/9 9:05
 * @description:
 */
@Service
public class OnLoadFileService {

    @Autowired
    RestTemplate restTemplate;

    public boolean batchImport(String fileName, MultipartFile file, String fileType) throws Exception{
        boolean notNull = false;
        System.out.println("Service内的文件名："+fileName);
        System.out.println("Service内的文件类型："+fileType);
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            System.out.println("文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet!=null)
            notNull = true;

        if (fileType.equals("maximumSpeed") || fileType.equals("rangeOfMotion")){
//            System.out.println("上传六个轴的数据……");
            SixAxis sixAxis;
            List<SixAxis> sixAxisList = new ArrayList<>();
            for (int r=1;r<=sheet.getLastRowNum();r++){
                sixAxis = new SixAxis();
                Row row = sheet.getRow(r);
                if (row==null)
                    continue;
                row.getCell(1).setCellType(CellType.STRING);
                String num_S = row.getCell(1).getStringCellValue();
                row.getCell(2).setCellType(CellType.STRING);
                String num_L = row.getCell(2).getStringCellValue();
                row.getCell(3).setCellType(CellType.STRING);
                String num_U = row.getCell(3).getStringCellValue();
                row.getCell(4).setCellType(CellType.STRING);
                String num_R = row.getCell(4).getStringCellValue();
                row.getCell(5).setCellType(CellType.STRING);
                String num_B = row.getCell(5).getStringCellValue();
                row.getCell(6).setCellType(CellType.STRING);
                String num_T = row.getCell(6).getStringCellValue();
                sixAxis.setS(Double.valueOf(num_S));
                sixAxis.setL(Double.valueOf(num_L));
                sixAxis.setU(Double.valueOf(num_U));
                sixAxis.setR(Double.valueOf(num_R));
                sixAxis.setB(Double.valueOf(num_B));
                sixAxis.setT(Double.valueOf(num_T));
                sixAxisList.add(sixAxis);
            }
            System.out.println("开始存入数据库……");
            for (SixAxis numOfAxis : sixAxisList){
                //postForObject 不能传递多个参数，所以使用 map 来保存一下。
//                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//                map.add("numOfAxis", numOfAxis.toString());
//                map.add("fileType", fileType);
//                restTemplate.getForObject("http://providerPlan/onLoadSixAxis", boolean.class, numOfAxis, fileType);
                //post 不能同时传递两个参数，所以 把 数据和类型都放到了一个对象里
                SixAxisType sixAxisType = new SixAxisType(fileType, numOfAxis);
                System.out.println(sixAxisType.toString());
                restTemplate.postForObject("http://providerPlan/onLoadSixAxis", sixAxisType, String.class);
//                onLoadFileMapper.addSixAxis(numOfAxis, fileType);

//                URI uri = restTemplate.postForLocation("htp://providerPlan/onLoadSixAxis", numOfAxis, fileType);
//                System.out.println("hystrix>>>>>>>>>>>>>>");
//                System.out.println(uri);
//                restTemplate.getForObject(uri, boolean.class);
            }
            System.out.println("数据已全部存入数据库中");
        }
        else {
            ThreeAxis threeAxis;
            List<ThreeAxis> threeAxisList = new ArrayList<>();
            for (int r=1;r<=sheet.getLastRowNum();r++){
                threeAxis = new ThreeAxis();
                Row row = sheet.getRow(r);
                if (row==null)
                    continue;
                row.getCell(1).setCellType(CellType.STRING);
                String num_R = row.getCell(1).getStringCellValue();
                row.getCell(2).setCellType(CellType.STRING);
                String num_B = row.getCell(2).getStringCellValue();
                row.getCell(3).setCellType(CellType.STRING);
                String num_T = row.getCell(3).getStringCellValue();
                threeAxis.setR(Double.valueOf(num_R));
                threeAxis.setB(Double.valueOf(num_B));
                threeAxis.setT(Double.valueOf(num_T));
                threeAxisList.add(threeAxis);
            }
            System.out.println("开始存入数据库……");
            for (ThreeAxis numOfAxis : threeAxisList){
                System.out.println(numOfAxis.toString());
                restTemplate.postForLocation("http://providerPlan/onLoadThreeAxis", numOfAxis, fileType, boolean.class);
//                onLoadFileMapper.addThreeAxis(numOfAxis, fileType);
            }
            System.out.println("数据已全部存入数据库中");
        }

        return notNull;
    }
}
