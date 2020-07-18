package CSCI5308.GroupFormationTool.Questions;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuestionManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionManagerController.class);

    private static final String ID = "id";
    private static final String ORDERBY = "by";

    @GetMapping("/question/questionmanager")
    public String displayQuestions(@RequestParam(name = ORDERBY) String orderBy, Model model) {
        IQuestionBankPersistence questionBankDb = SystemConfig.instance().getQuestionBankPersistence();
        List<QuestionBank> questions = questionBankDb.getallQuestions(orderBy);
        model.addAttribute("questions",questions);
        return "/question/questionmanager";
    }

    @GetMapping("/question/deletequestion")
    public ModelAndView deleteQuestion(Model model, @RequestParam(name = ID) int questionID)
    {
        System.out.println("In here"+questionID);
        IQuestionBankPersistence questionBankDb = SystemConfig.instance().getQuestionBankPersistence();
        boolean result = questionBankDb.deleteQuestionById(questionID);
        ModelAndView mod = null;
        if(result){
           mod = new ModelAndView("redirect:/question/questionmanager?by=questionTitle");
        } else{
            // send to error page
            System.out.println("return to error page");

        }
        
        return mod;
    }
}
