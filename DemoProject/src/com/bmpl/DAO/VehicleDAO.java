package com.bmpl.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.DTO.VehicleDTO;
import com.bmpl.utils.CommonDAO;
import com.bmpl.utils.SQLConstants;

public class VehicleDAO {

	public void showAllTableData() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("Select * from vehicle_mst;");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("name"+ rs.getString("vname")+"pass"+ rs.getInt("staff_no"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	
	
	
//	public void insertIntoDB(String name,int staffNo,String vehicleType,int vehicleNo,String supportingDoc,int contactNo,String signature) {
	public boolean isUploadIntoDB(ArrayList<VehicleDTO> vehicledtoList) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		boolean isUpload = false;
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(SQLConstants.INSERT_QUERY);
			for(VehicleDTO vdto : vehicledtoList) {
			ps.setString(1,vdto.getName());
			ps.setString(2,vdto.getStaffNo());
			ps.setString(3,vdto.getType());
			ps.setString(4,vdto.getVehicleNo());
			ps.setString(5,vdto.getSupportingDoc());
			ps.setString(6,vdto.getContactNo());
			ps.setString(7,vdto.getSignature());
			ps.addBatch();
			}
			int[] result =  ps.executeBatch();
			boolean fail = false;
			
			for(int res : result) {
				if(res<1)
				{
					fail = true;
					break;
				}
			}
			if(fail) {
				con.rollback();
			}
			else {
				con.commit();
				return true;
			}
			
//			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return isUpload;
	}
	
}
