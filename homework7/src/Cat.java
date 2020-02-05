public class Cat {
    private String name;
    private int przh;
    private boolean isFull;

    public Cat(String name, int przh) {
        this.name = name;
        this.przh = przh;
        this.isFull = false;
    }

    @Override
    public String toString() {
        return "Кот: " + name + " | Прожорливость: " + przh + "% | Сытый: " + isFull;
    }

    public void eat(Plate plate) {
        if (plate.foodnum() >= przh) {
            plate.decreaseFood(przh);
            isFull = true;
        }
    }
}
