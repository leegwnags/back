package hotel;

import java.util.List;

public interface DAO {

	int insert();

	boolean isEmpty(String rno);

	boolean isDup(String name);

	int addGuest(Guest guest);

	int checkIn(String rno);

	List<Room> roomList();

	int checkOut(String rno);

	int removeGuest(String rno);

	Room roomDetail(String rno);

	List<Guest> guestInfo();

	Guest guestOfRoom(String rno);

}
