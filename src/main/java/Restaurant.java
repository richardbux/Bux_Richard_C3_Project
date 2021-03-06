import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
	public LocalTime openingTime;
    public LocalTime closingTime;
    public LocalTime currentTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
    	
    	if(closingTime==null || openingTime==null)
    		return false;
    	if(currentTime==null)
    		setCurrentTime(LocalTime.now());
    	if(getCurrentTime().isBefore(closingTime) && getCurrentTime().isAfter(openingTime))
    		return true;
    	
    	return false;
    }

    public LocalTime getCurrentTime(){ return  currentTime; }
    
    public void setCurrentTime(LocalTime currentTime)
    {
    	this.currentTime=currentTime;
    }

    public List<Item> getMenu() {
       return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
    
    public String getLocation() {
		return location;
	}
    
	public LocalTime getOpeningTime() {
		return openingTime;
	}

	public LocalTime getClosingTime() {
		return closingTime;
	}

}
