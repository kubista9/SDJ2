import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest{

	private ListADT<Object> arrayList;

	@BeforeEach
	void setUp(){
		arrayList = (ListADT<Object>) new ArrayList<Object>();

	}

	@Test void addZero(){
		assertDoesNotThrow(()->arrayList.add(0, null));
	}

	@Test void addOne(){
		assertDoesNotThrow(()->arrayList.add(1, new Object()));
	}

	@Test void addMany(){
		arrayList.add(0, new Object());
		assertDoesNotThrow(()->arrayList.add(1, new Object()));
		arrayList.add(2, new Object());
		arrayList.add(3, new Object());
		assertDoesNotThrow(()->arrayList.add(4, new Object()));
	}

	@Test void addBoundaryLower(){
		assertThrows(IndexOutOfBoundsException.class, ()->arrayList.add(-1, new Object()));
		assertDoesNotThrow(()->arrayList.add(0, new Object()));
	}

	@Test void addBoundaryUpper(){

	}
}
