package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger MyLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logdemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        MyLogger.setRequestURL(requestURL);

        MyLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
