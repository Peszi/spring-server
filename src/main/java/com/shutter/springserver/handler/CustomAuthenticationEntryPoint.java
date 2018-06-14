package com.shutter.springserver.handler;

//@Slf4j
////@Component
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse dto, AuthenticationException authException) throws IOException, ServletException {
//        System.err.println("commence" + request.getRemoteAddr() + authException.getMessage());
//        dto.setAlive(HttpServletResponse.SC_UNAUTHORIZED);
//        dto.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        dto.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        try {
//            dto.getWriter().write(authException.getMessage());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//}
