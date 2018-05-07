package com.joy.java.util.io;

import com.joy.java.util.common.CollectionUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;

import java.io.*;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * 封装对excel的操作，包括本地读写excel和流中输出excel,支持office 2007。
 * 依赖于poi-3.9-20121203.jar,poi-ooxml-3.9-20121203.jar,poi-ooxml-schemas-3.9-20121203.jar,dom4j-1.6.1.jar
 * 有参构造函数参数为excel的全路径
 */
public class ExcelUtil {

	// excel文件路径
	private String path = "";
	
	//写入excel时，是否自动扩展列宽度来符合内容。
	private boolean autoColumnWidth=false;
	
	/**
	 * 无参构造函数 默认
	 */
	public  ExcelUtil() {
	}
	
	/**
	 * 有参构造函数
	 * @param path excel路径
	 */
	public  ExcelUtil(String path) {
		this.path = path;
	}
	
	/**
	 * 读取某个工作簿上的所有单元格的值。
	 * @param sheetOrder 工作簿序号，从0开始。
	 * @return List<Object[]> 所有单元格的值。
	 * @throws IOException 加载excel文件IO异常。
	 * @throws FileNotFoundException excel文件没有找到异常。
	 * @throws InvalidFormatException 
	 */
	public List<Object[]> read(int sheetOrder) throws FileNotFoundException, IOException, InvalidFormatException{
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		if(fis != null) {
            fis.close();
        }
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		//用来记录excel值
		List<Object[]> valueList=new LinkedList<Object[]>();
		 //循环遍历每一行、每一列。
        for(Row row : sheet){  
        	//每一行
        	Object[] rowObject=null;
        	//System.out.println(row.getLastCellNum());
            for(int i=0 ;i<row.getLastCellNum();i++){  
            	Cell cell=row.getCell(i);
            	//System.out.println(cell==null);
            	if(cell==null){
            		rowObject= CollectionUtil.addToArray(rowObject, "");
            		continue;
            	}
                //cell.getCellType是获得cell里面保存的值的type  
                switch(cell.getCellType()){  
                    case Cell.CELL_TYPE_BOOLEAN:  
                        //得到Boolean对象的方法  
                        rowObject=CollectionUtil.addToArray(rowObject, cell.getBooleanCellValue());
                        break;  
                    case Cell.CELL_TYPE_NUMERIC:  
                        //先看是否是日期格式  
                        if(DateUtil.isCellDateFormatted(cell)){  
                            //读取日期格式  
                        	rowObject=CollectionUtil.addToArray(rowObject, new com.joy.java.util.common.DateUtil(cell.getDateCellValue()).toLongDate());
                        }else{  
                        	DecimalFormat df = new DecimalFormat();
                        	//单元格的值,替换掉,
                        	String value=df.format(cell.getNumericCellValue()).replace(",","");
                            //读取数字  
                        	rowObject=CollectionUtil.addToArray(rowObject, value);
                        }  
                        break;  
                    case Cell.CELL_TYPE_FORMULA:  
                        //读取公式  
                    	rowObject=CollectionUtil.addToArray(rowObject, cell.getCellFormula());
                        break;  
                    case Cell.CELL_TYPE_STRING:  
                        //读取String  
                    	rowObject=CollectionUtil.addToArray(rowObject, cell.getRichStringCellValue().toString());
                        break;
                    default:  
                        //读取String  
                    	rowObject=CollectionUtil.addToArray(rowObject, cell.getRichStringCellValue().toString());
                }
            }
            //将这行添加到list。
            valueList.add(rowObject);
        }
        return valueList;
	}
	
	/**
	 * 读取某个工作簿上的某个单元格的值。
	 * @param sheetOrder 工作簿序号,从0开始。
	 * @param colum 列数 从1开始
	 * @param row 行数 从1开始
	 * @return 单元格的值。
	 * @throws Exception 加载excel异常。
	 */
	public String read(int sheetOrder,int colum, int row) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		if(fis != null) {
            fis.close();
        }
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		Row rows = sheet.getRow(row-1);
		Cell cell = rows.getCell(colum-1);
		String content = cell.getStringCellValue();
		return content;
	}

	/**
	 * 在指定的工作簿、行、列书写值。
	 * @param sheetOrder 工作簿序号，基于0.
	 * @param colum 列 基于1
	 * @param row 行 基于1
	 * @param content 将要被书写的内容。
	 * @throws Exception 书写后保存异常。
	 */
	public void write(int sheetOrder,int colum, int row, String content) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		if(fis != null) {
            fis.close();
        }
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		Row rows = sheet.createRow(row-1);
		Cell cell = rows.createCell(colum-1);
		cell.setCellValue(content);
		FileOutputStream fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		fileOut.close();

	}
	
	/**
	 * 得到一个工作区最后一条记录的序号，相当于这个工作簿共多少行数据。
	 * @param sheetOrder 工作区序号
	 * @return int 序号。
	 * @throws IOException 根据excel路径加载excel异常。
	 * @throws InvalidFormatException 
	 */
	public int getSheetLastRowNum(int sheetOrder) throws IOException, InvalidFormatException{
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		if(fis != null) {
            fis.close();
        }
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		return sheet.getLastRowNum();
	}
	
	/**
	 * 在磁盘生成一个含有内容的excel,路径为path属性
	 * @param sheetIndex 第几个工作区,从0开始.
	 * @param sheetName 导出的sheet名称
	 * @param fieldName 列名数组
	 * @param data 数据组
	 * @throws IOException 
	 */
	public void makeExcel(int sheetIndex,String sheetName,String[] fieldName,List<Object[]> data) throws IOException {
		//在内存中生成工作薄
		HSSFWorkbook workbook = makeWorkBook(sheetName,fieldName,data);
		FileOutputStream fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		fileOut.close();
	}

	/**
	 * 追加一个工作薄
	 * @param sheetName 导出的sheet名称
	 * @param fieldName 列名数组
	 * @param data 数据组
	 * @throws IOException
	 */
	public void appendSheet(String sheetName,String[] fieldName,List<Object[]> data) throws IOException, InvalidFormatException {
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		if(fis != null) {
			fis.close();
		}

		//用来记录最大列宽,自动调整列宽。
		Integer collength[]=new Integer[fieldName.length];
		// 产生工作表对象
		Sheet sheet = workbook.createSheet();
		// 为了工作表能支持中文,设置字符集为UTF_16

		// 产生一行
		Row row = null;
		// 产生单元格
		Cell cell;

		//是否有标题
		int haveTitle=0;

		// 写入各个字段的名称
		if(fieldName!=null && fieldName.length>0) {
			haveTitle=1;
			row=sheet.createRow(0);
			for (int i = 0; i < fieldName.length; i++) {
				// 创建第一行各个字段名称的单元格
				cell = row.createCell((short) i);
				// 设置单元格内容为字符串型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 为了能在单元格中输入中文,设置字符集为UTF_16
				// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				// 给单元格内容赋值
				cell.setCellValue(new HSSFRichTextString(fieldName[i]));
				//初始化列宽
				collength[i] = fieldName[i].getBytes().length;
			}
		}
		//临时单元格内容
		String tempCellContent="";
		// 写入各条记录,每条记录对应excel表中的一行
		for (int i = 0; i < data.size(); i++) {
			Object[] tmp = data.get(i);
			// 生成一行
			row = sheet.createRow(i + haveTitle);
			//没有数据跳过
			if(tmp==null || tmp.length<=0){
				continue;
			}
			for (int j = 0; j < tmp.length; j++) {
				cell = row.createCell((short) j);
				//设置单元格字符类型为String
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				tempCellContent=(tmp[j] == null) ? "" : tmp[j].toString();
				cell.setCellValue(new HSSFRichTextString(tempCellContent));

				//如果自动调整列宽度。
				if(autoColumnWidth){
					if(j>=collength.length){	// 标题列数小于数据列数时。
						collength=CollectionUtil.addToArray(collength, tempCellContent.getBytes().length);
					}else{
						//如果这个内容的宽度大于之前最大的，就按照这个设置宽度。
						if(collength[j]<tempCellContent.getBytes().length){
							collength[j]=tempCellContent.getBytes().length;
						}
					}
				}
			}
		}

		//自动调整列宽度。
		if(autoColumnWidth){
			//调整列为这列文字对应的最大宽度。
			for(int i=0 ; i< fieldName.length ; i++){
				sheet.setColumnWidth(i,collength[i]*2*256);
			}
		}

		FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
		workbook.write(fileOutputStream);
		fileOutputStream.close();
	}
	
	/**
	 * 根据条件，生成工作薄对象到内存。
	 * @param sheetName 工作表对象名称
	 * @param fieldName 首列列名称
	 * @param data 数据
	 * @return HSSFWorkbook
	 */
	private HSSFWorkbook makeWorkBook(String sheetName,String[] fieldName
			, List<Object[]> data){
		//用来记录最大列宽,自动调整列宽。
		Integer collength[]=new Integer[fieldName.length];
		
		// 产生工作薄对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 产生工作表对象
		HSSFSheet sheet = workbook.createSheet();
		// 为了工作表能支持中文,设置字符集为UTF_16
		workbook.setSheetName(0, sheetName);
		// 产生一行
		HSSFRow row = null;
		// 产生单元格
		HSSFCell cell;

		//是否有标题
		int haveTitle=0;

		// 写入各个字段的名称
		if(fieldName!=null && fieldName.length>0) {
			haveTitle=1;
			row=sheet.createRow(0);
			for (int i = 0; i < fieldName.length; i++) {
				// 创建第一行各个字段名称的单元格
				cell = row.createCell((short) i);
				// 设置单元格内容为字符串型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 为了能在单元格中输入中文,设置字符集为UTF_16
				// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				// 给单元格内容赋值
				cell.setCellValue(new HSSFRichTextString(fieldName[i]));
				//初始化列宽
				collength[i] = fieldName[i].getBytes().length;
			}
		}
		//临时单元格内容
		String tempCellContent="";
		// 写入各条记录,每条记录对应excel表中的一行
		for (int i = 0; i < data.size(); i++) {
			Object[] tmp = data.get(i);
			// 生成一行
			row = sheet.createRow(i + haveTitle);
			//没有数据跳过
			if(tmp==null || tmp.length<=0){
				continue;
			}
			for (int j = 0; j < tmp.length; j++) {
				cell = row.createCell((short) j);
				//设置单元格字符类型为String
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				tempCellContent=(tmp[j] == null) ? "" : tmp[j].toString();
				cell.setCellValue(new HSSFRichTextString(tempCellContent));
				
				//如果自动调整列宽度。
				if(autoColumnWidth){
					if(j>=collength.length){	// 标题列数小于数据列数时。
						collength=CollectionUtil.addToArray(collength, tempCellContent.getBytes().length);
					}else{
						//如果这个内容的宽度大于之前最大的，就按照这个设置宽度。
						if(collength[j]<tempCellContent.getBytes().length){
							collength[j]=tempCellContent.getBytes().length;
						}
					}
				}
			}
		}
		
		//自动调整列宽度。
		if(autoColumnWidth){
			//调整列为这列文字对应的最大宽度。
			for(int i=0 ; i< fieldName.length ; i++){
				sheet.setColumnWidth(i,collength[i]*2*256);
			}
		}
		return workbook;
	}
	
	/**
	 * 功能：设置写入excel时，是否自动扩展列宽度来符合内容，默认为false。
	 * @param autoColumnWidth true或者false
	 */
	public void setAutoColumnWidth(boolean autoColumnWidth) {
		this.autoColumnWidth = autoColumnWidth;
	}
}
