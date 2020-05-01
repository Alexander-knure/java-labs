package lab4;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;

public class MaterialDAOMySQL {
	private static final String SQL_UPDATE_MATERIAL = "UPDATE material SET "
		+ "name = ?, producer = ?, t_id = ?, WHERE m_id = ? ";
		private static final String SQL_INSERT_INTO_MATERIAL = "INSERT INTO "
		+ "material (name, producer, t_id) VALUES (?,?,?)";
		private static final String SQL_SELECT_BY_TYPE_ID = "SELECT * FROM "
		+ "material WHERE t_id = ?";
		
	public void create(Connection connection, Material material) throws SQLException {
		PreparedStatement prStatement = connection.prepareStatement(SQL_INSERT_INTO_MATERIAL, Statement.RETURN_GENERATED_KEYS);
		setInsertStatementParameters(material, prStatement);
		prStatement.executeUpdate();
		prStatement.close();
	}

	public void update(Connection connection, Material material) throws	SQLException {
		PreparedStatement prStatement = connection.prepareStatement(SQL_UPDATE_MATERIAL);
		setUpdateStatementParameters(material, prStatement);
		prStatement.executeUpdate();
		prStatement.close();
	}
	
	public List<Material> getByMaterialT_ID(Connection connection, int t_id) throws SQLException {
		PreparedStatement prStatement = connection.prepareStatement(SQL_SELECT_BY_TYPE_ID);
		prStatement.setInt(1, t_id);
		ResultSet rs = prStatement.executeQuery();
		
		List<Material> materials = getMaterials(rs);
		prStatement.close();
		return materials;
	}
		
	private List<Material> getMaterials(ResultSet rs) throws SQLException {
		List<Material> materials = new ArrayList<Material>();
		while (rs.next())
			materials.add(getMaterial(rs));
		return materials;
	}
		
	private Material getMaterial(ResultSet rs) throws SQLException {
		Material material = new Material();
		material.setM_Id(rs.getInt("m_id"));
		material.setName(rs.getString("type_name"));
		material.setProducer(rs.getString("producer"));
		material.setT_Id(rs.getInt("t_id"));
		return material;
	}
			
	private void setUpdateStatementParameters(Material material, PreparedStatement prStatement) throws SQLException {
		int k = 1;
		prStatement.setInt(k++, material.getM_Id());
		prStatement.setString(k++, material.getName());
		prStatement.setString(k++, material.getProducer());
		prStatement.setInt(k++, material.getT_Id());
	}
			
	private void setInsertStatementParameters(Material material, PreparedStatement prStatement) throws SQLException {
		int k = 1;
		prStatement.setString(k++, material.getName());
		prStatement.setString(k++, material.getProducer());
		prStatement.setInt(k++, material.getT_Id());
	}
}
