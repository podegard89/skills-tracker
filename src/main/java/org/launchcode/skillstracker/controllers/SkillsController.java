package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SkillsController {

    public static String html;

    @GetMapping
    @ResponseBody
    public String startSkills() {
        return "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>VisualBasic</li>" +
                "<li>JavaScript</li>" +
                "</ol>";
    }

    @GetMapping("/form")
    @ResponseBody
    public String skillForm() {
        return "<form method='post'>" +
                "Name:" +
                "<input type='text' name='username'/>" +
                "<br>My favorite language:<br>" +
                "<select name='first'>" +
                "<option>Java</option>" +
                "<option>VisualBasic</option>" +
                "<option>JavaScript</option>" +
                "</select>" +
                "<br>My second favorite language:<br>" +
                "<select name='second'>" +
                "<option>Java</option>" +
                "<option>VisualBasic</option>" +
                "<option>JavaScript</option>" +
                "</select>" +
                "<br>My third favorite language:<br>" +
                "<select name='third'>" +
                "<option>Java</option>" +
                "<option>VisualBasic</option>" +
                "<option>JavaScript</option>" +
                "</select><br>" +
                "<input type='submit'>" +
                "</form>";
    }

    @PostMapping("/form")
    @ResponseBody
    // name --> String
    // favorite --> String
    // second --> String
    // third --> String
    public RedirectView formResults(@RequestParam String username, @RequestParam String first, @RequestParam String second, @RequestParam String third) {
        html = "<h1>" + username + "</h1>" +
                "<ol>" +
                "<li>" + first + "</li>" +
                "<li>" + second + "</li>" +
                "<li>" + third + "</li>" +
                "</ol>";
        return new RedirectView("/results");
    }

    @GetMapping("/results")
    @ResponseBody
    public String results() {
        return html;
    }
}
