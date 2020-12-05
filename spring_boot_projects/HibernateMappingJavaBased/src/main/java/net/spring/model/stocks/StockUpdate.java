package net.spring.model.stocks;

// import java.text.ParseException;
import java.text.SimpleDateFormat;
// import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.hibernate.config.HibernateUtilDemo;
// import net.spring.model.Product;

public class StockUpdate {
 
	public static void main(String[] args) {
		 
		SessionFactory sessionFactory = HibernateUtilDemo.getSessionJavaConfigFactory_a();
		Session session = sessionFactory.openSession();		 
		session.beginTransaction();
		 
		// session.save(emp);
		 new StockUpdate().UpadateStockData(  session , sessionFactory );
		
		session.getTransaction().commit();		
		session.close();
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}
	
	 void UpadateStockData(Session session , SessionFactory sessionFactory) {
		try {
		Stock stock = new Stock();
        stock.setStockCode("7057");
        stock.setStockName("PADINI_7");
        session.save(stock);
      //  session.flush();
       // session.clear();
      //  session.close();
        
       //  session = sessionFactory.openSession();	
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(  new SimpleDateFormat("yyyy/MM/dd").parse("2017/08/04") );
        
        stockDailyRecords.setStock(stock);  
        
        stock.getStockDailyRecords().add(stockDailyRecords);
        
        session.save(stockDailyRecords);
       /* session.flush();
        session.clear();
        session.close();
        
        session = sessionFactory.openSession();
       */ 
        StockDailyRecord stockDailyRecords1 = new StockDailyRecord();
        stockDailyRecords1.setPriceOpen(new Float("1.2"));
        stockDailyRecords1.setPriceClose(new Float("1.1"));
        stockDailyRecords1.setPriceChange(new Float("10.0"));
        stockDailyRecords1.setVolume(3000000L);        
        stockDailyRecords1.setDate( new SimpleDateFormat("yyyy/MM/dd").parse("2017/08/03") );        
        stockDailyRecords1.setStock(stock);  
       
       stock.getStockDailyRecords().add(stockDailyRecords1);
        
        session.save(stockDailyRecords1); 
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
