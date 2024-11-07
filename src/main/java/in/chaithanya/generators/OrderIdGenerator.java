package in.chaithanya.generators;

import java.beans.Statement;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class OrderIdGenerator implements IdentifierGenerator {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		//String prefix="OD";
		//String suffix="";
		
		@Override
		 public void executeCustomJdbcQuery() {
			 String prefix="OD";
				String suffix="";
		 }
		          Session session = entityManager.unwrap(Session.class); // Get Hibernate Session from EntityManage
		        try (Connection connection = session.doReturningWork(Connection::unwrap)) { // Get the underlying JDBC connection
		            
		           Statement stmt = connection.createStatement(); // Create a statement and execute a custom query
		            String sql="select * order_id_seq.nexval from dual";
		            ResultSet rs= stmt.executeQuery(sql);
		            
		            if(rs.next()) {
					int seqval =rs.getInt(1);
						suffix=String.valueOf(seqval);
					 }
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		 
		      return prefix + suffix;
	}
}
