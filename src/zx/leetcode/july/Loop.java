package zx.leetcode.july;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String source = "FGRSTLMNOPQWXYZUAGHIJKBCDElmnoepijkfghqrwxyzstuv";

        String words[] = line.split("#");

        int index;
        for (String word : words) {
        	if(word.length()==0)continue;
            index =parse(word) ;
            if(index >= source.length())
                System.out.print("ERROR");
            else
                System.out.print(source.charAt(index));
        }
        System.out.print("\n");
//        --.#.#-.---.#.#-.---.#.#-.---.#.#-.---.#.#-.---.#.#-.-

    }

    public static int parse(String word) {
        String ma = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.')
                ma = ma + 1;
            else
                ma = ma + 0;
        }
        int index = Integer.valueOf(ma, 2);
        return index;
    }

}