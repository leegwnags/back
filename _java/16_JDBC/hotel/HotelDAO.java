package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import address.DatabaseConnector;

public class HotelDAO implements DAO {
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	
	public HotelDAO() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}


	@Override
	public int insert() {
		query = "truncate room";
		try {
			pst = conn.prepareStatement(query);
			pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		query = "insert into room(rno, is_empty) values (?,?);";
		try {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 10; j++) {
					pst = conn.prepareStatement(query);
					pst.setString(1, Integer.toString(i+1) + (j < 9 ? "0" : "") + Integer.toString(j+1));
					pst.setInt(2, 1);
					pst.executeUpdate();
				}
			}
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public boolean isEmpty(String rno) {
		query = "select * from room where rno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, rno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt("is_empty") > 0 ? true : false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean isDup(String name) {
		try {
			query = "select exists(select * from guest where name = ?);";
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getBoolean(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public int addGuest(Guest guest) {
		query = "insert into guest(name, tel, age, gen, rno) values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, guest.getName());
			pst.setString(2, guest.getTel());
			pst.setInt(3, guest.getAge());
			pst.setInt(4, guest.getGen());
			pst.setString(5, guest.getRno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int checkIn(String rno) {
		query = "update room set is_empty = 0, check_in_time = now(), check_out_time = null where rno = " + rno + ";";
		try {
			pst = conn.prepareStatement(query);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public List<Room> roomList() {
		query = "select * from room";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			List<Room> list = new ArrayList<Room>();
			while (rs.next()) {
				list.add(new Room(rs.getString("rno"), rs.getInt("is_empty") > 0 ? true : false, rs.getString("check_in_time"), rs.getString("check_out_time")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int checkOut(String rno) {
		query = "update room set is_empty = 1, check_in_time = null, check_out_time = now() where rno = " + rno + ";";
		try {
			pst = conn.prepareStatement(query);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int removeGuest(String rno) {
		query = "delete from guest where rno = " + rno + ";";
		try {
			pst = conn.prepareStatement(query);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public Room roomDetail(String rno) {
		query = "select * from room where rno = " + rno + ";";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new Room(rno, rs.getInt("is_empty") > 0 ? true : false, rs.getString("check_in_time"), rs.getString("check_out_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<Guest> guestInfo() {
		query = "select * from guest";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			List<Guest> guests = new ArrayList<Guest>();
			while (rs.next()) {
				guests.add(new Guest(rs.getString("name"), rs.getString("tel"), rs.getInt("age"), rs.getInt("gen"), rs.getString("rno")));
			}
			return guests;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public Guest guestOfRoom(String rno) {
		query = "select * from guest where rno = " + rno + ";";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new Guest(rs.getString("name"), rs.getString("tel"), rs.getInt("age"), rs.getInt("gen"), rno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
