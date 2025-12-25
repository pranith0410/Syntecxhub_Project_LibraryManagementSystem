import java.io.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.txt";

    public Library() {
        loadBooksFromFile();
    }

    // Load books from file
    private void loadBooksFromFile() {

        File file = new File(FILE_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
                return; // no error, just first run
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    books.add(new Book(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]
                    ));
                }
            }
            br.close();

        } catch (IOException e) {
            System.out.println("⚠️ Unable to read data file.");
        }
    }


    // Save books to file
    private void saveBooksToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Book book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("⚠️ Error saving books to file.");
        }
    }

    // Add book
    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
        System.out.println("✅ Book added successfully!");
    }

    // Remove book
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

    // Search book
    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book ID: " + book.getId()
                        + ", Title: " + book.getTitle()
                        + ", Author: " + book.getAuthor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Book not found!");
        }
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books available.");
        } else {
            System.out.println("📚 Library Books:");
            for (Book book : books) {
                System.out.println("ID: " + book.getId()
                        + ", Title: " + book.getTitle()
                        + ", Author: " + book.getAuthor());
            }
        }
    }
}
