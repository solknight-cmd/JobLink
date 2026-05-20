package com.niit.JobLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/jobs") //All Joblink links start with /job
public class JobController {

    private final JobService jobService;
    
    // Chapter 3: Constructor Injection with @Qualifier perfectly implemented
    @Autowired
    public JobController(@Qualifier("RealJobSource") JobService jobService) {
        this.jobService = jobService; 
    }
    
    @GetMapping("/board")
    public String showJobBoard() {
        // FIXED: Corrected the syntax for String.join 
        // It takes the delimiter first, and the List/Array second
        String listItems = String.join("</li><li style='padding:10px; border-bottom:1px solid #ddd;'>", 
            jobService.getAvailableJobs()
        );
        
        // FIXED: Multi-line strings formatted correctly, added missing '<', fixed '50px' typo
        return "<html>" +
               "<body style='font-family:sans-serif; background:#f0f2f5; display:flex; justify-content:center; padding:50px;'>" +
               "  <div style='background:white; width:400px; padding:30px; border-radius:15px; box-shadow:0 10px 20px rgba(0,0,0,0.1);'>" +
               "    <h2 style='color:#1a237e; border-bottom:3px solid #1a237e; padding-bottom:10px; margin-top:0;'>Joblink Dashboard</h2>" + 
               "    <ul style='padding:0; list-style:none;'>" +
               "      <li style='padding:10px; border-bottom:1px solid #ddd;'>" + listItems + "</li>" + 
               "    </ul>" + 
               "    <p style='font-size:10px; color:gray; text-align:center; margin-bottom:0;'>Wired via Spring Chapter 3 DI</p>" + 
               "  </div>" +
               "</body>" +
               "</html>";
    }
}