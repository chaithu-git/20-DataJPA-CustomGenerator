package in.chaithanya.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetailsEntity {
	
	@Id
	@Column(name="Order_Id")
	@GenericGenerator(name = "order_id_seq", strategy="in.chaithanya.generators.OrderIdGenerator")
	@GeneratedValue(generator="order_id_gen")
	private Integer orderId;
	
	@Column(name="Order_By")
	private String orderBy;
	
	@Column(name="Order_Place_Date")
	@Temporal(TemporalType.DATE)// mm/dd/yy
	private Date orderPlaceDate;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Date getOrderPlaceDate() {
		return orderPlaceDate;
	}

	public void setOrderPlaceDate(Date orderPlaceDate) {
		this.orderPlaceDate = orderPlaceDate;
	}

		

	
}
