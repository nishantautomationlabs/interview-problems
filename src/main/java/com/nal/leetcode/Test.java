package com.nal.leetcode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by nishant on 04/02/20.
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] {1,2,3}));
        result.add(list);
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{4, 5, 6}));
        result.add(list2);
        System.out.println(result.toString());

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        Map<String, String> map = new HashMap<>();
        map.put("1","nishant");
        map.put("2","singh");
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.remove("2");

        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.add(1, 2);
        System.out.println(integerArrayList.size());
        integerArrayList.remove(integerArrayList.size()-1);
        integerArrayList.set(1, 5);
        List<Integer> subList = integerArrayList.subList(1, 2);
        System.out.println(integerArrayList.indexOf(3));



        int a = Integer.valueOf('a');
        int sa = Integer.parseInt("124");
        String s3 = Integer.toString(sa);

        System.out.println(sa);
//        List<Integer> indexes = new ArrayList<>();
//        indexes.add(2);
//        indexes.add(4);
//        indexes.add(7);
//        indexes.add(9);
//        indexes.add(11);
//        int index1 = Collections.binarySearch(indexes, 5);

        int[] arr = {1, 4, 5, 2, 3};
//        arr = new int[]{2, 3, 4, 6};
        Arrays.sort(arr);
        int[] newarr = new int[10];
        System.arraycopy(arr, 1, newarr, 3, 4);
//        String[] str = {"asasd","dfd", "ewe", "sdsdsds2"};
//
//        Arrays.sort(str, Comparator.comparingInt(String::length).reversed());
//        for(String str1 : str)
//            System.out.println(str1);

        List<String> str2 = new ArrayList<>();
        str2.add("dsad");
        str2.add("dsd");
        str2.add("dabb");
        str2.add("ds");
        str2.add("dssdfdf");
        Collections.sort(str2);
        Collections.sort(str2, (s1, s2) -> {
            if(s1.length() != s2.length())
                return s2.length() - s1.length();
            return s1.compareTo(s2);
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

//        str2 = str2.stream().sorted(Comparator.comparingInt(s -> s.length())).collect(Collectors.toList());
        for(String aq : str2)
            System.out.println(aq);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        List<Integer> integerArray = new ArrayList<>(stack);
        stack.isEmpty();

//        HashMap<String, List<String>> map = new HashMap<>();
//        map.values();

//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        String key = new String(chars);

        String[] sas =
                "2001:0db8:85a3.0:0.8A2E:0370:7334:".split("0.");

        StringBuilder sb = new StringBuilder("nishant singh");
        sb.insert(0, "A");
        sb.append('a');
        sb.append("nishant");
        sb.append(12);
//        Math.pow()  //returns double
//        sb.length();
//        sb.deleteCharAt()
        sb.reverse();
//        sb.setLength(0);
        System.out.println(sb.toString());
        System.out.println("Done");

        String s = "  hello world!  ";
        s.length();
        char[] chars = {'a','b','b'};

        char a1 = Character.toLowerCase('A');

//        Math.pow

        String[] words = s.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        s = String.join(" ", words);
        System.out.println(s);

    }
}
