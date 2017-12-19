package hu.ppke.itk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(
			name="findAll",
			query = "FROM Partners pt"
			),
	@NamedQuery(
			name = "findById",
			query = "FROM Partners pt WHERE pt.id = :id"
			)
})
@Table(name = "BB_PARTNERS")
public class Partners {

	@Id
	@Column(name="PARTNER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}