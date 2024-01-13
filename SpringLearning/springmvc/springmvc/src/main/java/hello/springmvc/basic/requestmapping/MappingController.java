package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {
    @RequestMapping(value = {"/hello-basic","/hello-go"}, method = RequestMethod.GET)
    public String helloBasic(){
        log.debug("hello-Basic");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.debug("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.debug("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping2/{userId}")
    public String mappingPathTwo(@PathVariable String userId) {
        log.debug("mapping2Path userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String userId,
                              @PathVariable("orderId") Long orderId) {
        log.debug("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=han")
    public String mappingPath() {
        log.debug("mapping-param-success");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=han")
    public String mappingHeader() {
        log.debug("mapping-header-success");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.debug("mapping-Consumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduce() {
        log.debug("mapping-Produces");
        return "ok";
    }
}
