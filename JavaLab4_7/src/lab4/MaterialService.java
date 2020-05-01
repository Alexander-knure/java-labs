package lab4;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MaterialService {
	private MaterialDAOMySQL materialDAO;
	public MaterialService(MaterialDAOMySQL materialDAO) {
		this.materialDAO = materialDAO;
	}
	
	public void createMaterial(Material material) throws SQLException {
		Connection connection = DBConnection.getConnection();
		try {
			materialDAO.create(connection, material);
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}
	
	public void updateMaterial(Material material) throws SQLException {
		Connection connection = DBConnection.getConnection();
		try {
			materialDAO.update(connection, material);
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}
	
	public List<Material> getMaterialByT_ID(int t_id) throws SQLException {
		Connection connection = DBConnection.getConnection();
		try {
			List<Material> materials = materialDAO.getByMaterialT_ID(connection, t_id);
			connection.commit();
			return materials;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}
}
