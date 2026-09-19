package online.shop;

/**
 * Entry point forwarding to Main JFrame.
 */
public class OnlineShop {

    public static void main(String[] args) {
        try {
            Class<?> mainClass = Class.forName("Main");
            java.lang.reflect.Method mainMethod = mainClass.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
