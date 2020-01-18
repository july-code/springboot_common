package com.example.demo.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class XlsUtils {
  
	public static List<Map<String,Object>> getDatasList( String filePath ) {
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String,Object>> list = null;
        Object cellData = null;
        if(!(new File(filePath)).exists() )
          return null;
        wb = readExcel(filePath);
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<Map<String,Object>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            String[] columns=new String[colnum]; 
            
            for (int j=0;j<colnum;j++)
            {
            	 row = sheet.getRow(0);
            	 cellData =   getCellFormatValue(row.getCell(j));
            	 columns[j]=(String)cellData;
            }
            for (int i = 1; i<rownum; i++) {
                Map<String,Object> map = new LinkedHashMap<String,Object>();
                row = sheet.getRow(i);
                if(row !=null){
                	boolean flag=true;
                    for (int j=0;j<colnum;j++){
                        cellData =   getCellFormatValue(row.getCell(j));
                        if(cellData==null || StringUtils.isBlank( (String) cellData) && j<3)
                        {
                        	flag=false;
                        	break;
                        }
                        map.put(columns[j], cellData);
                    }
                  if(flag==false)
                	  continue;
                }else{
                    break;
                }
                list.add(map);
            }
        }
//        //遍历解析出来的list
//        for (Map<String,String> map : list) {
//            for (Entry<String,String> entry : map.entrySet()) {
//                System.out.print(entry.getKey()+":"+entry.getValue()+",");
//            }
//            System.out.println();
//        }
       return list;
    }
	
	//读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    
    
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC:{
                Double d=cell.getNumericCellValue();
                DecimalFormat df = new DecimalFormat("#");
                if(Math.abs(Double.parseDouble(df.format(d))*1.0-d)<0.0000001) 
                {
                	cellValue=df.format(d);
                }else
                   cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            }
            case Cell.CELL_TYPE_FORMULA:{
                //判断cell是否为日期格式
                if(DateUtil.isCellDateFormatted(cell)){
                    //转换为日期格式YYYY-mm-dd
                    cellValue = cell.getDateCellValue();
                }else{
                    //数字
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            case Cell.CELL_TYPE_STRING:{
                cellValue = cell.getRichStringCellValue().getString();
                break;
            }
            default:
                cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    } 
}
