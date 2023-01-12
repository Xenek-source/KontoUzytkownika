import java.util.Objects;
import java.util.Scanner;
public class Baza {
    Scanner scan = new Scanner(System.in);
    int wiek;
    Baza[] account = new Baza[2];
    String imie, nazwisko;
    String nazwaKonta, haslo, phaslo, email;
    Baza user;
    int pozycja = 0;
    char r;

    public Baza() {
    }
    public void welcome(){
        System.out.println("### Witaj w panelu logowania #####");
        System.out.println("### >>> 'R' by utworzyć konto ####");
        System.out.println("### >>> 'L' by zalogować się #####");
    }
    public void registerUser() {
        r = scan.next().charAt(0);
        scan.nextLine();
        if ((r == 'r') || (r == 'R')) {
            addUser();
        } else {
            if ((r == 'l') || (r == 'L')) {
                loadUser();
            } else {
                System.out.println("######## Błędny przycisk! ########");
                registerUser();
            }
        }
        System.out.println();
        System.out.println();
    }
    public void setUser() {
        System.out.println("###############################");
        System.out.println("####   Skonfiguruj konto   ####");
        System.out.println("###############################");
        System.out.println();
        System.out.println("######### Wpisz imię: #########");
        imie = scan.nextLine();
        System.out.println("####### Wpisz nazwisko: #######");
        nazwisko = scan.nextLine();
        System.out.println("######### Wpisz wiek: #########");
        wiek = scan.nextInt();
        scan.nextLine();
        System.out.println("########### Wciśnij: ##########");
        System.out.println("#### >>> 'R' by zresetować ####");
        System.out.println("#### >>> 'Z' by zapisać #######");
        r = scan.next().charAt(0);
        scan.nextLine();
        if ((r == 'r') || (r == 'R')) {
            setUser();
        } else {
            if ((r == 'z') || (r == 'Z')) {
                System.out.println("########## Zapisane. ##########");
            } else {
                System.out.println("###### Błędny przycisk! #######");
                setUser();
            }
        }
        System.out.println();
        System.out.println();
    }
    public void addUser() {
        user = new Baza();
        System.out.println("##### Witaj! Utwórzmy konto ######");
        System.out.println("##################################");
        System.out.println();
        System.out.println("Wpisz nazwę użytkownika:");
        user.nazwaKonta = scan.nextLine();
        setPassword();
        System.out.println("Wpisz adres email:");
        user.email = scan.nextLine();
        System.out.println();
        System.out.println("####### Konto utworzone #######");
        System.out.println();
        System.out.println();
        user.setUser();
        account[pozycja] = user;
        pozycja++;
        registerUser();
        System.out.println();
        System.out.println();
    }
    public void setPassword(){
        System.out.println("Wpisz hasło użytkownika:");
        user.haslo = scan.nextLine();
        System.out.println("Powtórz hasło użytkownika:");
        user.phaslo = scan.nextLine();
        if (!Objects.equals(user.haslo, user.phaslo)){
        System.out.println("### Hasła nie są takie same. ###");
        setPassword();
        }
    }
    public void loadUser() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("###############################");
        System.out.println("####   Wczytywanie konta   ####");
        System.out.println("###############################");
        System.out.println();
        System.out.println("Podaj nazwę użytkownika");
        String load = scan.nextLine();
        if (Objects.equals(load, account[0].nazwaKonta)) {
            System.out.println("Wpisz hasło");
            String pass = scan.nextLine();
            if (Objects.equals(pass, account[0].haslo)) {
                System.out.println("Zalogowano poprawnie, konto:" + account[0].nazwaKonta);
                System.out.println("Witaj!");
                System.out.println();
            } else {
                System.out.println("Błędne hasło.");
                loadUser();
                System.out.println();
                System.out.println();
            }
        } else {
            System.out.println("Nie ma takiego konta, spróbuj ponownie.");
            loadUser();
            System.out.println();
            System.out.println();
        }

    }
}

