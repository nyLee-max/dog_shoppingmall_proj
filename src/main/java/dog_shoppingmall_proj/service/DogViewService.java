package dog_shoppingmall_proj.service;

import java.sql.Connection;
import java.sql.SQLException;

import dog_shoppingmall_proj.ds.JndiDs;
import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.impl.DogDaoImpl;

public class DogViewService {
	private DogDaoImpl dao = DogDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();

	public DogViewService() {
	
	}

	public Dog getDogView(int id) {
		Dog dog = null;
		try {
			con.setAutoCommit(false);
			dao.setCon(con);

			dao.updateReadCount(id);
			dog = dao.selectDog(id);

			JndiDs.commit(con);
		} catch (SQLException e) {
			JndiDs.rollback(con);
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dog;
	}
}
