package salesForceClassic;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	

	public String[][] readData(String sheetName)  throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb=new XSSFWorkbook("./data/salesForceClassic.xlsx");
		XSSFSheet ws=wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		short cellCount= ws.getRow(0).getLastCellNum();
		String[][] data=new String[rowCount][cellCount];
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j <cellCount ; j++) {
			String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
			data[i-1][j]=stringCellValue;
			System.out.println(stringCellValue);
		}
		
	}

	wb.close();
	return data;

	}

}
