package app;

import interfaces.loginFormViewController;

public class coffeShopApp {

    private static loginFormViewController lf;

    public static void main(String[] args) {
        lf = new loginFormViewController();

        lf.run();
    }

}
