package com.sprint.ofd;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.exceptions.ItemNotFoundException;
import com.sprint.ofd.exceptions.RestaurantNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.ofd.service.IItemService;

@SpringBootTest
class ItemServiceTest {

	@Autowired
	IItemService itemServ;
	
	@Test
	void  viewItemTest() {
		Item itm = itemServ.viewItem(21);
		assertEquals("kl", itm.getItemName());
	}
	
	@Test
	void viewAllItemsTest() throws ItemNotFoundException{
		List<Item> itemList = itemServ.viewAllItems();
		int totalItem= itemList.size();
		assertEquals(0, totalItem);
	  //  Restaurant rest = resList.get(1);
		//assertEquals("rajluxmi", rest.getRestaurantName());
		//assertNotEquals(87878787, rest.getRestaurantId());
}
	
	
	
}

