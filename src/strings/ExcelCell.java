package strings;

/**
 *
 *
 * Problem :
 *<br>
 *<br>
 * Time Complexity : O()
 * <br>
 * Space Complexity : O()
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href=""></a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */
public class ExcelCell {

    public static void main(String[] args) {

        String cellInput1 ="";
        String cellInput2 ="A";
        String cellInput3 ="Z";
        String cellInput4 ="AA";
        String cellInput5 ="ZZ";

        System.out.println("Integer for cell "+cellInput1+" is "+excelCellToInteger(cellInput1));
        System.out.println("Integer for cell "+cellInput2+" is "+excelCellToInteger(cellInput2));
        System.out.println("Integer for cell "+cellInput3+" is "+excelCellToInteger(cellInput3));
        System.out.println("Integer for cell "+cellInput4+" is "+excelCellToInteger(cellInput4));
        System.out.println("Integer for cell "+cellInput5+" is "+excelCellToInteger(cellInput5));

        int integerInput1 = 1;
        int integerInput2= 26;
        int integerInput3 = 27;
        int integerInput4 = 702;

        System.out.println("Cell for integer "+integerInput1+" is "+integerToExcelCell(integerInput1));
        System.out.println("Cell for integer "+integerInput2+" is "+integerToExcelCell(integerInput2));
        System.out.println("Cell for integer "+integerInput3+" is "+integerToExcelCell(integerInput3));
        System.out.println("Cell for integer "+integerInput4+" is "+integerToExcelCell(integerInput4));
    }

    public static Integer excelCellToInteger(String cell){
        int result =0;
        if(cell.isEmpty()){
            return null;
        }

        for(int i=0;i<cell.length();i++){
            result *=26;
            result += cell.charAt(i)-'A'+1;
        }
        return result;

    }

    public static String integerToExcelCell(int num){
        StringBuilder sb = new StringBuilder();

        while (num>0){
            if(num%26 ==0){
                sb.append('Z');
                num = (num-1)/26;
            }
            else{
                sb.append((char)('A'+(num%26)-1));
                num/=26;
            }
        }
        return sb.toString();
    }
}
