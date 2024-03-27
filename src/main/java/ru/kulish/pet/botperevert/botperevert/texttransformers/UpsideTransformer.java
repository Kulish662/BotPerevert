package ru.kulish.pet.botperevert.botperevert.texttransformers;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpsideTransformer implements Transformer {
    private String normal;
    private String upside;

    public UpsideTransformer() {
        normal = "abcdefghijklmnopqrstuvwxyz_,;.?!/\\'";
        upside = "ɐqɔpǝɟbɥıظʞןɯuodbɹsʇnʌʍxʎz‾'؛˙¿¡/\\,";
        //CapEng
        normal += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        upside += "∀qϽᗡƎℲƃHIſʞ˥WNOԀὉᴚS⊥∩ΛMXʎZ";
        //number
        normal += "0123456789";
        upside += "0ƖᄅƐㄣϛ9ㄥ86";
        //rus
        normal += "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        upside += "ɐgʚL6ǝǝжєииʞvwноudɔ⊥ʎфхцҺmmqqıqєюʁ";
        normal += "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        upside += "ɐgʚL6ǝǝжєииʞvwноudɔ⊥ʎфхцҺmmqqıqєюʁ";
    }

    @Override
    public String transform(String text) {
        return text.chars()
                .mapToObj(e-> {
                    int charIndex = normal.indexOf(e);
                    char i = charIndex == -1 ? (char) e : upside.charAt(charIndex);
                    return String.valueOf(i);
                })
//                .map(e-> (char) e)
                .peek(e-> {
                    System.out.println(e);
                })
//                .mapToObj(String::valueOf)
//                .peek(e-> System.out.println(e))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String transform = new UpsideTransformer().transform("Привет из Австралии, как дела?  Hello Boi???");
        System.out.println("\n\n\n");
        System.out.println(transform);
        System.out.println("\n\n\n");
    }
}
