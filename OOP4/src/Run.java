import com.babies.Baby;
import com.mothers.Mother;

public class Run {

    public static void main(String[] args) {
        Mother mother = new Mother("Jane");
        Baby baby = new Baby("Joe", mother);

        baby.feed(44);

    }

}

