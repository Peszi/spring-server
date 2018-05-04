package com.shutter.springserver.handler;

//@Slf4j
//@Component
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) {
//        System.err.println("HERE" + request.getRemoteAddr() + e.getMessage());
//        response.setDied(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        try {
//            response.getWriter().write(e.getMessage());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//
//}