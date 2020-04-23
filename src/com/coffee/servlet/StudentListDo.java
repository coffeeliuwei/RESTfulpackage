package com.coffee.servlet;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.coffee.DB.DB;
import com.coffee.entity.Student;
import com.coffee.web.restful.RestfulDo;
import com.google.gson.JsonObject;



public class StudentListDo extends RestfulDo
{

	@Override
	public Object execute(JsonObject jreq) throws Exception
	{
		return DB.query("select * from student", 0);
	}
/**数据处理结束扔给前台的顺序
 * object：List<map>->RestfulDo.execute()->GenericDo.execute()
 * ->GenericService->HttpServlet
 * restfudo: "{error:0,reason:"ok",data:object}"
 * GenericDo: 对象->request,response,"{error:0,reason:"ok",data:object}"
 * GenericService:"{error:0,reason:"ok",data:object}"扔给前台
 * 
 */
/**接收前台数据的顺序（处理）
 * request->HttpServlet->GenericService->GenericDo.execute(string)->
 * RestfulDo.execute(JsonObject)
 * 
 * 
 * http://127.0.0.1:8080/RESTfulpackage/StudentList.do
 * 
 * 框架的加载次序：
 * tomcat->读取web.xml:GenericService加载进内存
 * GenericService处理所有url中.do的请求->读取LW-service.xml->将xml文件中的name，class加载进map
 * 如果有post或者get请求时去获取url中apiname：StudentList
 * 根据apiname到map中获取相应的全路径名->反射实例化
 * 
 */
}
