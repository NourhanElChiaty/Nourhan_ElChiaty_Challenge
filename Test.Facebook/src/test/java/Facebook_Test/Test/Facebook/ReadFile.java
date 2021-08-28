package Facebook_Test.Test.Facebook;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFile {

	public static String getCellValue(String fileName, String Sheet, int r, int c)
			throws EncryptedDocumentException, IOException

	{

		String filePath = System.getProperty("user.dir") + "\\Inputs\\" + fileName + ".xlsx";

		FileInputStream stream = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(stream);
		Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
		return cell.getStringCellValue();

	}

}
