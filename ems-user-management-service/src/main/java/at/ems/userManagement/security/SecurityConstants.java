package at.ems.userManagement.security;

public final class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/login";

    // Generated by: http://www.allkeysgenerator.com/ to generate all kinds of keys
    public static final String JWT_SECRET = "/B?E(H+MbQeShVmYq3t6w9z$C&F)J@NcRfUjWnZr4u7x!A%D*G-KaPdSgVkYp2s5";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "at.ems";
    public static final String TOKEN_AUDIENCE = "ems";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
