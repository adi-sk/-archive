package com.zycus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zycus.entity.CarPart;

@Component("carPartsDao1")
public class CarPartsDaoImpl1 implements CarPartsDao {

	//dependency
	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into tbl_carparts values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carPart.getPartNo());
			pstmt.setString(2, carPart.getPartName());
			pstmt.setString(3, carPart.getCarModel());
			pstmt.setDouble(4, carPart.getPrice());
			pstmt.setInt(5, carPart.getQuantity());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace(); //should throw instead
		}
		finally {
			try { pstmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}

	public List<CarPart> getAvailableParts() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from tbl_carparts";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<CarPart> list = new ArrayList<CarPart>();
			while(rs.next()) {
				CarPart carPart = new CarPart();
				carPart.setPartNo(rs.getInt(1));
				carPart.setPartName(rs.getString(2));
				carPart.setCarModel(rs.getString(3));
				carPart.setPrice(rs.getDouble(4));
				carPart.setQuantity(rs.getInt(5));
				list.add(carPart);
			}
			return list;
			
		}
		catch(SQLException e) {
			e.printStackTrace(); //should throw instead
			return null;
		}
		finally {
			try { rs.close(); } catch(Exception e) { }
			try { pstmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}

}




