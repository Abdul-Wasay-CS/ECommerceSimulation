public final class Color {
    public static String Red() {
        System.out.print("\033[0;31m");
    }

    public static void Green() {
        System.out.print("\033[0;32m");
    }

    public static void Yellow() {
        System.out.print("\033[0;33m");
    }

    public static void Blue() {
        System.out.print("\033[0;34m");
    }

    public static void Purple() {
        System.out.print("\033[0;35m");
    }

    public static void Cyan() {
        System.out.print("\033[0;36m");
    }

    public static void White() {
        System.out.print("\033[0;37m");
    }

    public static void Reset() {
        System.out.print("\033[0m");
    }
}

