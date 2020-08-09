import javax.xml.crypto.Data;
import java.io.*;
import java.util.Formatter;

public class MainApp {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("product.txt");
             LineNumberReader lnr = new LineNumberReader(fr)) {
            String prodName;
            float quantity, price, cost, total = 0;
            try (Formatter fileFormatter = new Formatter(new FileWriter(new File("out.txt"))))
            {
                format(fileFormatter);
                System.out.format("%-15s %10s   %-10s %-10s\n", "Наименование", "Кол-во", "Цена", "Стоимость");
                System.out.print("=======================================================\n");
                do {
                    if ((prodName = lnr.readLine()) == null) {
                        System.out.print("=======================================================\n");
                        format(fileFormatter, total);
                        System.out.format("ИТОГО: %34s%7.2f", "=", total);
                    } else {
                        quantity = Float.parseFloat(lnr.readLine());
                        price = Float.parseFloat(lnr.readLine());
                        cost = quantity * price;
                        total += cost;
                        format(fileFormatter, prodName, quantity, price, cost);
                        System.out.format("%-15s %10s x %-10.2f =%-10.2f\n", prodName, quantity, price, cost);
                    }
                } while (prodName != null);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void format(Formatter formatter) {
        formatter.format("%-15s %10s   %-10s %-10s\n", "Наименование", "Кол-во", "Цена", "Стоимость");
        formatter.format("=======================================================\n");
    }

    private static void format(Formatter formatter, float total) {
        formatter.format("=======================================================\n");
        formatter.format("ИТОГО: %34s%7.2f", "=", total);
    }

    private static void format(Formatter formatter, String prodName, float quantity, float price, float cost) {
        formatter.format("%-15s %10s x %-10.2f =%-10.2f\n", prodName, quantity, price, cost);
    }
}
