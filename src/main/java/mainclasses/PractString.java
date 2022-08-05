package mainclasses;

public class PractString {
    public static void main (String args[]) {
        PractString ps = new PractString();
        //ps.palendromeStrTest("1tootq");
       // ps.datastructTest();
        ps.palenum(123321);

    }
       public void array1() {
            int a[] = new int[6];//declaration and instantiation
            a[0] = 1;
            a[1] = 11;
            a[2] = 12;
            a[3] = 13;
            a[4] = 14;
            a[5] = 15;

            for (int i = 0; i <= a.length - 1; i++) {
                System.out.println(a[i]);
            }

        }
        public void datastructTest(){
        int i = 5/3;
        System.out.print(i);
        }
        public void arrayforeach(){
        int a[] = new int[5];
            a[0] = 12;
            a[1] = 13;
            a[2] = 14;
            a[3] = 17;
            a[4] = 22;
            for (int j: a) {
                System.out.println(j);
            }
        }

        public void matrixMultiplication() {
        int a[][] = {{1,1,1},{2,2,2},{3,3,3}};
        int b[][]= {{1,1,1},{2,2,2},{3,3,3}};
        //create another array to store the results.
            int c[][]= new int[3][3];

        }
        public void palendromeStrTest(String str) {
        char[] ch = str.toCharArray();
        int i,j;
        boolean pal = true;
        for(i=0,j=ch.length-1; i<j; i++,j--){
                if(ch[i]!=ch[j]) {
                    pal = false;
                    break;
                }
        }
        if (pal==true) System.out.println("String is a palendrome");
        else System.out.println("String is not a palendrome!");

        }
        public void palenum(int n) {

        int mod = n%10000;
        int div = n/10000;
       System.out.println("mod"+mod);
            System.out.println("reverse"+div);
        int rev = div%10000;
            System.out.println(rev);
            if (rev!=div){
                System.out.print("Integer is not palendrome.");
            }else System.out.println("Integer is palendrome");
        }
    }

