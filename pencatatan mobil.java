// import amunisi buat perang
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

//setting dlu kelas crud nya buat ngeset property dan bikin setter getter
//yang belum paham setter getter..silahkan baca radio dengerin koran main google
class crud {
    //paramter property ada private ,public dan protected tapi kita pake private
    //alasan nya karna property ini hanya diakses oleh kelas nya dia sendiri
    private int empno;
    private String ename;
    private int salary;


    //disini adalah setter getter
    //perhatikan fungsi crud dibawah ini dia masukin parameter empno,ename dan salary dia disini ngeset
    //empno diisi empno dan seterusnya

    //disini buat ngeset
    crud(int empno, String ename, int salary){
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    //disini buat nge get
    public int getEmpno(){
        return empno;
    }
    
    public int getSalary(){
        return salary;
    }

    public String getEname(){
        return ename;
    }


    //ngeformat buat listing hasil query
    public String toString(){
        return empno+ " "+ename+" "+salary1;
    }
   
}

class CRUDDemo{

    public static void main(String[] args){
        List<crud> c = new ArrayList<>();
        //udah tau kan fungsi scanner buat apaan? 
        //materi kemaren sempet ada fungsi scanner, kalo lupa silahkan baca komik
        Scanner s =  new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch; // ch disini sebagai variable integer yang isinya buat iterasi looping perintah dibawah 

        //kita pasangin fungsi do - while supaya dia bisa ngelist perintah kebawah ...sampe bawah...
        do{
            //ini perintah/menu yang bisa kita pake
            System.out.println("1.Data Mobil");
            System.out.println("2.Data display");
            System.out.println("3.Search ");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("Enter your choice");

            ch = s.nextInt();
            switch(ch){
                //disini kita pakein switch case
                case 1:
                System.out.print("Enter your number : ");
                int eno = s.nextInt();
                System.out.print("Enter your car : ");
                String ename = s1.nextLine();
                System.out.print("how many car : ");
                int salary = s.nextInt();


                c.add(new crud(eno, ename, salary));
                break;

                case 2:
                System.out.println("---------------------------");
                Iterator<crud> i = c.iterator();
                while(i.hasNext()){
                    crud e = i.next();
                    System.out.println(e);;
                }
                System.out.println("---------------------------");
                break;
                
                case 3:
                boolean found = false;
                System.out.print("Enter your number to search : ");
                int empno = s.nextInt();
                System.out.println("---------------------------");
                i = c.iterator();
                while(i.hasNext()){
                    crud e = i.next();
                    if(e.getEmpno() == empno){
                        System.out.println(e);
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("Record not found!");
                }
                System.out.println("---------------------------");
                break;

                case 4:
                found = false;
                System.out.print("Enter your number to delete : ");
                empno = s.nextInt();
                System.out.println("---------------------------");
                i = c.iterator();
                while(i.hasNext()){
                    crud e = i.next();
                    if(e.getEmpno() == empno){
                        i.remove();
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("Record not found!");
                }else{
                    System.out.println("Record was deleted!");
                }
                System.out.println("---------------------------");
                break;

                case 5:
                found = false;
                System.out.print("Enter your number to update : ");
                empno = s.nextInt();
                System.out.println("---------------------------");
                ListIterator<crud>li = c.listIterator(); 
                while(li.hasNext()){
                     crud e = li.next();
                     if(e.getEmpno() == empno){
                        System.out.println("Enter new car : ");
                        ename = s1.nextLine();

                        System.out.println("Enter new plat");
                        salary = s.nextInt();
                        li.set(new crud(empno, ename, salary));
                        found = true;
                     }
                }

                if(!found){
                    System.out.println("Record not found!");
                }else{
                    System.out.println("Record was updated!");
                }
                System.out.println("---------------------------");
                break;


            }  
        }while(ch!=0);
    }
}