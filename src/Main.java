import java.util.Scanner;

public class Main {
    private static final String[] ZERO_TO_TWENTY = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[] THOUSANDS = {"тысяча", "тысячи", "тысяч"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 0 до 1 000 000:");
        int number = scanner.nextInt();

        if (number < 0 || number > 1_000_000) {
            System.out.println("Число вне диапазона");
        } else if (number == 0) {
            System.out.println(ZERO_TO_TWENTY[0]);
        } else {
            System.out.println(numberToWords(number));
        }

    }

    private static String numberToWords(int number) {
        if (number < 20) {
            return ZERO_TO_TWENTY[number];
        } else if (number < 100) {
            return TENS[number / 10] + " " + ZERO_TO_TWENTY[number % 10];
        } else if (number < 1000) {
            return HUNDREDS[number / 100] + " " + numberToWords(number % 100);
        } else if (number < 10_000) {
            return numberToWords(number / 1000) + " " + THOUSANDS[getThousandEnding(number)] + " " + numberToWords(number % 1000);
        } else {
            return numberToWords(number / 1000) + " тысяч " + numberToWords(number % 1000);
        }
    }

    private static int getThousandEnding(int number) {
        int lastTwoDigits = number % 100;
        if (lastTwoDigits > 10 && lastTwoDigits < 20) {
            return 2;
        }
        int lastDigit = lastTwoDigits % 10;
        if (lastDigit == 1) {
            return 0;
        } else if (lastDigit > 1 && lastDigit < 5) {
            return 1;
        } else {
            return 2;
        }
    }
}