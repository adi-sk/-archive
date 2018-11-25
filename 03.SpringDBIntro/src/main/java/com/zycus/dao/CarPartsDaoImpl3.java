package com.zycus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.zycus.entity.CarPart;

@Component("carPartsDao3")
public class CarPartsDaoImpl3 implements CarPartsDao {

	//dependency
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addNewPart(CarPart carPart) {
		//JdbcTemplate jdbcTemplate = new JdbcTemplate();
		//jdbcTemplate.setDataSource(dataSource);
		String sql = "insert into tbl_carparts values(?,?,?,?,?)";
		jdbcTemplate.update(sql, 
							carPart.getPartNo(),
							carPart.getPartName(),
							carPart.getCarModel(),
							carPart.getPrice(),
							carPart.getQuantity());
	}

	public List<CarPart> getAvailableParts() {
		String sql = "select * from tbl_carparts";
		return jdbcTemplate.query(sql, new CarPartRowMapper());		
	}

	private class CarPartRowMapper implements RowMapper<CarPart> {

		public CarPart mapRow(ResultSet rs, int index) throws SQLException {
			CarPart carPart = new CarPart();
			carPart.setPartNo(rs.getInt(1));
			carPart.setPartName(rs.getString(2));
			carPart.setCarModel(rs.getString(3));
			carPart.setPrice(rs.getDouble(4));
			carPart.setQuantity(rs.getInt(5));
			return carPart;
		}
	}
}




