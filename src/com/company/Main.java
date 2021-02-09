package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String format = "0.####";
            DecimalFormat df = new DecimalFormat(format);
            double a = 0, b = 0, c = 0;
            while (true) {
                System.out.println("Введіть a");
                a = input_double(reader, a);
                System.out.println("Введіть b");
                b = input_double(reader, b);
                System.out.println("Введіть c");
                c = input_double(reader, c);
                double D = b*b - 4*a*c;
                if(D==0){
                    String xx;
                    double x = -b/2/a;
                    if(df.format(-x).startsWith("-"))xx = df.format(-x);
                    else xx = "+ "+df.format(-x);
                    System.out.println("x "+xx+" = 0");
                }else{
                    if(D > 0) {
                        double x1 = (-b + Math.sqrt(D))/2/a;
                        double x2 = (-b - Math.sqrt(D))/2/a;
                        String xx1, xx2;
                        if(df.format(-x1).startsWith("-"))xx1 = df.format(-x1);
                        else xx1 = "+ "+df.format(-x1);
                        if(df.format(-x2).startsWith("-"))xx2 = df.format(-x2);
                        else xx2 = "+ "+df.format(-x2);
                        System.out.println("(x "+xx1+")(x "+xx2+") = 0");
                    }else{
                        String xx1,xx2;
                        if(a < 0){
                            xx1 = df.format(b/2/a)+" + "+df.format(Math.sqrt(-D)/2/-a)+" * i";
                            xx2 = df.format(b/2/a)+" - "+df.format(Math.sqrt(-D)/2/-a)+" * i";
                        }else{
                            xx1 = df.format(b/2/a)+" + "+df.format(Math.sqrt(-D)/2/a)+" * i";
                            xx2 = df.format(b/2/a)+" - "+df.format(Math.sqrt(-D)/2/a)+" * i";
                        }
                        if(xx1.startsWith("-")) System.out.println("(x "+xx1+")(x "+xx2+") = 0");
                        else System.out.println("(x + "+xx1+")(x + "+xx2+") = 0");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Невдача");
        }
    }
    public static double input_double(BufferedReader reader, double m) throws IOException {
        String t = reader.readLine();
        try {
            m = Double.parseDouble(t);
        }catch (NumberFormatException e) {
            System.out.println("Невдача, введіть число ще раз");
            m = input_double(reader, m);
        }
        return m;
    }
}
