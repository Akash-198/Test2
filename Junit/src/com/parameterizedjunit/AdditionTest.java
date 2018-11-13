package com.parameterizedjunit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.demojunit.Addition;

@RunWith(Parameterized.class) 
public class AdditionTest { 
private int a; 
private int b; 
private int sum; 
public AdditionTest(int a, int b, int sum) { 
this.a=a; 
this.b=b; 
this.sum=sum; 
} 
@BeforeClass 
public static void executeBefore() { 
System.out.println("Testing Addition starting"); 
} 
@Before 
public void executeBeforeTestCase() { 
System.out.println("Test method starting"); 
} 
@Test 
public void addIntTest() { 
Addition addition = new Addition(); 
int sum = addition.add(a, b); 
Assert.assertEquals(this.sum, sum); 
} 
@After 
public void executeAfterTestCase() { 
System.out.println("Test methods ending"); 
} 
@AfterClass 
public static void executeAfter() { 
System.out.println("Testing Addition ending"); 
} 
@Parameters 
public static Collection<Object[]> inputsAndOutputs() { 
return Arrays.asList(new Object[][] { 
{1,2,3}, 
{5,5,10}, 
{7,3,10}, 
{-4,5,1} 
}); 
} 
} 

