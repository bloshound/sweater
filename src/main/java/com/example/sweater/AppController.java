package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;


@Controller
public class AppController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting1")// адрес после URL кудв мепится запрос
    public String greeting1(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
                            @RequestParam(value = "age", required = false, defaultValue = "10") int age,
                            Map<String, Object> model) {
        model.put("name", name);
        model.put("age", age);
        return "greeting1";// возвращаемый темплайт шаблон ( в данном случае mustache)
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam("text") String text,
                      @RequestParam("tag") String tag,
                      Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }
}
