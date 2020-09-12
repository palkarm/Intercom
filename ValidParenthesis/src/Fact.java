public class Fact {
    public static void main(String[] args){
        factorial(5);
    }

    private static int factorial(int i) {
        int fact =1;
        if(i==0) return 1;
        while(i>0){
            fact =fact*i;
            i--;
        }
        System.out.println(fact);
        return fact;
    }
}
