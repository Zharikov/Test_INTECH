package com.intech.forum.controllers;

import com.intech.forum.repositories.TopicRepository;
import com.intech.forum.entities.Topic;
import com.intech.forum.entities.User;
import com.intech.forum.repositories.AnswerRepository;
import com.intech.forum.repositories.UserRepository;
import com.intech.forum.PageModel;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TopicsController {


    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    @Autowired
    private PageModel pageModel;
    @Autowired
    public TopicsController(UserRepository userRepository, TopicRepository topicRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.answerRepository = answerRepository;
    }
    /*
    @GetMapping("/topics")
    public String getAllDirectors(Model model) {
        pageModel.setSIZE(8);
        pageModel.initPageAndSize();
        PageRequest p = new PageRequest(pageModel.getPAGE()+1, pageModel.getSIZE());
                model.addAttribute("directors", topicRepository.findAll(p));
        return "topics";
    }
    @RequestMapping(value = {"/topics"}, method = RequestMethod.GET)
    public String showPage(Model model, @RequestParam(defaultValue = "0") int page){
        System.out.println("page^:" + page);
        model.addAttribute("data",topicRepository.findAll(new PageRequest(page,4)));
        model.addAttribute("currentPage",page);
        return "index";
    }*/
    @GetMapping("/topics")
    public String displayAllTopics(Model model) {
        //Page<Topic> page = topicRepository.findAll(pageable);
       // model.addAttribute("data", topicRepository.findAll(new Pageable(page,4) {
        //}));
        List<Topic> topics = topicRepository.findAll(new Sort(Sort.Direction.DESC, "createdDate"));        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User user = userRepository.getUserByUsername(username);
        model.addAttribute("header", "Все темы");
        model.addAttribute("user", user);
        model.addAttribute("topics", topics);
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }
    @PostMapping("/save")
    public String save(Topic topic){
    topicRepository.save(topic);
    return "redirect:/";
    }
    @GetMapping("/delete")
    public String deleteTopic(Integer id){
        topicRepository.delete(Long.valueOf(id));
        return "redirect:/";
    }
    @GetMapping("/findOne")
    @ResponseBody
    public String findOne(Integer id){
        topicRepository.findOne(Long.valueOf(id));
        return "redirect:/";
    }

    @GetMapping("topics/user/{id}")
    public String displayTopicsByUser(@PathVariable String id, Model model) {
        List<Topic> topics = topicRepository.findTopicsByUser_IdOrderByCreatedDateDesc(Long.valueOf(id));
        User user = userRepository.getUserById(Long.valueOf(id));
        model.addAttribute("topics", topics);
        model.addAttribute("header", "Все темы пользователя " + user.getUsername());
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }
}