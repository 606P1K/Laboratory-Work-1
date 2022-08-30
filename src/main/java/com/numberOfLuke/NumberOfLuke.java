package main.java.com.numberOfLuke;

import java.util.Scanner;

/**
 * Клас,що визначає певне число Люка,та квадратну суму N-членів цієї послідовності
 * @author Volodymyr Stepainuk
 * @version 1.0
 */
public class NumberOfLuke {
    /** Поле розміру масиву чисел Люка*/
    private int size;
    /** Масив для чисел Люка*/
    private long[] numbers;
    /** Сума N чисел люка*/
    private long sumOfN = 0;
    /** Число Люка під заданим номером*/
    private long number;
    /** N перші числа Люка*/
    private int N;

    /**
     * Конструктор cтворення нового об'єкту
     * @see NumberOfLuke#NumberOfLuke(int)
     */
    public NumberOfLuke(){
        setSize();
    }

    /**
     * Конструктор cтворення нового об'єкту з певним заданим значенням
     * @param size розмір масиву чисел Люка,а також заданий номер числа Люка,котре буде потрібно повернути
     * @exception IllegalArgumentException Введення некоретних даних
     * @see NumberOfLuke#NumberOfLuke()
     */
    public NumberOfLuke(int size) {
        if(size <= 0) throw new IllegalArgumentException("You entered an incorrect number!");
        this.size = size;
    }

    /**
     * Функція для знаходження числа Люка під заданим номером(size)
     * @return Повертає число Люка під заданим номером
     */
    public long LukeNumbers(){
        numbers = new long[this.size];
        if(this.size == 1) {
            numbers[0] = 2;
            return (number = numbers[0]);
        }
        numbers[0] = 2;
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return (number = numbers[numbers.length-1]);
    }

    /**
     * Функція для знаходження суми квадратів N перших чисел Люка
     * @param N перші числа Люка(N)
     * @exception IllegalArgumentException Введення некоретного номеру
     * @return Повертає суму квадратів N перших чисел Люка
     */
    public long findSum(int N){
        this.N = N;
        if(this.N>this.size||this.N<=0) throw new IllegalArgumentException("You entered an incorrect number!");
        for (int i = 0; i < this.N; i++) {
            sumOfN += Math.pow(numbers[i],2);
        }
        return sumOfN;
    }

    /**
     * Перевантажений метод toString
     * @return Перетворення інформації до типу String
     */
    @Override
    public String toString() {
        return "NumberOfLuke{" +
                "Digit number = " + size +
                ",Number = " + number +
                ",N = " + N +
                ", Sum of N numbers = " + sumOfN +
                '}';
    }

    /**
     * Метод для встановлення розміру масиву чисел Люка(Вкажіть номер числа,яке хочете получити).
     * Метод нічого не повертає
     * @exception IllegalArgumentException Введення некоретного номеру
     */
    public void setSize(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Luke's number you want to receive: ");
        int size = scanner.nextInt();
        if(size <= 0) throw new IllegalArgumentException("You entered an incorrect number!");
        this.size = size;
    }
}
