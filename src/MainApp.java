import java.io.*;
import java.util.Formatter;

public class MainApp {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("product.txt");
             LineNumberReader lnr = new LineNumberReader(fr)) {
            String prodName;
            float quantity, price, cost, total = 0;
            System.out.format("%-15s %10s   %-10s %-10s\n", "Наименование", "Кол-во", "Цена", "Стоимость");
            line();
            /*while ((prodName = lnr.readLine()) != null) {
                quantity = Float.parseFloat(lnr.readLine());
                price = Float.parseFloat(lnr.readLine());
                cost = quantity * price;
                total += cost;
                System.out.format("%-15s %10s x %-10.2f =%-10.2f\n", prodName, quantity, price, cost);
            }*/
            try (FileWriter fw = new FileWriter(new File("out.txt"))){
                do {
                    if ((prodName = lnr.readLine()) == null) {
                        line();
                        System.out.format("ИТОГО: %34s%7.2f", "=", total);
                    } else {
                        quantity = Float.parseFloat(lnr.readLine());
                        price = Float.parseFloat(lnr.readLine());
                        cost = quantity * price;
                        total += cost;
                        System.out.format("%-15s %10s x %-10.2f =%-10.2f\n", prodName, quantity, price, cost);
                    }
                } while (prodName != null);
            } catch (Exception ex) {

            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void line() {
        for (int i = 0; i < 49; i++) {
            System.out.print("=");
            if (i == 48) {
                System.out.println("");
            }
        }
    }
}
