package ru.kulish.pet.botperevert.botperevert.texttransformers;

import java.util.stream.Collectors;

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
        upside += "ɐgʚL6ǝǝжєииʞvwноudɔ⊥ʎфхцҺmmqıqєюʁ";
        normal += "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        upside += "ɐgʚL6ǝǝжєииʞvwноudɔ⊥ʎфхцҺmmqıqєюʁ";
    }

    @Override
    public String transform(String text) {
        return text.chars()
                .mapToObj(this::getUpsideChar)
                .collect(Collectors.joining());
    }

    private String getUpsideChar(int charInInt) {
        int charIndex = normal.indexOf(charInInt);
        //upside char ы contains two chars
        if(charInInt == 'ы' || charInInt == 'Ы') return "qı";
        char i = charIndex == -1 ? (char) charInInt : upside.charAt(charIndex);
        return String.valueOf(i);
    }

}
