package com.love.lovebackend.Controllers;


import com.love.lovebackend.models.GetLoveInput;
import com.love.lovebackend.models.GetLoveOutput;
import com.love.lovebackend.services.ILoveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("love")
public class LoveController {
    private final ILoveService loveService;

    public LoveController(ILoveService loveService) {
        this.loveService = loveService;
    }

    @GetMapping("index")
    public GetLoveOutput showLove(GetLoveInput input) {
        // instantiate output
        GetLoveOutput result = new GetLoveOutput();
        
        // call our service to generate the output
        String outputMessage = loveService.showLove(input.getMessage());

        // set output
        result.setMessage(outputMessage);

        // return output
        return result;
    }
}
