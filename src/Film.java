import javafx.beans.property.SimpleStringProperty;

public class Film {

	private final SimpleStringProperty title;
    private final SimpleStringProperty location;

	public Film(String title, String location){
		this.title = new SimpleStringProperty(title);
		this.location = new SimpleStringProperty(location);
	}

	public String getTitle() {
        return title.get();
    }
    public void setTitle(String fName) {
        title.set(fName);
    }

    public String getLocation() {
        return location.get();
    }
    public void setLocation(String fName) {
        location.set(fName);
    }
}
