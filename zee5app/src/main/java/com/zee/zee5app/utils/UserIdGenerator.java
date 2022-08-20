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

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public class UserIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		User user = (User) object;
		//connection object
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id =0;
		String query = "SELECT id from useridgenerator";
		String updateIdStatement = "update useridgenerator set id=?";
		String newId = null;
		int updateResult = 0;
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
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
				newId = firstName.charAt(0)+""+lastName.charAt(0)+""+id_extract;
				//newId = firstName.charAt(0)+lastName.charAt(0)+""+id;
				System.out.println(newId);
				//then increment the number(id which is retrieved from db)
				//update
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
		//insert operation useridgenerator table
		//we need to perform the concatenation
		//we need to update the id
		//return the newly created id
	}
}
