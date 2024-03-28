package ru.kulish.pet.botperevert.botperevert.texttransformers;

public class MirrorTransformer implements Transformer{

    @Override
    public String transform(String text) {
        if(text == null) return null;
        return new StringBuilder(text).reverse().toString();
    }
}
