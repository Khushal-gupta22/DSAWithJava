package com.company;

public class searchInStrings {
    public static void main(String[] args) {
        String name = "Khushal";
        char target = 'u';
        System.out.println(search(name,target));
    }

    static boolean search2(String str, char target){
        if (str.length()==0){
            return false;
        }
        for(char ch : str.toCharArray()) {  //toCharArray converts string to characters
            if (ch==target){
                return true;

            }

        }
        return false;
    }

    static boolean search(String str, char target){
        if(str.length()==0){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (target==str.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
