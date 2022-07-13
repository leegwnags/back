package hotel;

import java.util.List;
import java.util.Scanner;

import product.Service;

public class HotelFront {
	private hotel.Service svc;
	private Scanner sc;
	private boolean flag;
	private int menu;
	
	public HotelFront() {
		svc = new HotelService();
		sc = new Scanner(System.in);
		flag = true;
		printMenu();
		
	}

	private void printMenu() {
		while (flag) {
			System.out.println("================================ Hotel Service ================================");
			System.out.println("1.Check In 2.Check Out 3.Room List 4.Room Detail 5.Guest Info Etc.EXIT");
			System.out.println("-------------------------------------------------------------------------------");
			menu = sc.nextInt();
			switch (menu) {
			case 99:
				svc.initHotel();
				break;
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomList();
				break;
			case 4:
				roomDetail();
				break;
			case 5:
				guestInfo();
				break;

			default:
				flag = false;
				break;
			}
		}
		System.out.println("Program Stopped");
	}

	private void guestInfo() {
		List<Guest> guests = svc.guestInfo();
		System.out.println("====================== Guest Info ======================");
		System.out.println("Name\t\tTel\t\tAge\tGender\tRoom No.");
		System.out.println("--------------------------------------------------------");
		for (Guest guest : guests) {
			System.out.print(guest.getName()+(guest.getName().length() > 7 ? "\t" : "\t\t"));
			System.out.print(guest.getTel()+(guest.getTel().length() > 7 ? "\t" : "\t\t"));
			System.out.print(guest.getAge()+"\t");
			System.out.print(guest.getGen() > 0 ? "Male" + "\t": "Female" + "\t");
			System.out.println(guest.getRno());
		}
	}

	private void roomDetail() {
		System.out.println("Input Room No. > ");
		String rno = sc.next();
		Room room = svc.roomDetail(rno);
		Guest guest = svc.guestOfRoom(rno);
		System.out.println("Room No. " + room.getRno());
		System.out.println("Room status : " + (room.isEmpty() ? "Empty" : "Occupied"));
		System.out.println("Checkin Time : " + (room.getCheckInTime() == null ? "N/A" : room.getCheckInTime()));
		System.out.println("Checkout Time : " + (room.getCheckOutTime() == null ? "N/A" : room.getCheckOutTime()));
		if (guest != null) {
			System.out.println("== Guest Infomation ==");
			System.out.println("Name : " + guest.getName());
			System.out.println("Tel : " + guest.getTel());
			System.out.println("Age : " + guest.getAge());
			System.out.println("Gender : " + (guest.getGen() > 0 ? "Male" : "Female"));
		}
	}

	private void roomList() {
		List<Room> rooms = svc.roomList();
		System.out.println("============================== Room List ==============================");
		System.out.println("Room No.\tRoom Status\tCheckin time\t\tCheckout time");
		for (Room room : rooms) {
			System.out.println(room.getRno()+"\t\t"+(room.isEmpty() ? "Empty" : "Occupied")+"\t"+(room.getCheckInTime() == null ? "\t\t\t\t" : room.getCheckInTime())+(room.getCheckOutTime() == null ? "" : room.getCheckOutTime()));
		}
	}

	private void checkOut() {
		System.out.println("Input Room No. > ");
		String rno = sc.next();
		if (!svc.isEmpty(rno)) {
			int isOk = svc.checkOut(rno);
			int isOk2 = svc.removeGuest(rno);
			System.out.println("Check out " + (isOk2 > 0? "success" : "fail"));
			System.out.println("Guest infomation remove " + (isOk > 0? "success" : "fail"));
		} else {
			System.out.println("Room no." + rno + " is empty.");
		}
	}

	private void checkIn() {
		System.out.println("Input Room No. > ");
		String rno = sc.next();
		if (svc.isEmpty(rno)) {
			System.out.println("==== Input Guest Info ====");
			System.out.println("Name > ");
			String name = sc.next();
			System.out.println("TEL > ");
			String tel = sc.next();
			System.out.println("Age > ");
			int age = sc.nextInt();
			System.out.println("Gender(M/F) > ");
			int gen = sc.next().equals("M") ? 1 : 0;
			boolean isDup = svc.isDup(name);
			if (!isDup) {
				int isOk = svc.addGuest(new Guest(name, tel, age, gen, rno));
				int isOk2 = svc.checkIn(rno);
				System.out.println("Guest infomation generate " + (isOk > 0? "success" : "fail"));
				System.out.println("Check in " + (isOk2 > 0? "success" : "fail"));
				
			} else {
				System.out.println("Guest name is duplicated. Use another name.");
			}
			
		} else {
			System.out.println("Room no." + rno +" is occupied. Find another room.");
		}
	}
	
	
}
