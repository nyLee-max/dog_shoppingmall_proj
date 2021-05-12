package dog_shoppingmall_proj.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dog_shoppingmall_proj.dao.DogDAO;
import dog_shoppingmall_proj.dto.Dog;

public class DogDaoImpl implements DogDAO {
	private static final DogDaoImpl instance = new DogDaoImpl();
	private Connection con;

	public static DogDaoImpl getInstance() {
		return instance;
	}

	private DogDaoImpl() {
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public ArrayList<Dog> selectDogList() {
		String sql = "select id, kind, price, image, country, height, weight, content, readcount from dog";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				ArrayList<Dog> list = new ArrayList<>();
				do {
					list.add(getDog(rs));
				}while(rs.next());
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Dog getDog(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String kind = rs.getString("kind");
		int price = rs.getInt("price");
		String image = rs.getString("image");
		String country = rs.getString("country");
		int height = rs.getInt("height");
		int weight = rs.getInt("weight");
		String content = rs.getString("content");
		int readcount = rs.getInt("readcount");
		return new Dog(id, kind, price, image, country, height, weight, content, readcount);
	}

	@Override
	public Dog selectDog(int id) {
		String sql = "select id, kind, price, image, country, height, weight, content, readcount from dog where id = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, id);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getDog(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertDog(Dog dog) {
		String sql = "insert into dog values (?, ?, ?, ?, ?, ? , ? , ?, ?)";
			try(PreparedStatement pstmt = con.prepareStatement(sql);){
				pstmt.setInt(1, dog.getId());
				pstmt.setString(2, dog.getKind());
				pstmt.setInt(3, dog.getPrice());
				pstmt.setString(4, dog.getImage());
				pstmt.setString(5, dog.getCountry());
				pstmt.setInt(6, dog.getHeight());
				pstmt.setInt(7, dog.getWeight());
				pstmt.setString(8, dog.getContent());
				pstmt.setInt(9, dog.getReadcount());
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public int updateReadCount(int id) {
		String sql = "update dog set readcount = readcount + 1 where id = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
				pstmt.setInt(1, id);
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}

}
