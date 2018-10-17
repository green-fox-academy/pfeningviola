public class VariableMutation {
    public static void main(String[] args) {

        int a = 3;
        a += 10;
        System.out.println(a);

        int b = 100;
        b -= 7;
        System.out.println(b);

        int c = 44;
        c *= 2;
        System.out.println(c);

        int d = 125;
        d /= 5;
        System.out.println(d);

        int e = 8;
        e = e*e*e;
        System.out.println(e);

        int f1 = 123;
        int f2 = 345;
        boolean f3 = (f1>f2);
        System.out.println(f3);

        int g1 = 350;
        int g2 = 200;
        boolean g3 = ((g2*2) > g1);
        System.out.println(g3);

        int h = 135798745;
        int reminder = h % 11;
        boolean div = (reminder ==0);
        System.out.println(div);

        int i1 = 10;
        int i2 = 3;
        boolean i3 = (i1 > (i2*i2)) && (i1 < (i2*i2*i2));
        System.out.println(i3);

        int j = 1521;
        int reminder3 = j % 3;
        int reminder5 = j% 5;
        boolean divJ = (reminder3 == 0) || (reminder5 == 0);
        System.out.println(divJ);

        String k = "Apple";
        k = k + k + k + k;
        System.out.println(k);
    }

}
