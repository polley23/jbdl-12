package com.gfg;

import javax.jnlp.ClipboardService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //Integer i = new Integer(10);
//        Integer i = 10; // auto boxing
//        int j = i; //unboxing
//        Float f  = 10f;
//        Long l = 10l;
//        //System.out.println(add(5,6));
//        Integer a = 20;
//        System.out.println("hashcode of a : "+ a.hashCode());
//        a = 30;
//        System.out.println("hashcode of a : "+ a.hashCode());
        //
        //Set<Integer> set = new HashSet<>();
        //Set<Integer> set = new LinkedHashSet<>();
        //Set<Integer> set = new TreeSet<>();
//        set.add(20);
//        set.add(10);
//        set.add(30);
//        set.add(40);
//        List<Integer> list = new ArrayList<>();
//        list.add(20);
//        list.add(10);
//        list.add(30);
//        list.add(40);


//        for(Integer i : list){
//            System.out.println(i);
//        }
//        Queue<Integer> queue = new PriorityQueue();
//        queue.add(20);
//        queue.add(10);
//        queue.add(30);
//        queue.add(40);
//
//        while(queue.size()>0){
//            System.out.println(queue.poll());
//        }
//        List<Movie> movie= new ArrayList<>();
//        movie.add(new Movie(1,4,5));
//        movie.add(new Movie(2, 3,4));
//        movie.add(new Movie(3, 4,5));
//        movie.add(new Movie(4, 5,2));
//        Collections.sort(movie, new Comparator<Movie>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                if(((Movie)o1).getCriticRating()<((Movie)o2).getCriticRating()){
//                    return 1;
//                }else if (((Movie)o1).getCriticRating()>((Movie)o2).getCriticRating()){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });
//
//        Collections.sort(movie, new Comparator<Movie>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                if(((Movie)o1).getUserRating()<((Movie)o2).getUserRating()){
//                    return 1;
//                }else if (((Movie)o1).getUserRating()>((Movie)o2).getUserRating()){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });

//        for(Movie movie1 : movie){
//            System.out.println(movie1.getId());
//        }

//        Queue<Movie> movies  = new PriorityQueue<>();
//        movies.add(new Movie(1,4,5));
//        movies.add(new Movie(2, 3,4));
//        movies.add(new Movie(3, 4,5));
//        movies.add(new Movie(4, 5,2));


//
//        movie =  sort(movie, new Comparator<Movie>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                return ((Movie)o2).getCriticRating()-((Movie)o1).getCriticRating() ;
//            }
//        });

//        while(movies.size()>0){
//            System.out.println(movies.poll().getId());
//        }
//        for(Movie movie1 : movie){
//            System.out.println(movie1.getId());
//        }
//        BufferedReader bufferedReader =
//                new BufferedReader(new InputStreamReader(System.in));
//
//       InputStreamHandler inputStreamHandler = new InputStreamHandler();
//       //inputStreamHandler.printFromConsoleUsingScanner();
//        try {
//            readConsole(bufferedReader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        FileHandler fileHandler = new FileHandler();
//        fileHandler.writeFile("test.txt", "Hello World");
//        fileHandler.writeFile("test.txt","Good bye world");
        fileHandler.deleteFile("test.txt");


    }
    public static int add(int a ,  int b){
        return a+b;
    }
    //user calls this fn
    public static List<Movie> sort(List<Movie> movie , Comparator<Movie> comparator){
        movie.sort(comparator);
        return movie;
    }

    public static void readConsole(BufferedReader bufferedReader) throws IOException {
        List<String> list = new ArrayList<>();
        String line = bufferedReader.readLine();
        while(line != null){
            list.add(line);
            line = bufferedReader.readLine();
        }
        //post process list
    }
}
