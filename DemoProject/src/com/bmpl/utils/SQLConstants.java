package com.bmpl.utils;

public interface SQLConstants {

	String SHOW_DATA_QUERY = "Select * from vehicle_mst;";
	String INSERT_QUERY = "insert into vehicles_mst(vname,staff_no,vehicle_type,"
			+ "vehicle_no,supporting_doc,contact_no,signature) values(?,?,?,?,?,?,?);";
}
