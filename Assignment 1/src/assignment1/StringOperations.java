package assignment1;

public class StringOperations {

    static void showDifference() {
        System.out.println("----- String vs StringBuffer vs StringBuilder -----");
        System.out.println("String        : Immutable, any change creates a new object, thread safe");
        System.out.println("StringBuffer  : Mutable, synchronized so thread safe, slower");
        System.out.println("StringBuilder : Mutable, not synchronized so not thread safe, faster");
        System.out.println();

        String s = "Hello";
        s.concat(" World");
        System.out.println("String after concat (not stored): " + s);

        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println("StringBuffer after append: " + sb);

        StringBuilder sbr = new StringBuilder("Hello");
        sbr.append(" World");
        System.out.println("StringBuilder after append: " + sbr);
        System.out.println();
    }

    public static void main(String[] args) {
        showDifference();

        String str = "  Java Programming  ";
        String name = "Java";
        String empty = "";
        String text = "apple,banana,mango";

        System.out.println("----- String Methods -----");
        System.out.println("length(): " + str.length());
        System.out.println("isEmpty(): " + empty.isEmpty());
        System.out.println("charAt(2): " + name.charAt(2));
        System.out.println("toString(): " + name.toString());
        System.out.println("equals(\"Java\"): " + name.equals("Java"));
        System.out.println("compareTo(\"Javb\"): " + name.compareTo("Javb"));
        System.out.println("contains(\"Prog\"): " + str.contains("Prog"));
        System.out.println("indexOf('a'): " + name.indexOf('a'));
        System.out.println("lastIndexOf('a'): " + name.lastIndexOf('a'));
        System.out.println("startsWith(\"Ja\"): " + name.startsWith("Ja"));
        System.out.println("endsWith(\"va\"): " + name.endsWith("va"));
        System.out.println("matches(\"[A-Za-z]+\"): " + name.matches("[A-Za-z]+"));
        System.out.println("substring(2, 8): " + str.trim().substring(2, 8));
        System.out.println("toLowerCase(): " + str.toLowerCase());
        System.out.println("trim(): [" + str.trim() + "]");
        System.out.println("replace('a', 'o'): " + name.replace('a', 'o'));

        String[] fruits = text.split(",");
        System.out.print("split(\",\"): ");
        for (String f : fruits) {
            System.out.print(f + " ");
        }
        System.out.println();

        System.out.println("join(\" - \"): " + String.join(" - ", fruits));

        int num = 2024;
        String numStr = String.valueOf(num);
        System.out.println("valueOf(2024) + 1: " + numStr + 1);
    }
}
