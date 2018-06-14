package com.shutter.springserver.handler;

//@Slf4j
//@Component
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse dto, AccessDeniedException e) {
//        System.err.println("HERE" + request.getRemoteAddr() + e.getMessage());
//        dto.setAlive(HttpServletResponse.SC_UNAUTHORIZED);
//        dto.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        dto.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        try {
//            dto.getWriter().write(e.getMessage());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//
//}