package com.zee.zee5app.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public class SeriesIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		WebSeries series = (WebSeries) object;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id =0;
		String query = "SELECT id from seriesidgenerator";
		String updateIdStatement = "update seriesidgenerator set id=?";
		String newId = null;
		int updateResult = 0;
		String seriesName = series.getWebSeriesName();
		connection = session.connection();
		try {
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt(1);
				
				id = ++id;
				String id_extract = Integer.toString(id);
				while(id_extract.length()!=8) {
					id_extract = "0"+id_extract;
				}
				newId = seriesName.charAt(0)+""+seriesName.charAt(1)+""+id_extract;
				
				System.out.println(newId);
				preparedStatement = connection.prepareStatement(updateIdStatement);
				preparedStatement.setInt(1, id);
				updateResult = preparedStatement.executeUpdate();
				if(updateResult==0) {
					throw new UnableToGenerateIdException("unable to generate id");
				}
				return newId;
			}
			
			
		} catch(UnableToGenerateIdException e) {
			//throw new UnableToGenerateIdException("Hi");
			System.out.println(e);
		}
		catch (SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//throw new UnableToGenerateIdException("unable to generate id"+e.getMessage());
		}
		return null;
	}

}
