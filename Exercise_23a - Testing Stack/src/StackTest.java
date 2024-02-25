import collection.StringStack1;
import collection.StringStack5;
import collection.StringStackADT;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StackTest
{
  private StringStackADT stack5;
  private StringStackADT stack1;

  @BeforeEach void setUp()
  {
    stack5 = new StringStack1(5);
    stack1 = new StringStack1(1);
  }

  /*
  Z: push a null string in a 5 element stack throws an exception
O: one push in a 1 element stack can be done
O: one push in a 5 element stack can be done
M: 3 push in a 5 element stack can be done
B: 5 element stack, number of push {5, 6}. The right boundary throws an exception the left don't.
E: (already tested in Z and B)

   */
  @Test void pushZero() {
    assertThrows(IllegalArgumentException.class, ()->stack5.push(null));
  }

  @Test void pushOne1()
  {
    assertDoesNotThrow(()->stack1.push("One"));
  }

  @Test void pushOne5()
  {
    assertDoesNotThrow(()->stack5.push("One"));
  }

  @Test void pushMany()
  {
    stack5.push("One");
    stack5.push("Two");
    assertDoesNotThrow(()->stack5.push("Three"));
  }

  @Test void pushBoundary()
  {
    stack5.push("One");
    stack5.push("Two");
    stack5.push("Three");
    stack5.push("Four");
    assertDoesNotThrow(()->stack5.push("Five"));
    assertThrows(IllegalStateException.class, ()->stack5.push("Six"));
  }

  @Test void pushException()
  {
    // (already tested in Z and B)
  }

  /*
Z: one pop when size=0, throws an exception
O: one pop when size=1 (one push in a 1 element stack)
O: one pop when size=1 (one push in a 5 element stack)
M: 3 pops when size=4 (4 pushed) return the last 3, in reverse order
B: After 4 push, number of pop {4, 5} (the last throws an exception)
E: (already tested in Z and B)

   */

  @Test void popZero() {
    assertThrows(IllegalStateException.class, ()->stack5.pop());
  }

  @Test void popOne1()
  {
    stack1.push("One");
    assertEquals("One", stack1.pop());
  }

  @Test void popOne5()
  {
    stack5.push("One");
    assertEquals("One", stack5.pop());
  }

  @Test void popMany()
  {
    stack5.push("One");
    stack5.push("Two");
    stack5.push("Three");
    stack5.push("Four");
    assertEquals("Four", stack5.pop());
    assertEquals("Three", stack5.pop());
    assertEquals("Two", stack5.pop());
  }

  @Test void popBoundary()
  {
    stack5.push("One");
    stack5.push("Two");
    stack5.push("Three");
    stack5.push("Four");
    stack5.pop();
    stack5.pop();
    stack5.pop();
    assertEquals("One", stack5.pop());
    assertThrows(IllegalStateException.class, ()-> stack5.pop());
  }

  @Test void popException()
  {
    // (already tested in Z and B)
  }

  /*
	Z: 0 elements, should throw an exception
	O: 1 element, one element can be created
	M: 5 elements can be created
	B: {0, 1} (already tested in Z and O)
	E: -6 elements throws an exception
	*/

	@Test void ConstructorZero(){
		assertThrows(IllegalArgumentException.class, ()-> new StringStack1(0));
	}

	@Test void ConstructorOne1(){
		assertDoesNotThrow(()-> new StringStack1(1));
	}

	@Test void ConstructorMany(){
		assertDoesNotThrow(()-> new StringStack1(4));
	}

	@Test void ConstructorBoundary(){
		assertThrows(IllegalArgumentException.class, ()-> new StringStack1(-6));
	}

	/*
	 * Z: 5 element stack with no push has size 0
	 * O: one push in a 5 element stack has size 1
	 * O: one push and one pop in a 5 element stack has size 0
	 * M: {push, push, pop, push} in a 5 element stack has size 2
	 * B: 5 push in a 5 element stack has size 5
	 * E: (no exceptions thrown)
	 */

	@Test void SizeZero(){
		assertDoesNotThrow(()->stack5.size() == 0);
	}

	@Test void SizeOne(){
		stack5.push("One");
		assertDoesNotThrow(()->stack5.size() == 1);
	}

	@Test void SizPushPop5(){
		stack5.push("One");
		stack5.pop();
		assertDoesNotThrow(()-> stack5.size() == 0);
	}

	@Test void SizeMany5(){
		stack5.push("One");
		stack5.push("Two");
		stack5.pop();
		stack5.push("Three");
		assertDoesNotThrow(()-> stack5.size() == 2);
	}

	@Test void PushMany(){
		stack5.push("One");
		stack5.push("Two");
		stack5.push("Three");
		stack5.push("Four");
		stack5.push("Five");
		assertDoesNotThrow(()-> stack5.size() == 5);
	}

/*  Z: Size=0 (no push) gives isEmpty=true
*	O: one push gives isEmpty=false
* 	M: {push, push, pop, push, pop} gives isEmpty=false
*	B: 5 push in a 5 element stack, isEmpty=false
* 	B: 5 push an 5 pop, gives isEmpty=true
* 	E: (no exceptions thrown)
 */

	@Test void EmptyZero(){
		assertEquals(true, stack5.isEmpty());
	}

	@Test void PushOne(){
		stack5.push("One");
		assertEquals(false, stack5.isEmpty());
	}

	@Test void PushPopMany(){
		stack5.push("One");
		stack5.push("Two");
		stack5.pop();
		stack5.push("Three");
		stack5.pop();
		assertEquals(false, stack5.isEmpty());
	}

	@Test void PushMany5(){
		stack5.push("One");
		stack5.push("Two");
		stack5.push("Three");
		stack5.push("Four");
		stack5.push("Five");
		assertEquals(false, stack5.isEmpty());
	}

	@Test void PushPopMany5(){
		stack5.push("One");
		stack5.push("Two");
		stack5.push("Three");
		stack5.push("Four");
		stack5.push("Five");
		stack5.pop();
		stack5.pop();
		stack5.pop();
		stack5.pop();
		stack5.pop();
		assertEquals(false, stack5.isEmpty());
	}

/*
* Z: No push in a 5 element stack, isFull=false
* O: one push in a 1 element stack: isFull=true
* O: one push in a 5 element stack: isFull=false
* M: {push, push, pop, push, pop} in a 5 element stack: isFull=false
* B: 5 push in a 5 element stack, isFull=true
* E: (no exceptions thrown)
* */

	@Test void FullZero(){
		assertEquals(false, stack5.isFull());
	}

	@Test void FullOne1(){
		assertEquals(true, stack1.isFull());
	}

	@Test void FullOne5(){
		assertEquals(false, stack5.isFull());
	}

	@Test void FullMany(){
		stack5.push("One");
		stack5.pop();
		stack5.push("Two");
		stack5.push("Three");
		stack5.pop();
		assertEquals(false, stack5.isFull());
	}

	@Test void Full(){
		stack5.push("One");
		stack5.push("Two");
		stack5.push("Three");
		stack5.push("Four");
		stack5.push("Five");
		assertEquals(true, stack5.isFull());
	}

}


