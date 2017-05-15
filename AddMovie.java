package mvapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import packsample.Connectiondb;
public class AddMovie
{
        public static void AddMovie1() throws ClassNotFoundException, SQLException
        {
	Connection con= Connectiondb.getconnmovie();
	String sql="INSERT INTO MOVIE(MOVIE_NAME,LANGUAGE,DIRECTOR,MOVIE_TYPE,CASTING,DURATION,CREATE_DATE) VALUES(?,?,?,?,?,?,?)";
	System.out.println(sql);
	PreparedStatement pst= con.prepareStatement(sql);
	pst.setString(1, "CHENNAI28");
	pst.setString(2, "TAMIL");
	pst.setString(3,"MANI");
	pst.setString(4,"COMEDY");
	pst.setString(5,"SIVA");
	pst.setInt(6, 3);
	LocalDate ldt=LocalDate.parse("2017-05-10");
	pst.setObject(7, ldt);
	int row=pst.executeUpdate();
	System.out.println("no.of rows inserted="+row);
	pst.close();
	con.close();
			}			
	}


