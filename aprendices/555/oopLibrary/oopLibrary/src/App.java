import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Book> books = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        do {
            System.out.println("Sistema de biblioteca");
            System.out.println("1. Registrar libro");
            System.out.println("2.Listar libro");
            System.out.println("5. salir");
            opcion = scan.nextInt();
            scan = new Scanner(System.in);
            switch (opcion) {
                case 1:
                    registerBook();
                    break;
                case 2:
                    getListBooks();
                    break;

                default:
                    System.out.println("Opción no valida");
                    break;
            }

        } while (opcion != 5);
        System.out.println("chao");
    }

    public static void registerBook() {
        Book book = new Book();
        System.out.println("Ingrese la información del libro");
        System.out.println("Titulo");
        book.title = scan.nextLine();
        System.out.println("Autor");
        book.author = scan.nextLine();
        // El resto de los campos
        books.add(book);
    }

    public static void getListBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
        if (books.size() == 0) {
            System.out.println("No hay libros registrados");
        }
    }
}
