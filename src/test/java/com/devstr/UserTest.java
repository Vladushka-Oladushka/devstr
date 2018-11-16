package com.devstr;

import com.devstr.model.User;
import com.devstr.model.enumerations.UserRole;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    private User userA;
    private User userB;
    private User userC;
    private User userD;
    private User userE;
    private User userF;

    @Before
    public void setUp() throws Exception {
        userA = User.builder()
                .setUserId(101)
                .setLogin("jim101")
                .setFirstName("Jimmy")
                .setLastName("Neutron")
                .setEmail("jim@neo.net")
                .setRole(UserRole.DEVELOPER)
                .build();
        userB = User.builder()
                .setUserId(103)
                .setLogin("bob103")
                .setFirstName("Bobby")
                .setLastName("Wood")
                .setEmail("bo@stick.net")
                .setRole(UserRole.PROJECT_MANAGER)
                .build();
        userC = User.builder()
                .setUserId(101)
                .setLogin("jim101")
                .setFirstName("Anna")
                .setLastName("Karenina")
                .setRole(UserRole.TECHNICAL_MANAGER)
                .setHireDate(LocalDate.now())
                .build();
        userD = User.builder()
                .setUserId(103)
                .setLogin("bob103")
                .setHireDate(LocalDate.now())
                .build();
        userE = User.builder()
                .setUserId(101)
                .setLogin("robin")
                .build();
        userF = User.builder()
                .setUserId(103)
                .setLogin("carter")
                .build();
    }

    @Test
    public void whenUsersHaveSameIdAndLogin_equals() {
        assertEquals(userA, userC);
        assertEquals(userB, userD);
    }

    @Test
    public void whenUsersHaveSameIdButDifLogin_notEquals() {
        assertNotEquals(userA, userE);
        assertNotEquals(userC, userE);
        assertNotEquals(userB, userF);
        assertNotEquals(userD, userF);
    }

}
