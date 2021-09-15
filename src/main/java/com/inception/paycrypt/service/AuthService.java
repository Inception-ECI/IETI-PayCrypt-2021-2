package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.TokenDto;
import com.inception.paycrypt.model.User;

public interface AuthService {

    TokenDto generateToken(User user);
}
