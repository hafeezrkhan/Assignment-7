//*****THIS CODE WILL ASK TO PUT IN ZIP CODE IN MSG BOX TO GET THE CITY NAME*****
import java.awt.Component;
import javax.swing.JOptionPane;
import org.geonames.PostalCodeSearchCriteria;
import org.geonames.InvalidParameterException;
import org.geonames.PostalCode;
import org.geonames.WeatherObservation;
import org.geonames.WebService;

public class GeoNamesHafeezKhan {

	public static void main(String[] args) 
		{
			
			// *****Code if you want to Request user name to put in*****
		    // *****If you want the user to connect with GeoNames web service by putting*****
		    //*****user name then use this code*****
			//String user = JOptionPane.showInputDialog("Enter username");
			
			// *****User name Input*****	
			//WebService.setUserName(user); 
			
			//*****Code to connect to GeoName web services*****  
			WebService.setUserName("hafeezkhan"); 
			
			PostalCodeSearchCriteria searchCriteria = new PostalCodeSearchCriteria();
			
			//***** Code to generate input box to put in postal code as a searchCriteria *****
			String postalCode = JOptionPane.showInputDialog("Enter your zip code");
			searchCriteria.setPostalCode(postalCode); 
			
			try {
				// *****Code to limit the country to only USA as a searchCrtieria*****
				String countryCode = "US";
				searchCriteria.setCountryCode(countryCode);
			} catch (InvalidParameterException e1) {
					e1.printStackTrace();
			}
			
			try {
				// *****Code to use latitude and longitude of Zip code to find city*****
				PostalCode searchResult = WebService.findNearbyPostalCodes(searchCriteria).get(0);
				double latitude = searchResult.getLatitude(); 
				double longitude = searchResult.getLongitude();
				
				// *****Use longitude and latitude coordinates to search for most recent weather observation*****
				WeatherObservation weather = new WeatherObservation(); 
				weather = WebService.findNearByWeather(latitude, longitude);
				
				// *****Print out City Information according to Zip code in console*****
				System.out.println("****** City Information ******");
				System.out.println("City Name: "+(weather.getStationName()));
				
				// *****To Print result in a message box*****
				Component frame = null;
				JOptionPane.showMessageDialog(frame, ("City Name: "+(weather.getStationName())));

			} catch (Exception e) {
				
//end of try
				}	
//end of main class
			}
//end of class
	}

