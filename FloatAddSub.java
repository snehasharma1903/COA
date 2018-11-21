import java.util.Scanner;

import static java.lang.Math.abs;

public class FloatAddSub {




    public static void main(String[] args)
    {
        int a[],b[],AR[] = new int[0],BQ[],AC[]=new int[4];
        int d[]={0,0,0,0};
        int c[]={0,0,0,1};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first floating point no(4 digit binary no)");
        System.out.println("Enter the mantissa");
        for (int i = 0; i <4 ; i++) {
            AR[i]=sc.nextInt();
        }
        System.out.println("Enter the exponent");
        for (int i = 0; i < 4; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter the second floating point no(4 digit binary no)");
        System.out.println("Enter the mantissa");
        for (int i = 0; i <4 ; i++) {
            BQ[i]=sc.nextInt();
        }
        System.out.println("Enter the exponent");
        for (int i = 0; i < 4; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println("Press 0 for addition and 1 for subtraction");
        boolean op=sc.nextBoolean();

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
            int j=1;
            int big=2;
            do{
                if(a[j]>b[j]){
                    big=0;
            }
                else if(a[j]<b[j]){
                    big=1;
            }
                else
                    break;
            }while(j<4);

            if(big==0){
                for (int i = 0; i <3 ; i++)
                    BQ[i+1]=BQ[i];
                BQ[0]=0;
                AdderSubtractor(a,c,0);
                big=2;
            }
            else if(big==1) {
                for (int i = 0; i < 3; i++)
                    AC[i + 1] = AC[i];
                AC[0] = 0;
            AdderSubtractor(b, c, 0);
            big=2;
            }
            else if(big==2) {

                if (op == false) {
                    AC = AdderSubtractor(AC, BQ, 0);
                }

                if (op == true) {
                    AC = AdderSubtractor(AC, BQ, 1);
                }

                //not yet found a solution for normalising
        }







    }


}
