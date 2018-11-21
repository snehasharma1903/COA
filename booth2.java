import java.util.Scanner;

import static java.lang.Math.abs;

public class booth2 {
    static int a = 0,b = 0, c = 0, a1 = 0, b1 = 0;
    static int[] com= { 1, 0, 0, 0, 0};

    static int anum[], anumcp[], bnum[]=new int[5];

    static int acomp[], bcomp[], pro[], res[]=new int[5];



    static void binary(){

        a1 = abs(a);

        b1 = abs(b);

        int r, r2, i, temp;

        for (i = 0; i < 5; i++){

            r = a1 % 2;

            a1 = a1 / 2;

            r2 = b1 % 2;

            b1 = b1 / 2;

            anum[i] = r;

            anumcp[i] = r;

            bnum[i] = r2;

            if(r2 == 0){

                bcomp[i] = 1;

            }

            if(r == 0){

                acomp[i] =1;

            }

        }

        //part for two's complementing

        c = 0;

        for ( i = 0; i < 5; i++){

            res[i] = com[i]+ bcomp[i] + c;

            if(res[i] >= 2){

                c = 1;

            }

            else

                c = 0;

            res[i] = res[i] % 2;

        }

        for (i = 4; i >= 0; i--){

            bcomp[i] = res[i];

        }

        //in case of negative inputs

        if (a < 0){

            c = 0;

            for (i = 4; i >= 0; i--){

                res[i] = 0;

            }

            for ( i = 0; i < 5; i++){

                res[i] = com[i] + acomp[i] + c;

                if (res[i] >= 2){

                    c = 1;

                }

                else

                    c = 0;

                res[i] = res[i]%2;

            }

            for (i = 4; i >= 0; i--){

                anum[i] = res[i];

                anumcp[i] = res[i];

            }



        }

        if(b < 0){

            for (i = 0; i < 5; i++){

                temp = bnum[i];

                bnum[i] = bcomp[i];

                bcomp[i] = temp;

            }

        }

    }

    static void add(int num[]){

        int i;

        c = 0;

        for ( i = 0; i < 5; i++){

            res[i] = pro[i] + num[i] + c;

            if (res[i] >= 2){

                c = 1;

            }

            else{

                c = 0;

            }

            res[i] = res[i]%2;

        }

        for (i = 4; i >= 0; i--){

            pro[i] = res[i];

            System.out.println(pro[i]);

        }

        System.out.println(":");

        for (i = 4; i >= 0; i--){

            System.out.println( anumcp[i]);

        }

    }

    static void arshift(){//for arithmetic shift right

        int temp = pro[4], temp2 = pro[0], i;

        for (i = 1; i < 5  ; i++){//shift the MSB of product

            pro[i-1] = pro[i];

        }

        pro[4] = temp;

        for (i = 1; i < 5  ; i++){//shift the LSB of product

            anumcp[i-1] = anumcp[i];

        }

        anumcp[4] = temp2;

        System.out.println("\nAR-SHIFT: ");//display together

        for (i = 4; i >= 0; i--){

            System.out.println(pro[i]);

        }

        System.out.println(":");

        for(i = 4; i >= 0; i--){

            System.out.println( anumcp[i]);

        }

    }



    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int i, q = 0;

        System.out.println("\t\tBOOTH'S MULTIPLICATION ALGORITHM");

        System.out.println("\nEnter two numbers to multiply: ");

        System.out.println("\nBoth must be less than 16");

        //simulating for two numbers each below 16

        do{

            System.out.println("\nEnter A: ");

            a=sc.nextInt();

            System.out.println("Enter B: ");

            b=sc.nextInt();

        }while(a >=16 || b >=16);



        System.out.println("\nExpected product "+ a * b);

        binary();

        System.out.println("\n\nBinary Equivalents are: ");

        System.out.println("\nA = ");

        for (i = 4; i >= 0; i--){

            System.out.println(anum[i]);

        }

        System.out.println("\nB = ");

        for (i = 4; i >= 0; i--){

            System.out.println( bnum[i]);

        }

        System.out.println("\nB'+ 1 = ");

        for (i = 4; i >= 0; i--){

            System.out.println( bcomp[i]);

        }

        System.out.println("\n\n");

        for (i = 0;i < 5; i++){

            if (anum[i] == q){//just shift for 00 or 11

                System.out.println("\n-->");

                arshift();

                q = anum[i];

            }

            else if(anum[i] == 1 && q == 0){//subtract and shift for 10

                System.out.println("\n-->");

                System.out.println("\nSUB B: ");

                System.out.println(bcomp);//add two's complement to implement subtraction

                arshift();

                q = anum[i];

            }

            else{//add ans shift for 01

                System.out.println("\n-->");

                System.out.println("\nADD B: ");

                add(bnum);

                arshift();

                q = anum[i];

            }

        }



        System.out.println("\nProduct is = ");

        for (i = 4; i >= 0; i--){

            System.out.println( pro[i]);

        }

        for (i = 4; i >= 0; i--){

            System.out.println(anumcp[i]);

        }

    }
}
