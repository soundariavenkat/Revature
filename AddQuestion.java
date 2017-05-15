package mvapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import packsample.Connectiondb;
	public class AddQuestion
	{
	        public static void Addques() throws Exception
	        {
		Connection con= Connectiondb.getconnmovie();
		String sql="INSERT INTO QUESTIONS(Q_TEXT,Q_TYPE,Q_SCORE) VALUES(?,?,?)";
		System.out.println(sql);
		PreparedStatement pst= con.prepareStatement(sql);
		
		System.out.println("ENTER THE QUESTION:?");
		Scanner n = new Scanner(System.in);
		String a=n.nextLine();
		pst.setString(1, a);
		
		System.out.println("ENTER THE QUESTION TYPE:(1 or 2 Or 3)?");
		int b=n.nextInt();
		pst.setInt(2, b); 
		n.nextLine();
		pst.setInt(3,1);
		
		/*pst.setString(1, "WHAT IS C");
		pst.setInt(2, 1);
		pst.setInt(3,1); */
		
		int row=pst.executeUpdate();
		System.out.println("no.of rows inserted="+row);
		pst.close();
		con.close();
		
		
	        }		
	        public static void assesment() throws Exception
	        {
		Connection con= Connectiondb.getconnmovie();
		System.out.println("Enter the type of the question:\n1. FILLUPS \n2. MATCH \n 3.ONE WORD");
		Scanner n = new Scanner(System.in);
		int a=n.nextInt();
		String sql="SELECT * FROM QUESTIONS WHERE Q_TYPE="+a;
		PreparedStatement pst= con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			String q1=rs.getString("Q_TEXT");
			int i=rs.getInt("ID");
			System.out.println("QUESTION: \t"+q1);
			//String sq2="SELECT QO.ANS_TEXT FROM QUESTION_TYPE QT,QUESTIONS Q,QA_OPTIONS QO WHERE QT.ID=Q.Q_TYPE AND Q.ID=QO.QUESTION_TEXT AND Q.ID="+i;
			String sq2="select ANS_TEXT from QA_OPTIONS where QUESTION_TEXT="+i;
         PreparedStatement pst1= con.prepareStatement(sq2);
         ResultSet rs1=pst1.executeQuery();
        while(rs1.next())
        {
	           String ch=rs1.getString("ANS_TEXT");
	           System.out.println(ch+"\n");
	          
        }
		
        System.out.println("Enter Answer");
        Scanner ans=new Scanner(System.in);
        String str1=ans.next();
        String sq3="SELECT QO.ID,QO.QUESTION_TEXT FROM QA_OPTIONS QO, QUESTIONS Q,QCORRECT_ANS QA WHERE QO.ANS_TEXT='"+str1+"' AND QO.QUESTION_TEXT=Q.ID AND Q.ID=QA.QUES_ID AND QO.ID=QA.QOPTA_ID";
        PreparedStatement pst2= con.prepareStatement(sq3);
		ResultSet rs2=pst2.executeQuery();
		if(rs2.next()==true)
			System.out.println("CORRECT ANSWER");
		else
			System.out.println("WRONG ANSER");
			
		}
		
		
		pst.close();
	//	pst1.close();
		//pst2.close();
		con.close();
		
				}		
		}



	
