package com.company;

import java.util.Scanner;

public class paintFence {
    // you arre requited to paint the fences of a house in such a way that nott more than two e consecutive fences are painted the same color
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int noOfFences = scn.nextInt();
        int noOfColors = scn.nextInt();

        long same = noOfColors * 1;
        long different = (long) noOfColors * (noOfColors-1);
        long total = same + different;

        for (int fences = 3; fences <= noOfFences; fences++) {
           same = different * 1;
           different = total * (noOfColors- 1);
           total = same + different;
        }

        System.out.println(total);

    }
}
