package rough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
    @Test(dataProvider = "getData")
    public void testData(String i,String t,String b,String r,String u){
        System.out.println(i+"----"+t+"----"+b+"----"+r+"----"+u);

    }
    @DataProvider
    public static Object[][] getData(){
        ExcelReader excel = new ExcelReader("F:\\Automation Practice\\HybridFramework\\testdata.xlsx");

        String sheetName = "TestData";
        String testCase = "LoginTest";
        //Test case start from

        int testCaseRowNum=1;

        while(!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)){


            testCaseRowNum++;
        }

        System.out.println("Test case starts from : "+testCaseRowNum);


        //total cols & rows - cols starts and test data starts from

// colsStartRowNum = colum is starting from very after testcase .Here our testcase position is testCaseRowNum. And we have to increment one to reach colum start.
        int colsStartRowNum=testCaseRowNum+1;
// dataStartRowNum = data is start form very after column position so increment one for data.
        int dataStartRowNum=colsStartRowNum+1;


        //total cols in test are

        int cols=0;

        while(!excel.getCellData(sheetName, cols, colsStartRowNum).trim().equals("")){

            cols++;

        }

        System.out.println("Total cols in a test are : "+cols);


        //total rows in a test are

        int rows=0;

        while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){

            rows++;

        }

        System.out.println("Total rows are : "+rows);

        //printing the test data
        Object[][] data=new Object[rows][cols];

        for(int row=dataStartRowNum; row<dataStartRowNum+rows;row++){

            for(int col=0;col<cols;col++){


//                System.out.println(excel.getCellData(sheetName, col, row));
            data[row-dataStartRowNum][col] = excel.getCellData(sheetName, col, row);
            }


        }
        return data;
    }

    }

