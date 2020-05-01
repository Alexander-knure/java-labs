package lab4;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TypeMaterialService {
	private TypeMaterialDAOMySQL typeMaterialDAO;
	public TypeMaterialService(TypeMaterialDAOMySQL typeMaterialDAO) 
	{
		this.typeMaterialDAO = typeMaterialDAO;
	}
	public void createTypeMaterial(TypeMaterial typeMaterial) throws SQLException {
		Connection connection = DBConnection.getConnection();
		try {
			typeMaterialDAO.create(connection, typeMaterial);
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}
	public void updateTypeMaterial(TypeMaterial typeMaterial) throws SQLException {
		Connection connection = DBConnection.getConnection();
		try {
			typeMaterialDAO.update(connection, typeMaterial);
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}
	public List<TypeMaterial> getTypeMaterialByTypeName(String type_name) throws SQLException {
		Connection connection = DBConnection.getConnection();
		try {
			List<TypeMaterial> types = typeMaterialDAO.getByTypeName(connection, type_name);
			connection.commit();
			return types;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}
}