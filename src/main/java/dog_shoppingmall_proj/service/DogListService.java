package dog_shoppingmall_proj.service;

import java.sql.Connection;
import java.util.ArrayList;
import dog_shoppingmall_proj.ds.JndiDs;
import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.impl.DogDaoImpl;

public class DogListService {
	private DogDaoImpl dao = DogDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();

	public DogListService() {
		dao.setCon(con);
	}

	public ArrayList<Dog> getDogList() {
		return dao.selectDogList();
	}
}
