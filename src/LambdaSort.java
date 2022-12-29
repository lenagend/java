import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSort {
    public static void main(String[] args) {


        String name = "KimKwangmin";
        String name2 = "ParkSoHyun";
        List<String> nameList = new ArrayList<String>();
        nameList.add(name);
        nameList.add(name2);
        Collections.sort(nameList, (a, b)-> Integer.compare(a.length(), b.length()));

        for (int i = 0; i < nameList.size(); i++){
            System.out.println(nameList.get(i));
        }

    }

}
