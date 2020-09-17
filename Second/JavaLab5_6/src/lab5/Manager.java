package lab5;

import java.util.Date;

public class Manager {
	private RecipeInterface ri;

	public Manager(RecipeInterface ri) {
		this.ri = ri;
	}

	public void showRecipe(String series) {
		Recipe recipe = ri.getRecipe(series);
		System.out.println(
		"------------------------------" +
		"   " + recipe.getDoctor() + "\n" +
		"   " + recipe.getPatient() + "\n" +
		"   " + recipe.getInstitution() + "\n" +
		"   " + recipe.getRegistrationDate() + "\n" +
		"   " + recipe.getPurpose() + "\n" +
		"   " + recipe.getExpirationDate() + "\n" +
		"------------------------------\n");
	}

	public Date prolong(int days) {
		Date date = new Date();
		//TODO add days
		date.setDate(days);
		return date;
	}
}
