package lab4;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws SQLException {
	//Scanner in = new Scanner(System.in);
	//in.nextInt();
	/////TypeMaterial Test////
	System.out.println("TypeMaterial test");
	TypeMaterialDAOMySQL typeMaterialDAO = new TypeMaterialDAOMySQL();
	TypeMaterialService typeMaterialService = new TypeMaterialService(typeMaterialDAO);
	
	TypeMaterial typeMaterial_1 = new TypeMaterial();
	typeMaterial_1.setType_name("Пластиковое изделие");
	typeMaterial_1.setDescription("Для окон и водопровода, декора");
	
	TypeMaterial typeMaterial_2 = new TypeMaterial();
	typeMaterial_1.setType_name("Красящий");
	typeMaterial_1.setDescription("Для декора");
	
	typeMaterialService.createTypeMaterial(typeMaterial_1);
	typeMaterialService.createTypeMaterial(typeMaterial_2);

	List<TypeMaterial> typeMaterialsByTypeName = typeMaterialService.getTypeMaterialByTypeName("Cвязующий");

	System.out.println("Тип: " + typeMaterialService);
	typeMaterialsByTypeName = typeMaterialService.getTypeMaterialByTypeName("Cвязующий");
	typeMaterial_1 = typeMaterialsByTypeName.get(0);
	typeMaterial_1.setType_name("Cвязующий");
	typeMaterialService.updateTypeMaterial(typeMaterial_1);
	typeMaterialsByTypeName = typeMaterialService.getTypeMaterialByTypeName("Красящий");
	System.out.println("Тип: " + typeMaterialsByTypeName);

	/////Material Test////
	System.out.println();
	System.out.println("Material test");
	MaterialDAOMySQL materialDAO = new MaterialDAOMySQL();
	MaterialService materialService = new MaterialService(materialDAO);
	
	Material material_1 = new Material();
	material_1.setT_Id(typeMaterial_1.getT_id());
	material_1.setName("Краска");
	material_1.setProducer("Китай");
	
	materialService.createMaterial(material_1);
	
	
	TypeMaterial typeMaterial_3 = new TypeMaterial();
	typeMaterial_3.setType_name("Пластиковое изделие");
	typeMaterial_3.setDescription("Для окон и водопровода, декора");
	List<Material> materialsByTypeName = materialService.getMaterialByT_ID(typeMaterial_3.getT_id());

	System.out.println("Subjects and marks for student " +
	typeMaterial_1.getType_name() + ":" + materialsByTypeName);
	}
}
