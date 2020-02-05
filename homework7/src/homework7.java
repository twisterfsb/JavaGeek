public class homework7 {
    public static void main(String[] args) {
        Cat[] cat = {new Cat("П*др пушистый", 70), new Cat("Реми", 40), new Cat("Селешка", 30)};
        Plate plate = new Plate(100);
            for (Cat c : cat){
                System.out.println(c);
            }

        System.out.println(plate);
        System.out.println("После каждого кота в миску добавляется по: 10% еды");
        System.out.println("\n************************************************\n");

        for (Cat c : cat) {
            c.eat(plate);
            System.out.println(c);
            plate.increaseFood(10);
            System.out.println(plate + "\n");

        }
    }
}
