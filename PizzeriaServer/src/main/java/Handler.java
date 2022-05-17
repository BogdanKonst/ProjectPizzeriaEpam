import java.util.Objects;

public class Handler {
	private static int counter;
	private int id = 0;
	
	
	public Handler() {
		id = ++counter;
	}

	public void setCount(int secondCount) {
		counter = secondCount;
	}
	public int getCount() {
		return counter;
	}
	public void setId(int anotherId) {
		this.id = anotherId;
	}
	public int getId() {
		return id;
	}

	public void cloneParameters(Handler second) {
		id = second.getId();
	}
	@Override
	public String toString() {
		return "Handler #" + id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Handler other = (Handler) obj;
		return id == other.id;
	}

}
