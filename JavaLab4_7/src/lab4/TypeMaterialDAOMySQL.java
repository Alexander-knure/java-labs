package lab4;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.mysql.jdbc.Statement;

public class TypeMaterialDAOMySQL {
	private static final String SQL_UPDATE_TYPEMATERIAL = "UPDATE type SET type_name = ?, description = ? "
	+ "WHERE t_id = ? ";

	private static final String SQL_INSERT_INTO_TYPEMATERIAL = "INSERT INTO type (type_name, description) "
	+ "VALUES (?,?)";

	private static final String SQL_SELECT_BY_TYPENAME = "SELECT * FROM type WHERE type_name = ?";
	
	public void create(Connection connection, TypeMaterial typeMaterial) throws SQLException
	{
		PreparedStatement prStatement =	connection.prepareStatement(SQL_INSERT_INTO_TYPEMATERIAL,
		Statement.RETURN_GENERATED_KEYS);
		setInsertStatementParameters(typeMaterial, prStatement);
		prStatement.executeUpdate();
		prStatement.close();
	}

	public void update(Connection connection, TypeMaterial typeMaterial) throws SQLException
	{
		PreparedStatement prStatement = connection.prepareStatement(SQL_UPDATE_TYPEMATERIAL);

		setUpdateStatementParameters(typeMaterial, prStatement);
		prStatement.executeUpdate();
		prStatement.close();
	}
	public List<TypeMaterial> getByTypeName(Connection connection, String type_name) throws SQLException {
		PreparedStatement prStatement = connection.prepareStatement(SQL_SELECT_BY_TYPENAME);
		prStatement.setString(1, type_name);
		ResultSet rs = prStatement.executeQuery();
		List<TypeMaterial> typeMaterials = getTypeMaterials(rs);
		prStatement.close();
		return typeMaterials;
	}
	private List<TypeMaterial> getTypeMaterials(ResultSet rs) throws SQLException {
		List<TypeMaterial> typeMaterials = new ArrayList<TypeMaterial>();
		while (rs.next())
			typeMaterials.add(getTypeMaterial(rs));
		return typeMaterials;
	}
	private TypeMaterial getTypeMaterial(ResultSet rs) throws SQLException {
		TypeMaterial typeMaterial = new TypeMaterial();
		typeMaterial.setT_id(rs.getInt("t_id"));
		typeMaterial.setType_name(rs.getString("type_name"));
		typeMaterial.setDescription(rs.getString("description"));
		return typeMaterial;
	}
	private void setUpdateStatementParameters(TypeMaterial typeMaterial, PreparedStatement prStatement) throws SQLException {
		int k = 1;
		prStatement.setString(k++, typeMaterial.getType_name());
		prStatement.setString(k++, typeMaterial.getDescription());
		prStatement.setLong(k++, typeMaterial.getT_id());
	}
	private void setInsertStatementParameters(TypeMaterial typeMaterial, PreparedStatement prStatement) throws SQLException {
		int k = 1;
		prStatement.setString(k++, typeMaterial.getType_name());
		prStatement.setString(k++, typeMaterial.getDescription());
	}
}
