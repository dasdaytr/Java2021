package Java1;

import java.util.Arrays;
import java.util.*;
public class Main<T> {
    public static void main(String[] args) {
        Integer a[] = new Integer [5];
        for (int i = 0 , l = 5; i<a.length;i++,l--){
            a[i] = l;
        }

        Consumer <Integer> get = x-> c(x);
        get.accept(a);

    }
    public static void c (Integer[] b ){
         Arrays.sort(b);
         for (int i = 0; i <b.length;i++){
             System.out.println(b[i]);
         }
    }

}
