package ru.stqa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP", "Swift"};

        List<String> languages = Arrays.asList("Java", "C#", "Python", "Swift");


    for (int i = 0; i < languages.size(); i++ ) {
        System.out.println("Я хочу выучить " + languages.get(i));
    }
        }
}
