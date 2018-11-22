import java.util.Scanner;

import static java.lang.Math.abs;

public class FloatAddSub {


    static String shr(String a) {
        char[] c_arr = a.toCharArray();
        for (int j = a.length()-1; j >0; j--)
            c_arr[j ] = c_arr[j-1];
        c_arr[0] = '0';
        String c = new String(c_arr);
        return c;
    }

    static String shl(String a){
        char[] c_arr = a.toCharArray();
        for (int j = a.length()-1; j >0; j--)
            c_arr[j-1 ] = c_arr[j];
        c_arr[a.length()-1] = '0';
        String c = new String(c_arr);
        return c;
    }







    public static void main(String[] args)
    {
        String a,b,AR ,BQ,AC;
        String d="0000";
        String c="0001";
        String num=new String();
        String num1=new String();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first floating point no(4 digit binary no)");
        System.out.println("Enter the mantissa");
        AR=sc.next();
        System.out.println("Enter the exponent");
        a = sc.next();

        System.out.println("Enter the second floating point no(4 digit binary no)");
        System.out.println("Enter the mantissa");
        BQ=sc.next();
        System.out.println("Enter the exponent");
        b = sc.next();
        int diff=abs(Integer.parseInt(a,2)-Integer.parseInt(b,2));

        System.out.println("Press 0 for addition and 1 for subtraction");
        int op=sc.nextInt();

        AC=AR;


        if(AR==d)
        {
            AC=BQ;
        }

        else if(BQ==d)
        {
            AC=AR;
        }

        else{



        //comparing exponents a and b

            int big=2;
                if(Integer.parseInt(a,2)>Integer.parseInt(b,2)){
                    big=0;
            }
                else if(Integer.parseInt(a,2)>Integer.parseInt(b,2)){
                    big=1;
            }


            if(big==0) {
                do {
                    BQ = shr(BQ);
                    int temp = Integer.parseInt(a, 2);
                    temp = temp + 1;
                    a = Integer.toBinaryString(temp);
                } while (a != b);
                big = 2;
                System.out.println(BQ);
            }
            else if(big==1) {
                do {
                    AC = shr(AC);
                    int temp = Integer.parseInt(a, 2);
                    temp = temp + 1;
                    b = Integer.toBinaryString(temp);

                } while (a != b);
                big = 2;
                System.out.println(AC);
            }
            else if(big==2) {

                if (op == 0) {
                    int n1 = Integer.parseInt(AC, 2);
                    int n2 = Integer.parseInt(BQ,2);
                    int temp=n1+n2;
                    AC = Integer.toBinaryString(temp);
                    System.out.println(AC);

                }

                if (op == 1) {
                    int n1 = Integer.parseInt(AC, 2);
                    int n2 = Integer.parseInt(BQ,2);
                    int temp=n1-n2;
                    AC = Integer.toBinaryString(temp);
                    System.out.println(AC);
                }
                while(diff!=0)
                {
                    shl(AC);
                    diff=diff-1;
                }

                System.out.println(AC+" is the final answer");


            }

        }







    }


}
