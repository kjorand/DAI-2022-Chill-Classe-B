package ch.heigvd.dai.chill.domain.kjorand;

import ch.heigvd.dai.chill.domain.Bartender;
import ch.heigvd.dai.chill.protocol.OrderRequest;
import ch.heigvd.dai.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VintageSourBeerTest {
	@Test
	void thePriceAndNameForPunkIPAShouldBeCorrect() {
		VintageSourBeer beer = new VintageSourBeer();
		assertEquals(beer.getName(), VintageSourBeer.NAME);
		assertEquals(beer.getPrice(), VintageSourBeer.PRICE);
	}

	@Test
	void aBartenderShouldAcceptAnOrderForPunkIPA() {
		Bartender jane = new Bartender();
		String productName = "ch.heigvd.dai.chill.domain.kjorand.VintageSourBeer";
		OrderRequest request = new OrderRequest(3, productName);
		OrderResponse response = jane.order(request);
		BigDecimal expectedTotalPrice = VintageSourBeer.PRICE.multiply(new BigDecimal(3));
		assertEquals(expectedTotalPrice, response.getTotalPrice());
	}

}
