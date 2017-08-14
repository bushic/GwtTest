package gwtTest.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import gwtTest.client.GwtTestService;
import gwtTest.shared.ClientsEntity;
import org.hibernate.Session;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GwtTestServiceImpl extends RemoteServiceServlet implements GwtTestService {
    // Implementation of sample interface method
    public String getMessage() {

        /*String strDate = "2011-12-31";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(strDate);
            java.sql.Date sqlDate = new Date(date.getTime());

            Session session = HibernateSessionFactory.getSessionFactory().openSession();

            session.beginTransaction();

            ClientsEntity clientsEntity = new ClientsEntity();

            clientsEntity.setSurname("Бушуев");
            clientsEntity.setFirstname("Дмитрий");
            clientsEntity.setMiddlename("Александрович");
            clientsEntity.setBirthday(sqlDate);

            session.save(clientsEntity);
            session.getTransaction().commit();

            session.close();

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        return "Hi";
    }
}