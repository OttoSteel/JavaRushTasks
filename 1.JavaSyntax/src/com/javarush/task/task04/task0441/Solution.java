package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();

        int A = Integer.parseInt(a);

        String b = reader.readLine();

        int B = Integer.parseInt(b);

        String c = reader.readLine();

        int C = Integer.parseInt(c);

        if ((A == B) && (B == C))
            System.out.println(A);
        else if ((A == B) || (B == C) || (A == C)) {
            if(A == B)
                System.out.println(A);
            else if (B == C)
                System.out.println(B);
            else if (A == C)
                System.out.println(C);
        }

        // B<A<C
        // C<A<B
        // A<B<C
        // C<B<A
        // A<C<B
        // B<C<A

        else if ((A != B) && (B != C) && (A != C)) {
            if (((A < B) && (A > C)) || ((A < C) && (B < A)))
                System.out.println(A);
            else if (((B < A) && (B > C)) || ((B < C) && (A < B)))
                System.out.println(B);
            else if (((C < A) && (C > B)) || ((C < B) && (A < C)))
                System.out.println(C);
        }
    }
}
