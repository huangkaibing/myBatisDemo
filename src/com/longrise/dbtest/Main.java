package com.longrise.dbtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.longrise.dbtest.mapper.PersonMapper;
import com.longrise.dbtest.model.Personbo;

/**
 * 
 * @author www.huangkaibing.com
 * 
 */
public class Main
{
	static SqlSessionFactory sessionFactory = null;

	public static void main(String[] args) throws IOException
	{
		// 批量插入
		String[] sub =
		{ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
				, "a", "b", "c", "d", "e"
				, "f", "g", "h", "i", "j"
				, "k", "l", "m", "n", "o"
				, "p", "q", "r", "s", "t"
				, "u", "v", "w", "x", "y"
				, "z" };

		for (int n = 0; n < 5; n++)
		{
			SqlSession sqlSession = getSqlSession();
			PersonMapper userMapper = sqlSession.getMapper(PersonMapper.class);
			List<Personbo> list = new ArrayList<Personbo>();
			for (int i = 0; i < sub.length; i++)
			{
				Personbo tmp = new Personbo();
				tmp.setTable("bb_" + sub[i]);
				tmp.setId(UUID.randomUUID().toString().replaceAll("\\-", ""));
				tmp.setUserid("huangkb" + i);
				tmp.setCardno("huangkb");
				tmp.setUser_createtime("2017-12-19 18:04:57");
				tmp.setUser_updatetime("2017-12-19 18:05:17");
				list.add(tmp);
			}

			if (list.size() > 0)
			{
				userMapper.batchInsert(list);
				System.out.println("insert success!");
			}
			sqlSession.commit();
			sqlSession.close();
		}
	}

	private static SqlSession getSqlSession() throws IOException
	{
		if (sessionFactory == null)
		{
			// System.out.println(directory.getCanonicalPath());// 获取标准的路径
			// System.out.println(directory.getAbsolutePath());// 获取绝对路径

			// 配置文件转移
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File("db.properties");
			File directory = new File("src/db.properties");
			String targetfile = directory.getAbsolutePath();
			if (oldfile.exists())
			{
				InputStream inStream = new FileInputStream("db.properties");
				FileOutputStream fs = new FileOutputStream(targetfile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1)
				{
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}

			// mybatis的配置文件初始化
			InputStream is = Main.class.getClassLoader().getResourceAsStream("conf.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
			is.close();
			// SqlSessionFactoryBuilder 一旦创建了 SqlSessionFactory，就不再需要它了
			// SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在
		}

		// 每个线程都应该有它自己的 SqlSession 实例
		return sessionFactory.openSession();
	}
}
