package hu.ppke.itk.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(
			name="findAllTransactions",
			query = "FROM Transactions pt"
			),
	@NamedQuery(
			name = "findTransactionById",
			query = "FROM Transactions pt WHERE pt.id = :id"
			),
	@NamedQuery(
			name = "findTransactionByDate",
			query = "FROM Transactions pt WHERE pt.transferDate = :transferDate"
			),
	@NamedQuery(
			name = "findTransactionByType",
			query = "FROM Transactions pt WHERE pt.paymentType = :paymentType"
			)
})
@Table(name = "BB_TRANSACTIONS")
public class Transactions {
	
	@Id
	@Column(name="TRANSACTION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAYMENT_TYPE")
	private PaymentType paymentType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PARTNER_ID")
	private Partners partners;
	
	@Column(name = "TRANSFER_DATE")
	private long transferDate;
	
	@Column(name = "CREATE_DATE")
	private long create;
	
	@Column(name = "AMOUNT")
	private float amount;
	
	@Column(name = "DESCRIPTION")
	private String comment;
	
	@Column(name = "FEE_CALCULATION")
	private boolean feeCalculation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(long transferDate) {
		this.transferDate = transferDate;
	}

	public long getCreate() {
		return create;
	}

	public void setCreate(long create) {
		this.create = create;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isFeeCalculation() {
		return feeCalculation;
	}

	public void setFeeCalculation(boolean feeCalculation) {
		this.feeCalculation = feeCalculation;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Partners getPartners() {
		return partners;
	}

	public void setPartners(Partners partners) {
		this.partners = partners;
	}
}
