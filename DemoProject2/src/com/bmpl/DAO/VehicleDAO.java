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

	public ArrayList<VehicleDTO> showData() {
		System.out.println("inside show data");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ArrayList<VehicleDTO> list = new ArrayList<VehicleDTO>();
		
		try {
			con = CommonDAO.getConnection();
			System.out.println("connection established");
			
			ps = con.prepareStatement(SQLConstants.SHOW_DATA_QUERY);
			System.out.println("statement prepared");
			
			rs = ps.executeQuery();
			System.out.println("execute query");
			while(rs.next()) {
				VehicleDTO vdto = new VehicleDTO();
				
				vdto.setName(rs.getString("vname"));
				vdto.setStaffNo(rs.getString("staff_no"));
				vdto.setType(rs.getString("vehicle_type"));
				vdto.setVehicleNo(rs.getString("vehicle_no"));
				vdto.setStickerNo(rs.getString("supporting_doc"));
				vdto.setSupportingDoc(rs.getString("contact_no"));
				vdto.setSignature(rs.getString("signature"));
				
//				System.out.println(vdto.toString());
				list.add(vdto);
				
//				System.out.println("s.no"+rs.getInt("sno")
//				+"name  :"+ rs.getString("vname")+
//				"staff_no :"+ rs.getString("staff_no")+
//				"Vehicle Type: "+rs.getString("vehicle_type")+
//				"vehicle_no :"+rs.getString("vehicle_no")+
//				"Supporting dco :"+rs.getString("supporting_doc")+
//				"contact No :"+rs.getString("contact_no")+
//				"Signature :"+rs.getString("signature"));
				
			}
			
			System.out.println("display compleate");
			
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
		
		return list;
	}
	
	
	
	
	
//	public void insertIntoDB(String name,int staffNo,String vehicleType,int vehicleNo,String supportingDoc,int contactNo,String signature) {
	public boolean isUploadIntoDB(ArrayList<VehicleDTO> vehicledtoList) {
		
	
		Connection con = null;
		PreparedStatement ps = null;
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
			ps.setString(5,vdto.getStaffNo());
			ps.setString(6,vdto.getSupportingDoc());
			ps.setString(7,vdto.getContactNo());
			ps.setString(8,vdto.getSignature());
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
	
	public boolean addIntoDB(VehicleDTO vehicledto) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		boolean isUpload = false;
		System.out.println(vehicledto.toString());
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(SQLConstants.INSERT_QUERY);
			ps.setString(1,vehicledto.getName());
			ps.setString(2,vehicledto.getStaffNo());
			ps.setString(3,vehicledto.getType());
			ps.setString(4,vehicledto.getVehicleNo());
			ps.setString(8,vehicledto.getStickerNo());
			ps.setString(5,vehicledto.getSupportingDoc());
			ps.setString(6,vehicledto.getContactNo());
			ps.setString(7,vehicledto.getSignature());
			ps.executeUpdate();
			isUpload = true;
			
			
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
