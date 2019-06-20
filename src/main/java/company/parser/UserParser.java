package company.parser;

import company.User;

public class UserParser
{
    public User stringToUser(String userStr)
    {
        String [] userAttributes = userStr.split(User.USER_SEPARATOR);
        Long id = Long.parseLong(userAttributes[0]);
        String login = userAttributes[1];
        String password = userAttributes[2];

        return new User(id,login,password);
    }
}
