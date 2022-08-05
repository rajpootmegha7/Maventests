package mainclasses;

public class Student {
    public static class Children{
        String name;
        String gender;
        int roll;
        Children(){};
        Children(String name,String gender, int roll){
            this.name = name;
            this.gender = gender;
            this.roll = roll;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

    public static void main(String args[]){
        Children ch = new Children("Mukesh","unknown",123);
        Children obj =  new Children();
        Children[] arr_ob = new Children[1];
        arr_ob[0] = new Children("Mukesh","unknown",123);;
        
        for (Children chs:arr_ob) {
            System.out.println(chs.getName());
        }
        System.out.println(obj.getName());
        System.out.println(ch.name);
    }
}
