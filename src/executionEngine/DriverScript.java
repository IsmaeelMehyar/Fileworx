package executionEngine;

import java.lang.reflect.Method;
import config.ActionKeywords;
import utility.Constant;
import utility.UseExcel;

public class DriverScript {
	
	public static ActionKeywords actionKeywords;
	public static String sActionKeywords;
	public static Class<?> Rental = ActionKeywords.class;
	public static Method[] method;
	
	public DriverScript() throws NoSuchMethodException, SecurityException{
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}
	
	public static void main(String[] args)throws Exception {
		UseExcel.setExcelFile(Constant.DataEngine_Path, Constant.DataEngine_Sheet);

		method = Rental.getMethods();
		for (int iRow=1; iRow<=UseExcel.excelLength(); iRow++) {
			sActionKeywords = UseExcel.getCellData(iRow, Constant.Col_ActionKeywords);
			execute_Actions();
		}
	}
	
		private static void execute_Actions()throws Exception, NullPointerException{
			for (int i=0; i<=method.length;i++) {
				if (method[i].getName().equals(sActionKeywords)) {
				method[i].invoke(actionKeywords);
				break;
			}
		}
		}
		
}
