package com.juaracoding.edo2springbootrestapi.core.security;

import com.juaracoding.edo2springbootrestapi.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private UsrService usrService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String token = null;
        String userName = null;
        /*
            Langkah pertama otentikasi token
         */
        if(authorization != null && authorization.startsWith("Bearer "))
        {
            token = authorization.substring(7);//memotong setelah kata Bearer+spasi = 7 digit
            userName = jwtUtility.getUsernameFromToken(token);
        }

        /*
            Jika langkah pertama berhasil (userName nya di dapat dari token maka lanjut ke langkah ini)
         */
        if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userDetails = usrService.loadUserByUsername(userName);
            if(jwtUtility.validateToken(token,userDetails))
            {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}