package com.shutter.springserver.handler;

//@Slf4j
////@Component
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        System.err.println("commence" + request.getRemoteAddr() + authException.getMessage());
//        response.setDied(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        try {
//            response.getWriter().write(authException.getMessage());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//}
