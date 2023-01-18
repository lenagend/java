import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class 람다유용한메서드 {

    public static void main(String[] args) {
        List<Bike> cart = new ArrayList<>();
        cart.add(new Bike("red",50));
        cart.add(new Bike("green", 50));
        cart.add(new Bike("white",40));
        cart.add(new Bike("black",70));

        //Comparator 조합
        System.out.println("Comparator 조합 테스트");

        Comparator<Bike> b = Comparator.comparing(Bike::getWeight);

        cart.sort(b);

        for (Bike bike: cart) {
            System.out.println(bike.getWeight() + ", " + bike.getColor());
        }

        //역정렬
        cart.sort(Comparator.comparing(Bike::getWeight).reversed());

        for (Bike bike: cart) {
            System.out.println(bike.getWeight() + ", " + bike.getColor());
        }

        //무게가 같은경우 색으로 정렬
        cart.sort(Comparator.comparing(Bike::getWeight).reversed().thenComparing(Bike::getColor));


        for (Bike bike: cart) {
            System.out.println(bike.getWeight() + ", " + bike.getColor());
        }


        //Predicate 조합
        //negate = 반전, and, or 메서드 제공
        //람다표현식을 조합해서 더 복잡한 람다 표현식을 만들 수 있다.
        System.out.println("Predicate 조합 테스트");
        Predicate<Bike> redBike = bike -> bike.getColor().equals("Red");
        Predicate<Bike> notRedBike = redBike.negate();
        Predicate<Bike> notRedAndHeavy = notRedBike.and(bike -> bike.getWeight() > 50);
        Predicate<Bike> notRedAndHeavyOrWhite = notRedAndHeavy.or(bike -> bike.getColor().equals("white"));

        List<Bike> filteredCart = cart.stream().filter(notRedAndHeavyOrWhite).collect(Collectors.toList());
        for (Bike bike: filteredCart) {
            System.out.println(bike.getWeight() + ", " + bike.getColor());
        }
    }




}
class Bike{

    public Bike(long weight) {
        this.weight = weight;
    }

    public Bike(String color) {
        this.Color = color;
    }

    public Bike(String color, long weight) {
        Color = color;
        this.weight = weight;
    }

    public String getColor() {
        return Color;
    }

    public long getWeight() {
        return weight;
    }

    private String Color;
    private long weight;

}