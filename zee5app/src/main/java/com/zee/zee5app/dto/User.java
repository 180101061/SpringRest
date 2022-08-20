package com.zee.zee5app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name = "user_table")
public class User {
	
	//@Setter(value = AccessLevel.NONE)
	@Id
	@GenericGenerator(name="userIdGenerator",strategy = "com.zee.zee5app.utils.UserIdGenerator")
	@GeneratedValue(generator = "userIdGenerator")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	@NotNull
	private String userName;
	@NotNull
	private String password;
	@NotNull
	@Size(max = 50)
	private String firstName;
	@NotNull
	@Size(max = 50)
	private String lastName;
	@Email
	@Size(max = 100)
	private String email;
	@Column(columnDefinition = "DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate doj;
	@Column(columnDefinition = "TIMESTAMP")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy-HH-mm-ss")
	private LocalDateTime dob;
	private boolean active;
	@Override
	public int hashCode() {
		return Objects.hash(active, dob, doj, email, firstName, lastName, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return active == other.active && Objects.equals(dob, other.dob) && Objects.equals(doj, other.doj)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(userId, other.userId);
	}

	
	
}
