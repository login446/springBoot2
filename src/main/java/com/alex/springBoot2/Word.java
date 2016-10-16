package com.alex.springBoot2;

/**
 * Created by alex on 12.10.2016.
 */
public class Word implements Comparable<Word>{
    private String name;
    private int count;
    public Word(String name){
        this.name = name;
        this.count = 1;
    }

    public void addOneCount(){
        count++;
    }
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return name != null ? name.equals(word.name) : word.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public int compareTo(Word o) {
        if(count > o.getCount())
            return -1;
        if(count < o.getCount())
            return 1;
        return 0;
    }
}
