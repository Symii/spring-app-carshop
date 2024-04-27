package me.symi.carshop.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.symi.carshop.entity.Customer;
import me.symi.carshop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private UserService userService;

    public CustomAuthenticationSuccessHandler(UserService theUserService) {
        userService = theUserService;
        setAlwaysUseDefaultTargetUrl(false);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);
        System.out.println("User has been successfully logged in.");

        String email = authentication.getName();

        System.out.println("userName=" + email);

        //Customer theUser = userService.findByEmail(email);
        // now place in the session
        //HttpSession session = request.getSession();
        //session.setAttribute("user", theUser);

        // forward to home page
        //response.sendRedirect(request.getContextPath() + "/");
    }

}
