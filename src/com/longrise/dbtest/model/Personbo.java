package com.longrise.dbtest.model;

public class Personbo
{
	private String id;
	private String userid;
	private String cardno;
	private String user_createtime;
	private String user_updatetime;
	private String table;

	public String getCardno()
	{
		return cardno;
	}

	public void setCardno(String cardno)
	{
		this.cardno = cardno;
	}

	public String getUser_createtime()
	{
		return user_createtime;
	}

	public void setUser_createtime(String user_createtime)
	{
		this.user_createtime = user_createtime;
	}

	public String getUser_updatetime()
	{
		return user_updatetime;
	}

	public void setUser_updatetime(String user_updatetime)
	{
		this.user_updatetime = user_updatetime;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getUserid()
	{
		return userid;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}

	public void setTable(String table)
	{
		this.table = table;
	}

	public String getTable()
	{
		return table;
	}

}
