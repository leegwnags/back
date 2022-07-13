package hotel;

import java.util.List;

public class HotelService implements Service {
	private DAO dao;
	
	
	public HotelService() {
		dao = new HotelDAO();
	}


	@Override
	public void initHotel() {
		int isOk = dao.insert();
		System.out.println("Hotel initialize " + (isOk > 0 ? "success" : "fail"));
	}


	@Override
	public boolean isEmpty(String rno) {
		return dao.isEmpty(rno);
	}


	@Override
	public boolean isDup(String name) {
		return dao.isDup(name);
	}


	@Override
	public int addGuest(Guest guest) {
		return dao.addGuest(guest);
	}


	@Override
	public int checkIn(String rno) {
		return dao.checkIn(rno);
	}


	@Override
	public List<Room> roomList() {
		return dao.roomList();
	}


	@Override
	public int checkOut(String rno) {
		return dao.checkOut(rno);
	}


	@Override
	public int removeGuest(String rno) {
		return dao.removeGuest(rno);
	}


	@Override
	public Room roomDetail(String rno) {
		return dao.roomDetail(rno);
	}


	@Override
	public List<Guest> guestInfo() {
		return dao.guestInfo();
	}


	@Override
	public Guest guestOfRoom(String rno) {
		return dao.guestOfRoom(rno);
	}
	
}
