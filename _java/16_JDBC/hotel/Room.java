package hotel;

public class Room {
	
	@Override
	public String toString() {
		return "Room [rno=" + rno + ", isEmpty=" + isEmpty + ", checkInTime=" + checkInTime + ", checkOutTime="
				+ checkOutTime + "]";
	}

	private String rno;
	private boolean isEmpty;
	private String checkInTime;
	private String checkOutTime;
	
	public Room(String rno, boolean isEmpty, String checkInTime, String checkOutTime) {
		this.rno = rno;
		this.isEmpty = isEmpty;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	
	
	
	
}
