public class Person {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Person(String fio, String position, String email, String phone, double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        if (age >= 18)
                this.age = age;
            else
                System.out.println("Сотрудник должен быть старше 18 лет");
    }

    int GetAge() {
        return age;
    }

    void Show() {
        System.out.println(fio + " " + position + " " + email + " " +
                phone + " " + salary + " " + age);
    }
}
