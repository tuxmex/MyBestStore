package mx.store.foundations;

import java.util.List;

public class Practices {
    private static int a;


    public static void main(String[] args) {

        /*String ocean = new String("Atlantic Ocean");
        System.out.println(ocean.indexOf('a'));*/
        /*int x;
        int y = 4;
        int z = 10;
        x = z%y;
        System.out.println(x);*/
        /*int z=5, m=6;
        double x = z/m;
        System.out.println(x);*/
       /* int num[]={9,8,7,6,5,4,3,2,1};
        for(int i=0;i<9;i=i+3)
            System.out.print(num[i]);*/
        //System.out.println(args.length);
        /*
        if ((5.1 > 4.3 && 6.2 < 8.4) && !(7.2 < 3.5 || 1.2 == 2.1 || 2.2 != 2.25)){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }

        System.out.println(!(3<4&&6>6||6<=6&&7-2==6));
        */

       /* String[] words = {"Yes","No"};
        String s = (words.length<words[1].length())?words[0]:words[1];
        System.out.println(s);*/

       /* boolean x=false, y=true;
        System.out.println("I. (x || y) && !(x && y): "+ ((x || y) && !(x && y)));
        System.out.println("II. (x && !y) || (!x && y): "+ ((x && !y) || (!x && y)));
        System.out.println("III. (x || y) && (!x ||!y): "+ ((x || y) && (!x ||!y)));*/

        /*int num = 7;
        while(num >= 0){
            num -= 3;
        }
        System.out.println(num);*/

        /*for (int i = 10; i < 20; i++) {
            System.out.println("i: " + i);
        }
*/

     /*   List nums = new ArrayList();
        nums = Practices.returnList(nums);
        ArrayList nums = new ArrayList();
        nums = Practices.returnList(nums);
        ArrayList nums1 = new ArrayList();
        List nums2 = Practices.returnList(nums1);
*/
 /*       boolean status=false;
        int i=1;
        System.out.println(i);
        if( (++i>1)  && (status=true)) {
            System.out.println(i);
            i++;
        }
        System.out.println(i);
        if( (++i>3)  ||  (status=false))
            i++;
        System.out.println(i);*/

        /*int x = 1;
        int y;
        while(++x < 5)
            y++;
        System.out.println(y);*/

       /* String str1 = "java";
        String str2 = "java";
        System.out.println(str1.equals(str2) + "," + str1.equals(new String("hello")));
        */
      /*  int id[];
        int i[1];
        int i[1] id;
        int[] id1= new int[]{1,2,3,4,5};*/
/*        int[] myarray={1,2,3,4,5};
        int sum=0;
        for (int x : myarray)
            sum+=x;
        System.out.println("sum= " + sum);*/

     /*   int i=0, j=0;
        i=i++;
        j=i++;
        System.out.println("i=" + i + " " + "j=" + j);*/

     /*   float f = 3.0L;


        float f1 = -1;


        float f2 = 0x345;


        float f3 = 2.0f;


        float f4 = 1.0;*/

        System.out.println(1 + 2 + "java" + 3);
    }

    public static List returnList(List list) {
        return list;
    }


}
