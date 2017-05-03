import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Game {

    public static void main(String[] args) {

        run();
    }
    private static void run(){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Location> locationMap = new HashMap<>();
        //initializing locations
        locationMap.put(0, new Location(0,"You are at home"));
        locationMap.put(1, new Location(1,"You are standing at the end of the road next to small brick building"));
        locationMap.put(2, new Location(2,"You are at the top of the hill"));
        locationMap.put(3, new Location(3,"You are inside building, a well house for a small spring"));
        locationMap.put(4, new Location(4,"You are in the valley beside a stream"));
        locationMap.put(5, new Location(5,"You are in the forest"));
        //initializing exits
        locationMap.get(1).addExit("W",2);
        locationMap.get(1).addExit("E",3);
        locationMap.get(1).addExit("S",4);
        locationMap.get(1).addExit("N",5);

        locationMap.get(2).addExit("N",5);

        locationMap.get(3).addExit("W",1);

        locationMap.get(4).addExit("N",1);
        locationMap.get(4).addExit("W",2);

        locationMap.get(5).addExit("S",1);
        locationMap.get(5).addExit("W",2);
        //main game loop

        int actualLocation = 1;

        while (true){
            System.out.println(locationMap.get(actualLocation).getId() +
                    " " + locationMap.get(actualLocation).getDescription());
            if(actualLocation == 0){
                break;
            }
            Map<String,Integer> availableLocations = new HashMap<>(locationMap.get(actualLocation).getExits());
            System.out.println("Available locations to exit are: ");
            for(String exit: availableLocations.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if(availableLocations.containsKey(direction)){
                actualLocation = availableLocations.get(direction);
            }
            else {
                System.out.println("No such location found.");
            }

        }

    }

}


