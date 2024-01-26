package com.kodilla.stream;


import com.kodilla.stream.beautufier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier beautifier = new PoemBeautifier();

        String result1 = beautifier.beautify("Kodilla Course!", text -> text.toUpperCase());
        System.out.println(result1);

        String result2 = beautifier.beautify("Kodilla Course!", text -> "ABC " + text + " ABC");
        System.out.println(result2);

        String result3 = beautifier.beautify("Kodilla Course!", text -> new StringBuilder(text).reverse().toString());
        System.out.println(result3);

        String result4 = beautifier.beautify("Kodilla Course!", text -> {
            String border = "*".repeat(text.length() +4);
            return border + "\n* " + text + " *\n" + border;
                });
        System.out.println(result4);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}