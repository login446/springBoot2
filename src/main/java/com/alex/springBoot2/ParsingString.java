package com.alex.springBoot2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by alex on 12.10.2016.
 */
public abstract class ParsingString {
    public static ArrayList<Word> parsing(String s) {
        String[] words = toLowerCasePlusSpace(s).replaceAll("[^a-z]"," ").split(" ");
        LinkedList<Word> linkedList = new LinkedList<Word>();
        for (String word : words)
            linkedList.add(new Word(word));
        ArrayList<Word> arrayList = new ArrayList<Word>();
        for (Word temp : linkedList) {
            if (arrayList.contains(temp))
                arrayList.get(arrayList.indexOf(temp)).addOneCount();
            else arrayList.add(temp);
        }
        if(arrayList.contains(new Word("")))
            arrayList.remove(new Word(""));
        Collections.sort(arrayList);
        return arrayList;
    }
    private static String toLowerCasePlusSpace(String s){
        return s.replace("A", " a").replace("B", " b").replace("C", " c").replace("D", " d").
                replace("E", " e").replace("F", " f").replace("G", " g").replace("H", " h").
                replace("I", " i").replace("J", " j").replace("K", " k").replace("L", " l").
                replace("M", " m").replace("N", " n").replace("O", " o").replace("P", " p").
                replace("Q", " q").replace("R", " r").replace("S", " s").replace("T", " t").
                replace("U", " u").replace("V", " v").replace("W", " w").replace("X", " x").
                replace("Y", " y").replace("Z", " z");
    }
}
