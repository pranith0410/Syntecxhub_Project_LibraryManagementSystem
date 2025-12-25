import java.io.*;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.txt";

    public Library() {
        loadBooksFromFile();
    }

    private void loadBooksFromFile() {
        File file = new File(FILE_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    if (data.length != 3) continue;

                    int id = Integer.parseInt(data[0].trim());
                    String title = data[1].trim();
                    String author = data[2].trim();

                    books.add(new Book(id, title, author));

                } catch (Exception ignored) {
                    // skip invalid/old-format lines safely
                }
            }
            br.close();

        } catch (IOException e) {
            System.out.println("⚠️ Unable to load books file.");
        }
    }

    private void saveBooksToFile() {
        if (books.isEmpty()) {
            return;
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Book book : books) {
                bw.write(
                    book.getId() + "," +
                    book.getTitle() + "," +
                    book.getAuthor()
                );
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            System.out.println("⚠️ Unable to save books file.");
        }
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
        System.out.println("✅ Book added successfully!");
    }

    public void removeBook(int id) {
        boolean found = false;

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                saveBooksToFile();
                System.out.println("✅ Book removed successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Book not found!");
        }
    }

    public void searchBook(String title) {
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(
                    "ID: " + book.getId() +
                    ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Book not found!");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books available.");
        } else {
            System.out.println("📚 Library Books:");
            for (Book book : books) {
                System.out.println(
                    "ID: " + book.getId() +
                    ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor()
                );
            }
        }
    }
}
