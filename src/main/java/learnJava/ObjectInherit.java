/**
 * <p> @(#)ObjectInherit.java, 2013-10-15. </p>
 * 
 * Copyright 2013 RenRen, Inc. All rights reserved.
 */
package learnJava;

/**
 *
 * @author wmc
 *
 */
public class ObjectInherit {

	@Override
	public boolean equals(Object c)
	{
		throw new AssertionError();
	}
	
	public void testInstanceof(Object c)
	{
		if (c instanceof String) {
			System.out.println("");
		}
	}
}
