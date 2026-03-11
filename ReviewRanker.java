import java.util.*;
class Review {
    String reviewer;
    int rating;
    String comment;
    Review(String reviewer, int rating, String comment) {
        this.reviewer = reviewer;
        this.rating = rating;
        this.comment = comment;
    }
}
class Product {
    String name;
    String category;
    ArrayList<Review> reviews;
    Product(String name, String category) {
        this.name = name;
        this.category = category;
        reviews = new ArrayList<>();
    }
    void addReview(Review r) {
        reviews.add(r);
    }
    double avgRating() {
        if (reviews.size() == 0) return 0;
        int sum = 0;
        for (Review r : reviews)
            sum += r.rating;
        return (double) sum / reviews.size();
    }
    int reviewCount() {
        return reviews.size();
    }
    double smartScore() {
        double rating = avgRating();
        int count = reviewCount();
        return rating * 0.7 + Math.log(count + 1) * 0.3 * (5 / Math.log(10));
    }
    void display() {
        System.out.println("\nProduct: " + name);
        System.out.println("Category: " + category);
        System.out.println("Average Rating: " + String.format("%.2f", avgRating()));
        System.out.println("Reviews: " + reviews.size());
        System.out.println("----------------------");
    }
    void showReviews() {
        if (reviews.size() == 0) {
            System.out.println("No reviews yet.");
            return;
        }
        for (Review r : reviews) {
            System.out.println("Reviewer: " + r.reviewer);
            System.out.println("Rating: " + r.rating);
            System.out.println("Comment: " + r.comment);
            System.out.println("----------------------");
        }
    }
}
public class ReviewRanker {
    static ArrayList<Product> products = new ArrayList<>();
    static void addProduct(Scanner sc) {
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        products.add(new Product(name, category));
        System.out.println("Product Added!");
    }
    static void addReview(Scanner sc) {
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.print("Reviewer Name: ");
                String reviewer = sc.nextLine();
                System.out.print("Rating (1-5): ");
                int rating = sc.nextInt();
                sc.nextLine();
                System.out.print("Comment: ");
                String comment = sc.nextLine();
                p.addReview(new Review(reviewer, rating, comment));
                System.out.println("Review Added!");
                return;
            }
        }
        System.out.println("Product not found.");
    }
    static void searchProduct(Scanner sc) {
        System.out.print("Search Product: ");
        String key = sc.nextLine().toLowerCase();
        for (Product p : products) {
            if (p.name.toLowerCase().contains(key)) {
                p.display();
            }
        }
    }
    static void filterCategory(Scanner sc) {
        System.out.print("Enter Category: ");
        String cat = sc.nextLine();
        for (Product p : products) {
            if (p.category.equalsIgnoreCase(cat)) {
                p.display();
            }
        }
    }
    static void rankProducts() {
        products.sort((a, b) -> Double.compare(b.smartScore(), a.smartScore()));
        int rank = 1;
        for (Product p : products) {
            System.out.println("\nRank #" + rank++);
            p.display();
        }
    }
    static void viewProducts() {
        if (products.size() == 0) {
            System.out.println("No products added yet.");
            return;
        }
        System.out.println("\n----- Added Products -----");
        for (Product p : products) {
            p.display();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== ReviewRanker System =====");
            System.out.println("1 Add Product");
            System.out.println("2 Add Review");
            System.out.println("3 Search Product");
            System.out.println("4 Filter Category");
            System.out.println("5 Show Rankings");
            System.out.println("6 View Added Products");
            System.out.println("7 Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    addReview(sc);
                    break;
                case 3:
                    searchProduct(sc);
                    break;
                case 4:
                    filterCategory(sc);
                    break;
                case 5:
                    rankProducts();
                    break;
                case 6:
                    viewProducts();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}