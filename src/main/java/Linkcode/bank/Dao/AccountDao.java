package Linkcode.bank.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import Linkcode.bank.Model.Account;
import Linkcode.bank.Model.LoginModel;

public class AccountDao {
	Scanner sc=new Scanner(System.in);
		Connection con=myconnection.myconnection();

		PreparedStatement pstat=null;
		int i=0;
	
	public int savedata(List<Account> lst) {
		int i=0;
		Account acc=null;
			Iterator<Account> itr=lst.iterator();
			try {
				while(itr.hasNext())
				{
					acc=itr.next();
					PreparedStatement pstat=con.prepareStatement("insert into linkcodebank values(?,?,?,?,?)");
					pstat.setInt(1, acc.getAccno());
					pstat.setString(2, acc.getCname());
					pstat.setString(3, acc.getUname());
					pstat.setString(4, acc.getPass());
					pstat.setInt(5, acc.getBal());
					i=pstat.executeUpdate();
				}
				if(i>0)
					{
						System.out.println("Record Saved..");
					}
					else 
					{
						System.out.println("Record not saved..");
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return 0;
		
	}
	
	public Boolean validateData(LoginModel lmobj) {
		System.out.println("Enter username and password");
	    Boolean b=false;
	    List<Account> lst=getAllData();
		for(Account acc:lst)
		{
			if(acc.getUname()==lmobj.getUname())
			{
				if(acc.getPass()==lmobj.getPass())
				{
					b=true;
					break;
				}
			}
		}
		return b;
	}
	
	public List<Account> getAllData() {
		List<Account> lst=new LinkedList<Account>();
		try {
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=s.executeQuery("select * from linkcodebank");
			while (rs.next()) 
			{
				Account acc=new Account();
				acc.setAccno(rs.getInt(1));
				acc.setCname(rs.getString(2));
				acc.setUname(rs.getString(3));
				acc.setPass(rs.getString(4));
				acc.setBal(rs.getInt(5));
				lst.add(acc);
				System.out.println("add");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	public ResultSet UpdateData(Account acc)
	{
		ResultSet rs=null;
		try {
			pstat=con.prepareStatement("update linkcodebank set bal=? where accno=?");
			pstat.setInt(2,acc.getAccno());
			pstat.setInt(1,acc.getBal());
			rs=pstat.executeQuery();
			if(rs.next())
			{
				System.out.println("Product Updated..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public Account SearchData(int accno)
	{
		ResultSet rs=null;
		Account acc=null;
		System.out.println("Enter Account no to search record");
		try {
			pstat=con.prepareStatement("select * from linkcodebank where accno=?");
			pstat.setInt(1,accno);
			rs=pstat.executeQuery();
			if(rs.next())
			{
				acc=new Account();
				acc.setAccno(rs.getInt(1));
				acc.setUname(rs.getString(3));
				acc.setBal(rs.getInt(5));
				System.out.println("Record found...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
	public int deleteData(Account acc)
	{
		try {
			pstat=con.prepareStatement("Delete from linkcodebank where accno=? and pass=?");
			System.out.println("Enter accno and password to delete :");
			pstat.setInt(1, acc.getAccno());
			pstat.setString(2,acc.getPass());
			i=pstat.executeUpdate();
			if(i>0)
			{
				System.out.println("Record Deleted..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
