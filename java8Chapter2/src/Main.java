import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //10
        //System.out.println(average(Stream.of(2.0, 4.0, 6.0, 8.0)));
        //11
        //System.out.println(ex11());
        //12
        perform();
    }

    //10
//    static Pair<Integer, Double> pair = new Pair<>(0, 0.0);
//
//    Pair<Integer,Double> average(Stream<Double> stream){
//        return stream.reduce(
//                pair,
//                this::add,
//                this::combine
//                )
//    }
//
//    Pair<Integer, Double> add(double value){
//        return new Pair<>(pair.getKey()+1,pair.getValue()+value);
//    }
//
//    Pair<Integer, Double> combine(Pair<Integer,Double> pairToCombine){
//        return new Pair<>(pair.getKey()+pairToCombine.getKey(),pair.getValue()+pairToCombine.getValue());
//    }


    //11
//    static List<String> ex11(){
//        List<ArrayList<String>> list = new ArrayList<>();
//        list.add(new ArrayList<>(Arrays.asList("1", "2", "3")));
//        list.add(new ArrayList<>(Arrays.asList("4", "5", "6", "7")));
//        list.add(new ArrayList<>(Arrays.asList("8", "9", "10")));
//        return concatenate(list.stream());
//    }
//
//    static List<String> concatenate(Stream<ArrayList<String>> stream) {
//        String[] charArray = stream.flatMap(Collection::stream).toArray(String[]::new);
//        IntStream rangeStream = IntStream.range(0, charArray.length);
//        List<String> resultList = new ArrayList<>(Arrays.asList(new String[charArray.length]));
//        rangeStream.parallel().forEach(e -> resultList.set(e, charArray[e]));
//        return resultList;
//    }

    //12
    static void perform() {
        List<String> words = Arrays.asList("primulCuvant", "alDoileaCuvant", "alTreilea", "alPatruleaCuvant", "cinci");
        AtomicInteger[] shortWords = new AtomicInteger[12];
        words.parallelStream().forEach(
                word -> {
                    int length = word.length();
                    if (length < 12) {
                        AtomicInteger i = shortWords[length];
                        if (i == null) {
                            i = new AtomicInteger();
                            shortWords[length] = i;
                        }
                        i.getAndIncrement();
                    }
                }
        );
        Arrays.asList(shortWords).forEach(System.out::println);
    }



}
