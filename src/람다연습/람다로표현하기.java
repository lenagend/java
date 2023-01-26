package 람다연습;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 람다로표현하기 {
    public static void main(String[] args) {
        List<Banana> basket = new ArrayList<>();
        basket.add(new Banana(50));
        basket.add(new Banana(40));
        System.out.println(basket.get(0));

        //1단계코드 동작 파라미터화
        basket.sort(new BananaComparator());
        System.out.println(basket.get(0).getWeight());

        //2단계 익명클래스사용
        basket.add(new Banana(30));
        basket.sort(new Comparator<Banana>() {
            @Override
            public int compare(Banana o1, Banana o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        System.out.println(basket.get(0).getWeight());

        //3단계 람다표현식 사용
        basket.add(new Banana(20));
        basket.sort((Banana o1, Banana o2)->Integer.compare(o1.getWeight(), o2.getWeight()));
        System.out.println(basket.get(0).getWeight());

        //4단계 메서드참조 사용
        basket.add(new Banana(10));
        basket.sort(Comparator.comparing(Banana::getWeight));
        System.out.println(basket.get(0).getWeight());
    }

}

class BananaComparator implements Comparator<Banana>{
    @Override
    public int compare(Banana o1, Banana o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}

class Banana{
    private int weight;

    public Banana(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
