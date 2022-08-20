package com.zee.zee5app.utils;

import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
public class MovieIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		Movie movie = (Movie) object;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id =0;
		String query = "SELECT id from movieidgenerator";
		String updateIdStatement = "update movieidgenerator set id=?";
		String newId = null;
		int updateResult = 0;
		String movieName = movie.getMovieName();
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
				newId = movieName.charAt(0)+""+movieName.charAt(1)+""+id_extract;
				
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
