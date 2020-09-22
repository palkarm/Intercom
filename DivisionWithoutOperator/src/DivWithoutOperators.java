public class DivWithoutOperators {

    public static void main(String args[]){
        division(17,5);
    }

    private static int division(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int negatives=2;
        if(dividend>0){
            negatives--;
            dividend = -dividend;
        }
        if(divisor>0){
            negatives--;
            divisor= -divisor;
        }
        int quotient =0;
        while(dividend-divisor<=0){
          quotient++;
          dividend=dividend-divisor;
          System.out.println ("Quotient:"+ quotient);
        }
        return quotient;
    }

}
