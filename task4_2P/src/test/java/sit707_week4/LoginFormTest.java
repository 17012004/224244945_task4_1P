package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * Based on given Main.java and LoginForm.java logic.
 * @author Vansh Kumar
 */
public class LoginFormTest 
{
	@Test
	public void testStudentIdentity() {
		String studentId = "S224244945";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Vansh Kumar";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
    public void testFailEmptyUsernameAndEmptyPassword() {
		LoginStatus status = LoginForm.login(null, null);
		System.out.println("[Empty username, empty password] >> " + status);
		Assert.assertFalse(status.isLoginSuccess());
    }

	@Test
    public void testFailEmptyUsernameWrongPassword() {
		LoginStatus status = LoginForm.login(null, "xyz");
		System.out.println("[Empty username, wrong password] >> " + status);
		Assert.assertFalse(status.isLoginSuccess());
    }

	@Test
    public void testFailWrongUsernameWrongPassword() {
		LoginStatus status = LoginForm.login("abc", "xyz");
		System.out.println("[Wrong username, wrong password] >> " + status);
		Assert.assertFalse(status.isLoginSuccess());
    }

	@Test
    public void testFailCorrectUsernameEmptyPassword() {
		LoginStatus status = LoginForm.login("ahsan", null);
		System.out.println("[Correct username, empty password] >> " + status);
		Assert.assertFalse(status.isLoginSuccess());
    }

	@Test
    public void testFailCorrectUsernameWrongPassword() {
		LoginStatus status = LoginForm.login("ahsan", "xyz");
		System.out.println("[Correct username, wrong password] >> " + status);
		Assert.assertFalse(status.isLoginSuccess());
    }

	@Test
    public void testFailEmptyUsernameCorrectPassword() {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		System.out.println("[Empty username, correct password] >> " + status);
		Assert.assertFalse(status.isLoginSuccess());
    }

	@Test
    public void testFailWrongUsernameCorrectPassword() {
		LoginStatus status = LoginForm.login("abc", "ahsan_pass");
		System.out.println("[Wrong username, correct password] >> " + status);
		Assert.assertFalse(status.isLoginSuccess());
    }

	@Test
    public void testSuccessCorrectUsernameAndPassword() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		System.out.println("[Correct username, correct password] >> " + status);
		Assert.assertTrue(status.isLoginSuccess());
	}

	@Test
    public void testValidationEmptyCode() {
		Assert.assertFalse("Empty code should fail", LoginForm.validateCode(null));
	}

	@Test
    public void testValidationWrongCode() {
		Assert.assertFalse("Wrong code should fail", LoginForm.validateCode("abcd"));
	}

	@Test
    public void testValidationCorrectCode() {
		Assert.assertTrue("Correct code should pass", LoginForm.validateCode("123456"));
	}
}