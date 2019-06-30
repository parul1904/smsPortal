package com.smsPortal.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class JqueryDatatablePluginDemo extends HttpServlet {

	private String GLOBAL_SEARCH_TERM;
	private String COLUMN_NAME;
	private String DIRECTION;
	private int INITIAL;
	private int RECORD_SIZE;
	private String CONTACTID_SEARCH_TERM,FIRST_NAME_SEARCH_TERM,LAST_NAME_SEARCH_TERM,TITLE_SEARCH_TERM,CITY_SEARCH_TERM,CONTACT_SEARCH_TERM;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] columnNames = { "contact_id", "first_name", "last_name", "title", "city","contact_no1" };

		JSONObject jsonResult = new JSONObject();
		int listDisplayAmount = 10;
		int start = 0;
		int column = 0;
		String dir = "asc";
		String pageNo = request.getParameter("iDisplayStart");
		String pageSize = request.getParameter("iDisplayLength");
		String colIndex = request.getParameter("iSortCol_0");
		String sortDirection = request.getParameter("sSortDir_0");
		
		if (pageNo != null) {
			start = Integer.parseInt(pageNo);
			if (start < 0) {
				start = 0;
			}
		}
		if (pageSize != null) {
			listDisplayAmount = Integer.parseInt(pageSize);
			if (listDisplayAmount < 10 || listDisplayAmount > 50) {
				listDisplayAmount = 10;
			}
		}
		if (colIndex != null) {
			column = Integer.parseInt(colIndex);
			if (column < 0 || column > 5)
				column = 0;
		}
		if (sortDirection != null) {
			if (!sortDirection.equals("asc"))
				dir = "desc";
		}

		String colName = columnNames[column];
		int totalRecords= -1;
		try {
			totalRecords = getTotalRecordCount();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		RECORD_SIZE = listDisplayAmount;
		GLOBAL_SEARCH_TERM = request.getParameter("sSearch");
		CONTACTID_SEARCH_TERM=request.getParameter("sSearch_0");
		FIRST_NAME_SEARCH_TERM=request.getParameter("sSearch_1");
		LAST_NAME_SEARCH_TERM=request.getParameter("sSearch_2");
		TITLE_SEARCH_TERM=request.getParameter("sSearch_3");
		CITY_SEARCH_TERM=request.getParameter("sSearch_4");
		CONTACT_SEARCH_TERM=request.getParameter("sSearch_5");
		COLUMN_NAME = colName;
		DIRECTION = dir;
		INITIAL = start;

		try {
			jsonResult = getContactDetails(totalRecords, request);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		PrintWriter out = response.getWriter();
		out.print(jsonResult);

	}

	public JSONObject getContactDetails(int totalRecords, HttpServletRequest request)
			throws SQLException, ClassNotFoundException {

		int totalAfterSearch = totalRecords;
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		String searchSQL = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String dbConnectionURL = "jdbc:mysql://localhost:3306/dineshpa_smsportal?user=root&password=root";
		Connection con = DriverManager.getConnection(dbConnectionURL);
		String sql = "SELECT " + "contact_id, first_name, last_name, title, city, contact_no1  "
				+ " FROM " + "tbl_contacts " + "WHERE ";

		String globeSearch = "contact_id like '%" + GLOBAL_SEARCH_TERM + "%'"
				+ "or first_name like '%" + GLOBAL_SEARCH_TERM + "%'"
				+ "or last_name like '%" + GLOBAL_SEARCH_TERM + "%'"
				+ "or title like '%" + GLOBAL_SEARCH_TERM + "%'"
				+ "or city like  '%" + GLOBAL_SEARCH_TERM + "%'"
				+ "or contact_no1 like '%" + GLOBAL_SEARCH_TERM + "%'";
		
		String idSearch="contact_id like " + CONTACTID_SEARCH_TERM + "";
		String nameSearch="first_name like '%" + FIRST_NAME_SEARCH_TERM + "%'";
		String placeSearch=" last_name like '%" + LAST_NAME_SEARCH_TERM + "%'";
		String citySearch=" title like '%" + TITLE_SEARCH_TERM + "%'";
		String stateSearch=" city like '%" + CITY_SEARCH_TERM + "%'";	
		String phoneSearch=" contact_no1 like '%" + CONTACT_SEARCH_TERM + "%'";
        System.out.println(phoneSearch);
		if (GLOBAL_SEARCH_TERM != "") {
			searchSQL = globeSearch;
		}
		
		else if(CONTACTID_SEARCH_TERM !="")
		{
			searchSQL=idSearch;
		}
		else if(FIRST_NAME_SEARCH_TERM !="")
		{
			searchSQL=nameSearch;
		}
		else if(LAST_NAME_SEARCH_TERM!="")
		{
			searchSQL=placeSearch;
		}
		else if(TITLE_SEARCH_TERM!="")
		{
			searchSQL=citySearch;
		}
		else if(CITY_SEARCH_TERM!="")
		{
			searchSQL=stateSearch;
		}
		else if(CONTACT_SEARCH_TERM!=null)
		{
			searchSQL=phoneSearch;
			System.out.println(searchSQL);
		}
        
		sql += searchSQL;
		sql += " order by " + COLUMN_NAME + " " + DIRECTION;
		sql += " limit " + INITIAL + ", " + RECORD_SIZE;
        System.out.println(sql);
        //for searching
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			JSONArray ja = new JSONArray();
			ja.put(rs.getString("contact_id"));
			ja.put(rs.getString("first_name"));
			ja.put(rs.getString("last_name"));
			ja.put(rs.getString("title"));
			ja.put(rs.getString("city"));
			ja.put(rs.getString("contact_no1"));
			array.put(ja);	
		}
		stmt.close();
		rs.close();

		String query = "SELECT " + "COUNT(*) as count " + "FROM " + "tbl_contacts " + "WHERE ";

		//for pagination
		
		if (GLOBAL_SEARCH_TERM != ""||CONTACTID_SEARCH_TERM != "" || FIRST_NAME_SEARCH_TERM != "" ||LAST_NAME_SEARCH_TERM != ""||TITLE_SEARCH_TERM != ""|| CITY_SEARCH_TERM != "" || CONTACT_SEARCH_TERM != "" ) {
			query += searchSQL;

			
			PreparedStatement st = con.prepareStatement(query);
			ResultSet results = st.executeQuery();

			if (results.next()) {
				totalAfterSearch = results.getInt("count");
			}
			st.close();
			results.close();
			con.close();
		}
		try {
			result.put("iTotalRecords", totalRecords);
			result.put("iTotalDisplayRecords", totalAfterSearch);
			result.put("aaData", array);
		} catch (Exception e) {

		}

		return result;
	}

	public int getTotalRecordCount() throws SQLException {

		int totalRecords = -1;
		String sql = "SELECT " + "COUNT(*) as count " + "FROM " + "tbl_contacts";
        String dbConnectionURL = "jdbc:mysql://localhost:3306/dineshpa_smsportal?user=root&password=root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = DriverManager.getConnection(dbConnectionURL);

		PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			totalRecords = resultSet.getInt("count");
		}
		resultSet.close();
		statement.close();
		con.close();

		return totalRecords;
	}
}