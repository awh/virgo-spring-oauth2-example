package org.antispin.example.virgo.oauth2.protectedresource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TreasureController {

    @RequestMapping(value="treasure", method = RequestMethod.GET)
    @ResponseBody
    public String getTreasure() {
        return "Five gold bars";
    }
    
}
