package login.com.actitime.demo;

import org.testng.annotations.Test;

import com.actitime.demo.BaseClass;
import com.actitime.demo.Generic_methods;

public class LoginPage extends Generic_methods{
	

@Test
public void login()
{
	setDatato("username", "admin");
	
}

}
