public class Variables {
    public static void main(String[] args) {

        //FavoriteNumber
        int favoriteNumber = 20;
        System.out.println("My favorite number is: " + favoriteNumber);

        //Swap
        int a = 123;
        int b = 526;
        int c = b;
        b = a;
        a = c;

        System.out.println(a);
        System.out.println(b);

        //BMI
        double massInKg = 81.2;
        double heightInM = 1.78;
        double bmi = massInKg/heightInM/heightInM;

        System.out.println("BMI: " + bmi);

        //DefineBasicInfo
        String name = "Viola Pfening";
        int age = 32;
        double height = 1.74;
        boolean married = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Married: " + married);

    }
}