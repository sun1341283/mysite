package cn.luischen.service.user.impl;

import cn.luischen.dao.UserDao;
import cn.luischen.model.UserDomain;
import cn.luischen.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void login() {
        String username = "zhangsan";
        String password = "123";
        final UserDomain userDomain = new UserDomain();
        userDomain.setUsername(username);
        userDomain.setPassword(password);
        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.getUserInfoByCond(Mockito.argThat( argument -> argument.equals(username)),
                Mockito.anyString()))
                .thenReturn(userDomain);
        UserService userService = new UserServiceImpl(userDao);
        Assertions.assertEquals(userDomain, userService.login(username, password));
    }
}