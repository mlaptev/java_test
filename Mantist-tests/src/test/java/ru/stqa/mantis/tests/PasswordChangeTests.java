package ru.stqa.mantis.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class PasswordChangeTests {


    public class PasswordChangeTests extends TestBase {

        @BeforeMethod
        public void Precondition() {

            if (app.db().users().size() <= 1) {
                app.mail().start();
                long now = System.currentTimeMillis();
                String email = "email" + now + "@localhost.localdomain";
                String user = "user" + now;
                String pass = "pass";
                app.user().registry(email, user, pass);
                app.mail().stop();

            }
            app.mail().start();
        }


        @Test
        public void testPasswordChange() throws IOException, MessagingException {

            UserData user = app.db().users().iterator().next();
            if (user.getLogin() == "administrator") {
                user = app.db().users().iterator().next();
            }

            String email = user.getEmail();
            String newPassword = "newPassword";

            app.admin().resetUserPassword(user);

            String confirmationLink = app.admin().getConfirmationLink(email);
            app.timeout(5);
            app.registration().finish(confirmationLink, newPassword);
            assertTrue(app.newSession().login(user.getLogin(), newPassword));
        }


        @AfterMethod(alwaysRun = true)
        public void stopMailServer() {
            app.mail().stop();
        }
    }

