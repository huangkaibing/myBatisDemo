package com.longrise.dbtest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.longrise.dbtest.model.Personbo;

public interface PersonMapper
{
	public void singleInsert(@Param("table") String table, @Param("id") String id, @Param("userid") String userid, @Param("cardno") String cardno,
			@Param("user_createtime") String user_createtime, @Param("user_updatetime") String user_updatetime);

	public void batchInsert(@Param("list") List<Personbo> list);

}
