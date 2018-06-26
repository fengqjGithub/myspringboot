package com.joy.java.util.excelutil;

/**
 * @Package: org.hnzr.web.excelExport
 * @Class: PoiExcelExport
 * @Author: Joy
 * @date: 2018/6/1 9:08
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
//这个里面有合并表头和设置网格线
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.List;

public class PoiExcelExport2 {
    HttpServletResponse response;
    // 文件名
    private String fileName;
    // 文件名
    private String title1Value;
    //文件保存路径
    private String fileDir;
    //sheet名
    private String sheetName;
    //表头字体
    private String titleFontType = "宋体";
    //表头背景色
    private String titleBackColor = "BABABA";
    //内容背景色
    private String CellsBackColor = "F8F8FF";
    //表头字号
    private short titleFontSize = 15;
    //添加自动筛选的列 如 A:M
    private String address = "";
    //正文字体
    private String contentFontType = "宋体";
    //正文字号
    private short contentFontSize = 12;
    //Float类型数据小数位
    private String floatDecimal = ".00";
    //Double类型数据小数位
    private String doubleDecimal = ".00";
    //设置列的公式
    private String colFormula[] = null;

    DecimalFormat floatDecimalFormat = new DecimalFormat(floatDecimal);
    DecimalFormat doubleDecimalFormat = new DecimalFormat(doubleDecimal);

    private HSSFWorkbook workbook = null;

    public PoiExcelExport2(String fileDir, String sheetName, HSSFWorkbook workbook) {
        this.fileDir = fileDir;
        this.sheetName = sheetName;
        this.workbook = workbook;
        this.title1Value = title1Value;
    }

    public PoiExcelExport2(HttpServletResponse response, String fileName, String sheetName, HSSFWorkbook workbook) {
        this.response = response;
        this.sheetName = sheetName;
        this.workbook = workbook;
    }

    /**
     * 设置表头字体.
     *
     * @param titleFontType
     */
    public void setTitleFontType(String titleFontType) {
        this.titleFontType = titleFontType;
    }

    /**
     * 设置表头背景色.
     *
     * @param titleBackColor 十六进制
     */
    public void setTitleBackColor(String titleBackColor) {
        this.titleBackColor = titleBackColor;
    }

    /**
     * 设置表头字体大小.
     *
     * @param titleFontSize
     */
    public void setTitleFontSize(short titleFontSize) {
        this.titleFontSize = titleFontSize;
    }

    /**
     * 设置表头自动筛选栏位,如A:AC.
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 设置正文字体.
     *
     * @param contentFontType
     */
    public void setContentFontType(String contentFontType) {
        this.contentFontType = contentFontType;
    }

    /**
     * 设置正文字号.
     *
     * @param contentFontSize
     */
    public void setContentFontSize(short contentFontSize) {
        this.contentFontSize = contentFontSize;
    }

    /**
     * 设置float类型数据小数位 默认.00
     *
     * @param doubleDecimal 如 ".00"
     */
    public void setDoubleDecimal(String doubleDecimal) {
        this.doubleDecimal = doubleDecimal;
    }

    /**
     * 设置doubel类型数据小数位 默认.00
     *
     * @param floatDecimalFormat 如 ".00
     */
    public void setFloatDecimalFormat(DecimalFormat floatDecimalFormat) {
        this.floatDecimalFormat = floatDecimalFormat;
    }

    /**
     * 设置列的公式
     *
     * @param colFormula 存储i-1列的公式 涉及到的行号使用@替换 如A@+B@
     */
    public void setColFormula(String[] colFormula) {
        this.colFormula = colFormula;
    }

    /**
     * 写excel.
     *
     * @param titleColumn 对应bean的属性名
     * @param titleName   excel要导出的表名
     * @param titleSize   列宽
     * @param dataList    数据
     */
    public void wirteExcel(String titleColumn[], String titleName[], Integer titleSize[], List<?> dataList,String sheetName,String title1Value) {
        //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
        Sheet sheet = workbook.createSheet(sheetName);
        //新建文件
        OutputStream out = null;
        try {
            if (fileDir != null) {
                //有文件路径
                out = new FileOutputStream(fileDir);
            } else {
                //否则，直接写到输出流中
                out = response.getOutputStream();
                fileName = fileName + ".xls";
                response.setContentType("application/x-msdownload");
                response.setHeader("Content-Disposition", "attachment; filename="
                        + URLEncoder.encode(fileName, "UTF-8"));
            }

            //写入excel的表头
            Row titleNameRow = workbook.getSheet(sheetName).createRow(2);
            //给合并的第一行设置样式
            HSSFCellStyle titleStyle1 = workbook.createCellStyle();
            titleStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
            titleStyle1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
            titleStyle1 = (HSSFCellStyle) setFontAndBorder(titleStyle1, "宋体", (short) 20);
            titleStyle1 = (HSSFCellStyle) setColor(titleStyle1, titleBackColor, (short) 10);
            CellRangeAddress cra=new CellRangeAddress(0, 1, 0, titleColumn.length-1);
            sheet.addMergedRegion(cra);
            Cell ce =sheet.createRow(0).createCell(0);
            ce.setCellValue(title1Value);
            ce.setCellStyle(titleStyle1);
            sheet.createFreezePane( 0, 3, 0, 3);

            //设置样式
            HSSFCellStyle titleStyle = workbook.createCellStyle();
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
            titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
            titleStyle = (HSSFCellStyle) setFontAndBorder(titleStyle, "宋体", titleFontSize);
            titleStyle = (HSSFCellStyle) setColor(titleStyle, titleBackColor, (short) 10);

            for (int i = 0; i < titleName.length; i++) {
                sheet.setColumnWidth(i, titleSize[i] * 256);    //设置宽度
                Cell cell = titleNameRow.createCell(i);
                cell.setCellStyle(titleStyle);
                cell.setCellValue(titleName[i]==null?"":titleName[i].toString());
            }
            //为表头添加自动筛选
            if (!"".equals(address)) {
                CellRangeAddress c = (CellRangeAddress) CellRangeAddress.valueOf(address);
                sheet.setAutoFilter(c);
            }
            HSSFCellStyle boolderStyle = workbook.createCellStyle();
            boolderStyle = (HSSFCellStyle) setFontAndBorder(boolderStyle, contentFontType, (short) contentFontSize);
            //通过反射获取数据并写入到excel中
            if (dataList != null && dataList.size() > 0) {
                //设置样式
                HSSFCellStyle dataStyle = workbook.createCellStyle();
                titleStyle = (HSSFCellStyle) setFontAndBorder(titleStyle, contentFontType, (short) contentFontSize);

                if (titleColumn.length > 0) {
                    for (int rowIndex = 1; rowIndex <= dataList.size(); rowIndex++) {
                        Object obj = dataList.get(rowIndex - 1);     //获得该对象
                        Class clsss = obj.getClass();     //获得该对对象的class实例
                        Row dataRow = workbook.getSheet(sheetName).createRow(rowIndex+2);
                        for (int columnIndex = 0; columnIndex < titleColumn.length; columnIndex++) {
                            String title = titleColumn[columnIndex].toString().trim();
                            if (!"".equals(title)) {  //字段不为空
                                //使首字母大写
                                String UTitle = Character.toUpperCase(title.charAt(0)) + title.substring(1, title.length()); // 使其首字母大写;
                                String methodName = "get" + UTitle;

                                // 设置要执行的方法
                                Method method = clsss.getDeclaredMethod(methodName);

                                //获取返回类型
                                String returnType = method.getReturnType().getName();

                                String data = method.invoke(obj) == null ? "" : method.invoke(obj).toString();
                                Cell cell = dataRow.createCell(columnIndex);
                                if(rowIndex<1){
                                    cell.setCellStyle(titleStyle);
                                }else {
                                    cell.setCellStyle(boolderStyle);
                                }
                                if (data != null && !"".equals(data)) {
                                    if ("int".equals(returnType)) {
                                        cell.setCellValue(Integer.parseInt(data));
                                    } else if ("long".equals(returnType)) {
                                        cell.setCellValue(Long.parseLong(data));
                                    } else if ("float".equals(returnType)) {
                                        cell.setCellValue(floatDecimalFormat.format(Float.parseFloat(data)));
                                    } else if ("double".equals(returnType)) {
                                        cell.setCellValue(doubleDecimalFormat.format(Double.parseDouble(data)));
                                    } else {
                                        cell.setCellValue(data);
                                    }
                                }
                            } else {   //字段为空 检查该列是否是公式
                                if (colFormula != null) {
                                    String sixBuf = colFormula[columnIndex].replace("@", (rowIndex + 1) + "");
                                    Cell cell = dataRow.createCell(columnIndex);
                                    if(rowIndex<1) {
                                        cell.setCellStyle(titleStyle);
                                    }else {
                                        cell.setCellStyle(boolderStyle);
                                    }
                                    cell.setCellFormula(sixBuf.toString());
                                }
                            }
                        }
                    }

                }
            }
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将16进制的颜色代码写入样式中来设置颜色
     *
     * @param style 保证style统一
     * @param color 颜色：66FFDD
     * @param index 索引 8-64 使用时不可重复
     * @return
     */
    public CellStyle setColor(CellStyle style, String color, short index) {
        if (color != "" && color != null) {
            //转为RGB码
            int r = Integer.parseInt((color.substring(0, 2)), 16);   //转为16进制
            int g = Integer.parseInt((color.substring(2, 4)), 16);
            int b = Integer.parseInt((color.substring(4, 6)), 16);
            //自定义cell颜色
            HSSFPalette palette = workbook.getCustomPalette();
            palette.setColorAtIndex((short) index, (byte) r, (byte) g, (byte) b);

            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            style.setFillForegroundColor(index);
        }
        return style;
    }

    /**
     * 设置字体并加外边框
     *
     * @param style 样式
     * @param style 字体名
     * @param style 大小
     * @return
     */
    public CellStyle setFontAndBorder(CellStyle style, String fontName, short size) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints(size);
        font.setFontName(fontName);
//        font.setBold(true);
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        style.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        style.setBorderTop(CellStyle.BORDER_THIN);//上边框
        style.setBorderRight(CellStyle.BORDER_THIN);//右边框
        return style;
    }

    /**
     * 删除文件
     *
     * @return
     */
    public boolean deleteExcel() {
        boolean flag = false;
        File file = new File(this.fileDir);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                file.delete();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 删除文件
     *
     * @return
     */
    public boolean deleteExcel(String path) {
        boolean flag = false;
        File file = new File(path);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                file.delete();
                flag = true;
            }
        }
        return flag;
    }
}
