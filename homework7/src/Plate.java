public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Еды в миске: " + food + "%";
    }

    public void decreaseFood(int przh) {
        if (food >= przh)
            food -= przh;
    }

    int foodnum() {
        return food;
    }

    public void increaseFood (int n) {
        food += n;
    }
}
