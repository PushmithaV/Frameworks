package login.com.actitime.demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.Generic_methods;
@Listeners(com.actitime.utility.ListenersClass.class)
public class LoginPage extends Generic_methods{	

@Test
public void login()
{
	setDatato("username", "admin");
	
}

}
