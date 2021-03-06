import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;

class WrongStudentName extends Exception { }
class WrongAge extends Exception { }
class WrongDate extends Exception { }

class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                int ex = menu();
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                    default: return;
                }
            } catch(IOException e) {

            } catch(WrongStudentName e) {
                System.out.println("Błędne imie studenta!");
            } catch(WrongAge e) {
                System.out.println("Zły wiek!");
            }
             catch(WrongDate e) {
                System.out.println("Zła data!");
            }
          
        }
    }

    public static int menu() {
        System.out.println("Wcisnij:");
        System.out.println("1 - aby dodah studenta");
        System.out.println("2 - aby wypisać wszystkich studentów");
        System.out.println("3 - aby wyszukać studenta po imieniu");
        System.out.println("0 - aby wyjść z programu");
        return scan.nextInt();
    }

    public static String ReadName() throws WrongStudentName, WrongAge, WrongDate {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }

    public static void exercise1() throws IOException, WrongStudentName, WrongAge, WrongDate {
        var name = ReadName();
        System.out.println("Podaj wiek: ");
        var age = scan.nextInt();
        scan.nextLine();
      if(age>100 || age<0)
            throw new WrongAge();
         System.out.println("Podaj dzien urodzenia");
        var day = scan.nextInt();
        if(day>31 || day<1)
            throw new WrongDate();
        System.out.println("Podaj miesiąc urodzenia");
        var month = scan.nextInt();
      if(month>12 || month<1)
            throw new WrongDate();
        System.out.println("Podaj rok urodzenia");
        var year = scan.nextInt();
      if(year>2021 || year<1)
            throw new WrongDate();
        var date = scan.nextLine();
        date = day+"-"+month+"-"+year;
        (new Service1()).addStudent(new Student(name, age, date));
    }

    public static void exercise2() throws IOException {
        var students = (new Service1()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service1()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}