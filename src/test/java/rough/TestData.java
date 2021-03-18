package rough;

public class TestData {
    public static void main(String[] args) {
        ExcelReader excel = new ExcelReader("F:\\Automation Practice\\HybridFramework\\testdata.xlsx");

        String sheetName = "TestData";
        String testCase = "SignUpTest";
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

        for(int row=dataStartRowNum; row<dataStartRowNum+rows;row++){

            for(int col=0;col<cols;col++){


                System.out.println(excel.getCellData(sheetName, col, row));

            }


        }
//        ExcelReader excel=new ExcelReader("F:\\Automation Practice\\HybridFramework\\testdata.xlsx");
//
//        String sheetName="TestData";
//        String testcase="SignUpTest";
//
//        int testCaseRowNum=1;
//
//        while (!excel.getCellData(sheetName,0,testCaseRowNum).equals(testcase)){
//            testCaseRowNum++;
//        }
//        System.out.println(testCaseRowNum);
//
//        int colsStartRowNum=testCaseRowNum+1;
//        int dataStartRowNum=colsStartRowNum+1;
//        int cols=0;
//        while (!excel.getCellData(sheetName,cols,colsStartRowNum).trim().equals("")){
//            cols++;
//        }
//        System.out.println(cols);
//
//        int rows=0;
//        while (!excel.getCellData(sheetName,0,dataStartRowNum+rows).equals("")){
//            rows++;
//        }
//        System.out.println(rows);
//
//        for (int row=dataStartRowNum;row<dataStartRowNum+rows;row++){
//            for (int col=0;col<cols;col++){
//                System.out.println(excel.getCellData(sheetName,col,row));
//            }
//        }


    }

}
