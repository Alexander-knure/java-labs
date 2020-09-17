package lab5;

import java.util.Date;

/*5.6. Существует модель системы Рецепт. 
 * Модель позволяет в неизменяемом виде хранить 
 * назначения врача и срок действия рецепта. 
 * Написать код приложения, позволяющий продлевать 
 * срок действия уже существующего рецепта. 
 * 
 * Выберите подходящий паттерн для реализации 
 * этого задания.*/
public class Demo {

	public static void main(String[] args) {
		//Сделано класс Recipе, остальное - осознать
		Manager service = new Manager(new RecipeClass());
		Manager proxy = new Manager(new RecipeProxy());

		Date original = test(service);
		Date copy = test(proxy);
	}

	private static Date test(Manager manager) {
		manager.showRecipe("AA0001");
		
		return manager.prolong(7);
	}
}
