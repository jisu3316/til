package com.example.oauth2loginbase.common.converters;

import com.example.oauth2loginbase.model.users.ProviderUser;
import com.example.oauth2loginbase.model.users.form.FormUser;
import com.example.oauth2loginbase.model.users.User;

public class UserDetailsProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {

    @Override
    public ProviderUser convert(ProviderUserRequest providerUserRequest) {
        if (providerUserRequest.user() == null) {
            return null;
        }

        User user = providerUserRequest.user();
        return FormUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .email(user.getEmail())
                .provider("none")
                .build();
    }
}
