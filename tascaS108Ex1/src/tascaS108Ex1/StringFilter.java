package tascaS108Ex1;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StringFilter {
    public static List<String> findStringsWithO(List<String> strings) {
        return strings.stream()
                .filter(str -> str.toLowerCase().contains("o"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        
        List<String> words = Arrays.asList("Hello", "World", "Java", "Programming", "Code");
        List<String> result = findStringsWithO(words);
        System.out.println("Strings containing 'O': " + result);
    }
}