package com.sprint.ofd;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.repository.IRestaurantRepository;
import com.sprint.ofd.service.RestaurantServiceImpl;

@ExtendWith(SpringExtension.class)
class RestaurantServiceMockitoTest {

	@InjectMocks
	RestaurantServiceImpl resServ;
	
	@MockBean
	IRestaurantRepository resRepo;
    
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
/*	
	@Test
	void viewRestaurantTest()
	{
		Restaurant res=new Restaurant();
		res.setRestaurantId(40);
		res.setRestaurantName("rajluxmi");
		res.setContactNumber(50000);
		Mockito.when(resRepo.findById(40)).thenReturn(Optional.of(res));
		Restaurant response=resServ.viewRestaurant(40);
		
		assertEquals(40,response.getRestaurantId());
		assertEquals("vaibhav",response.getRestaurantName());
		assertEquals(50000,response.getContactNumber());	
	}
*/

    @Test
    void viewAllRestaurantsTest()
    {
    	Restaurant rest1=new Restaurant();
    	Restaurant rest2=new Restaurant();
    	
    	rest1.setRestaurantId(1);
    	rest2.setRestaurantId(2);
    	
    	rest1.setRestaurantName("abhay");
    	rest2.setRestaurantName("varsha");
    	
    	rest1.setContactNumber(54321);
    	rest2.setContactNumber(98765);
    	
    	List<Restaurant> restList=new ArrayList<>();
    	restList.add(rest1);
    	restList.add(rest2);
    	
    	Mockito.when(resRepo.findAll()).thenReturn(restList);
    	
    	List<Restaurant> restList1=resServ.viewAllRestaurants();
    	assertEquals(2,restList1.size());       	
    }
    
    @Test
    void addRestaurantTest()
    {
    	Restaurant rest=new Restaurant();
    	rest.setRestaurantId(1);
    	rest.setRestaurantName("dhoni");
    	rest.setContactNumber(98987676);
    	
    	Mockito.when(resRepo.save(rest)).thenReturn(rest);
    	Restaurant newRest=resServ.addRestaurant(rest);
    	assertEquals(1,newRest.getRestaurantId());
    	assertEquals("dhoni",newRest.getRestaurantName());
    	assertEquals(98987676,newRest.getContactNumber());
    }
    
    
    @Test
    void removeRestaurantTest()
    {
        Restaurant rest=new Restaurant();
        rest.setRestaurantId(10);
		rest.setRestaurantName("vaibhav");
		Mockito.when(resRepo.findById(10)).thenReturn(Optional.of(rest));
	   // Mockito.when(resRepo.deleteById(10)).thenReturn(null);
		Restaurant response=resServ.removeRestaurant(10);
		assertEquals("vaibhav",response.getRestaurantName());
		
		
		
        
    }
    
}
