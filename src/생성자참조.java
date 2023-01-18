import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class 생성자참조 {
    public static void main(String[] args) {
        BiFunction<String, Integer, Car> c1 = Car::new;
        Car car1 = c1.apply("RED", 1001);
        System.out.println("차의 색깔은 " + car1.getColor() + "이고, 무게는 " + car1.getWeight() + "kg입니다.");

        Map<String, Function<String, Car>> map = new HashMap<>();
        map.put("redCar", Car::new);
    }


}
class Car{

    public Car(String color) {
        Color = color;
    }

    public Car(String color, long weight) {
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