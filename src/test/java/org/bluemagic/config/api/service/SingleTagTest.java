package org.bluemagic.config.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.bluemagic.config.api.tag.SingleTag;
import org.bluemagic.config.api.tag.Tag.Encoding;
import org.junit.Test;

public class SingleTagTest {

	@Test
	public void testUrlSafeString() throws Exception {
		
		SingleTag st = new SingleTag();
		st.setValue("butters=@sucker");
		//assertEquals("butters%3D%40sucker", st.toUrlSafeString());
	}
	
	@Test
	public void testFileSystemSafeString() throws Exception {
		
		SingleTag st = new SingleTag();
		st.setValue("butters/sucker");
		assertEquals("butterssucker", st.toString(Encoding.FILE));
	}
	
	@Test
	public void checkValue() {
		
		SingleTag st = new SingleTag();
		st.setValue("value");
		
		assertEquals("value", st.getValue());
	}
	
	@Test
	public void checkValueWithConstructor() {
		
		SingleTag st = new SingleTag("value");
		
		assertEquals("value", st.getValue());
	}
	
	@Test
	public void checkEquals() {
		
		SingleTag st1 = new SingleTag("value");
		SingleTag st2 = new SingleTag("value");
		assertEquals(st1, st2);
		
		st1 = new SingleTag("value");
		st2 = new SingleTag("value");
		assertEquals(st1, st1);
		
		st1 = new SingleTag("value");
		st2 = new SingleTag("value");
		assertTrue(st1.equals(st2));
		
		st1 = new SingleTag("different");
		st2 = new SingleTag("value");
		assertFalse(st1.equals(st2));
		
		st1 = new SingleTag("different");
		st2 = new SingleTag("value");
		assertFalse(st2.equals(st1));
	}

	@Test
	public void checkToString() {
		SingleTag st = new SingleTag("value");
		assertEquals("value", st.toString());
	}
}
