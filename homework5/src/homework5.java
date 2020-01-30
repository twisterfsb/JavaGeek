public class homework5 {
    public static void main(String[] args) {
        Person[] PersonDb = new Person[7];
        PersonDb[0] = new Person("Жарков Алексей Алексеевич", "Техдир", "zharkov.a@mail.ru", "+7999111222333", 100000 , 48);
        PersonDb[1] = new Person("Журавлев Андрей Михайлович", "Аналитик", "zhuravlev.a@mail.ru", "+79882223344", 90000 , 24);
        PersonDb[2] = new Person("Железняков Михаил Анатольевич", "Электромонтер", "zheleznyakov.m@mail.ru", "+79773334455", 70000 , 37);
        PersonDb[3] = new Person("Солянкина Ксения Владимировна", "Контроллер ОТК", "solyankina.k@mail.ru", "+79664445566", 60000 , 27);
        PersonDb[4] = new Person("Мотовилова Александра Максимовна", "Гендир", "motovilova.a@mail.ru", "+79555556677", 120000 , 46);
        PersonDb[5] = new Person("Дмитриев Владимир Антонович", "Менеджер по развитию", "dmitriev.v@mail.ru", "+79446667788", 80000 , 42);
        PersonDb[6] = new Person("Буржев Сергей Александрович", "Ковырятель в носу", "burzhuev.s@mail.ru", "+79337778899", 990900 , 17);

        for (Person item : PersonDb){
            if (item.GetAge() > 40) item.Show();
        }
    }
}
