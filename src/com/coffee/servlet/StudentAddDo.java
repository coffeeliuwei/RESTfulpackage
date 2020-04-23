package com.coffee.servlet;

import javax.servlet.annotation.WebServlet;

import com.coffee.DB.DB;
import com.coffee.entity.Student;
import com.coffee.web.restful.RestfulDo;
import com.google.gson.JsonObject;

public class StudentAddDo extends RestfulDo
{

	@Override
	public Object execute(JsonObject jreq) throws Exception
	{
		// 取得请求参数
		int id = jreq.get("id").getAsInt();
		String name = jreq.get("name").getAsString();
		boolean sex = jreq.get("sex").getAsBoolean();
		String phone = jreq.get("phone").getAsString();

		// 参数检查
		if (id <= 0)
			throw new Exception("ID必须为正值!");
		if (name.length() == 0)
			throw new Exception("姓名不得为空!");

		// 保存数据
		
		Student stu = new Student(id, name, sex, phone);
		DB.insert(stu);

		// 注意：返回 null是正常情形，不表示错误！
		// 返回null 仅仅表示客户端浏览器不需要返回什么特别的数据 。
		// 只有 throw了Exception ，才表示在处理过程中发生了错误。
		return null;
	}

}
