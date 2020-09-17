package lab1;

import java.util.*;
import java.util.Scanner;
import java.util.stream.*;

/*
 * Вариант 7.6 Создать списочный массив, который содержал бы данные о спортсменах
 *  с атрибутами: место, занятое в соревнованиях, ФИО и год рождения. 
 *   Получить поток элементов списочного массива, определить  максимальное  
 *  (метод  max() ) и минимальное(метод min()) значение года рождения,
 *   отсортировать (методом sorted()) спортсменов в потоке  в порядке убывания 
 *   года рождения.  
 *   Произвести вывод на экран  данных о спортсменах с занятым 
 *   местом,  большим, значения, введенного  с клавиатуры.
 * */
public class Demo {

	public static void main(String[] args) {
		ArrayList<Sportsman> sList = new ArrayList<>();

		sList.add(new Sportsman(1, "Chen Long", 1989));
		sList.add(new Sportsman(6, "P. V. Sindhu", 1995));
		sList.add(new Sportsman(5, "Nozomi Okuhara", 1995));
		sList.add(new Sportsman(3, "Lee Chong Wei", 1982));
		sList.add(new Sportsman(4, "Carolina Marín", 1993));
		sList.add(new Sportsman(2, "Viktor Axelsen", 1994));

		System.out.println("Исходный список cпортсменов: ");
		sList.forEach(
				(s) -> System.out.println(s.getFullname() + " (" + s.getYear() + ") " + s.getPrizePlace() + " место"));
		System.out.println();

		// Получить поток списочного массива, определить максимальное (метод * max() ) и
		// минимальное(метод min()) значение года рождения
		Stream<Sportsman> myStream = sList.stream();

		Optional<Sportsman> min = myStream.min(Comparator.comparing(Sportsman::getYear));
		if (min.isPresent())
			System.out.println("Минимальный год рождения: " + min.get().getYear());

		myStream = sList.stream();
		Optional<Sportsman> max = myStream.max(Comparator.comparing(Sportsman::getYear));
		if (max.isPresent())
			System.out.println("Максимальный год рождения: " + max.get().getYear());

		System.out.println();

		// Отсортировать (методом sorted()) спортсменов в потоке в порядке убывания года
		Stream<Sportsman> sortedStream = sList.stream().sorted(Comparator.comparing(Sportsman::getYear).reversed());

		System.out.print("Отсортированный поток данных: ");
		sortedStream.forEach((s) -> System.out.print(s.getYear() + " "));
		System.out.println();

		// Произвести вывод на экран данных о спортсменах с занятым
		// местом, большим, значения, введенного с клавиатуры.
		System.out.println();
		Scanner in = new Scanner(System.in);
		System.out.print("Введите номер места: ");
		Integer p = in.nextInt();

		Stream<Sportsman> places = sList.stream().filter((n) -> n.getPrizePlace() > p);
		System.out.println("Данные о спортсменах с занятым местом, большим, введенного: ");
		places.forEach(
				(s) -> System.out.println(s.getPrizePlace() + " " + ": " + s.getFullname() + " (" + s.getYear() + ")"));

		in.close();
	}
}
